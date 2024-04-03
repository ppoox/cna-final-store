package com.ppoox.localfood.store.domain.policy;

import com.ppoox.localfood.store.application.port.out.persistence.ProductPersistencePort;
import com.ppoox.localfood.store.domain.event.OrderCanceledEvent;
import com.ppoox.localfood.store.domain.event.OrderedEvent;
import com.ppoox.localfood.store.domain.event.ProductSandEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ReceiveOrderPolicy {

    private final ProductPersistencePort productPersistencePort;

    @Bean
    public Consumer<Message<OrderedEvent>> receiveOrder() {

        return message -> {
            MessageHeaders headers = message.getHeaders();
            if (!headers.containsValue("OrderedEvent")) {
                return;
            }

            OrderedEvent payload = message.getPayload();
            OrderCanceledEvent orderCanceledEvent = new OrderCanceledEvent();
            orderCanceledEvent.setOrderId(payload.getId());

            if (payload.getProductId() == null) {
                return;
            }


            productPersistencePort.findById(payload.getProductId()).ifPresentOrElse(product -> {
                if (product.getStock() - payload.getQuantity() < 0) {
                    // 재고없음
                    orderCanceledEvent.publish();
                } else {
                    product.decreaseStock(payload.getQuantity());
                    productPersistencePort.save(product);

                    ProductSandEvent productSandEvent = new ProductSandEvent();
                    productSandEvent.setOrderId(payload.getId());
                    productSandEvent.setProductId(payload.getProductId());
                    productSandEvent.setAddress("서울시 서초구 효령로 147");
                    productSandEvent.publish();
                }
            }, orderCanceledEvent::publish); // 존재하지 않는 상품
        };
    }
}
