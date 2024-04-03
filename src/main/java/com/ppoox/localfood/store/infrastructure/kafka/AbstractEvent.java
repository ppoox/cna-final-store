package com.ppoox.localfood.store.infrastructure.kafka;

import com.ppoox.localfood.store.StoreApplication;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class AbstractEvent {

    String eventType;

    Long timestamp;

    public AbstractEvent(Object aggregate) {
        this();
        BeanUtils.copyProperties(aggregate, this);
    }

    public AbstractEvent() {
        this.eventType = this.getClass().getSimpleName();
        this.timestamp = System.currentTimeMillis();
    }

    public void publish() {
        KafkaConfig kafkaConfig = StoreApplication.applicationContext.getBean(KafkaConfig.class);
        kafkaConfig.setPayload(this);
        kafkaConfig.supply();
    }
}
