package com.ppoox.localfood.store.domain.event;

import com.ppoox.localfood.store.infrastructure.kafka.AbstractEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderCanceledEvent extends AbstractEvent {

    private Long orderId;

    public OrderCanceledEvent(Object aggregate) {
        super(aggregate);
    }

}
