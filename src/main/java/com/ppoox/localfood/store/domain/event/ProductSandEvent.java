package com.ppoox.localfood.store.domain.event;

import com.ppoox.localfood.store.infrastructure.kafka.AbstractEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ProductSandEvent extends AbstractEvent {

    private Long orderId;
    private Long storeId;
    private Long productId;
    private String address;

    public ProductSandEvent(Object aggregate) {
        super(aggregate);
    }

}
