package com.ppoox.localfood.store.domain;


import com.ppoox.localfood.store.domain.event.ProductChangeEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "st_store")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private int stock;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedBy;

    public void decreaseStock(int stock) {
        this.stock -= stock;
    }

    @PostUpdate
    public void onPostUpdate() {
        ProductChangeEvent productChangeEvent = new ProductChangeEvent(this);
        productChangeEvent.setStoreId(this.id);
//        productChangeEvent.publish();
    }

    public void changeProductName(String productName) {
        this.productName = productName;
    }
}
