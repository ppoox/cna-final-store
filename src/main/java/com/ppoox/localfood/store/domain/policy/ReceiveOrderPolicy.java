package com.ppoox.localfood.store.domain.policy;

import com.ppoox.localfood.store.application.port.out.persistence.StorePersistencePort;
import com.ppoox.localfood.store.domain.event.OrderCanceledEvent;
import com.ppoox.localfood.store.domain.event.Ordered;
import com.ppoox.localfood.store.domain.event.ProductSandEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ReceiveOrderPolicy {

    private final StorePersistencePort storePersistencePort;
    private final StreamBridge streamBridge;

    @Bean
    public Consumer<Message<Ordered>> receiveOrder() {

        return message -> {
            System.out.println("TEST " + message);
            MessageHeaders headers = message.getHeaders();
            if (!"ordered".equals(headers.get(KafkaHeaders.RECEIVED_TOPIC))) {
                return;
            }

            Ordered payload = message.getPayload();

            OrderCanceledEvent orderCanceledEvent = new OrderCanceledEvent();
            orderCanceledEvent.setOrderId(payload.getId());

            if (payload.getProductId() == null) {
                return;
            }

            storePersistencePort.findByIdAndProductId(payload.getStoreId(), payload.getProductId()).ifPresentOrElse(product -> {
                if (product.getStock() - payload.getQuantity() < 0) {
                    // 재고없음
                    streamBridge.send("orderCanceled-out-0", orderCanceledEvent);
                } else {
                    product.decreaseStock(payload.getQuantity());
                    storePersistencePort.save(product);

                    ProductSandEvent productSandEvent = new ProductSandEvent();
                    productSandEvent.setOrderId(payload.getId());
                    productSandEvent.setStoreId(payload.getStoreId());
                    productSandEvent.setProductId(payload.getProductId());
                    productSandEvent.setAddress("서울시 서초구 효령로 147");
                    streamBridge.send("productSand-out-0", productSandEvent);
                }
            }, () -> {
                streamBridge.send("orderCanceled-out-0", orderCanceledEvent);
            }); // 존재하지 않는 상품
        };
    }
}
