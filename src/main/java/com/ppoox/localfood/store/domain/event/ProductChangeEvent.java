package com.ppoox.localfood.store.domain.event;

import com.ppoox.localfood.store.infrastructure.kafka.AbstractEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductChangeEvent extends AbstractEvent {

    private Long id;
    private Long productId;
    private String productName;

    public ProductChangeEvent(Object aggregate) {
        super(aggregate);
    }

}
