package com.ppoox.localfood.store.adapter.in.presentation;

import com.ppoox.localfood.store.domain.Store;
import lombok.Getter;

@Getter
public class CreateStoreDto {

    private Long productId;
    private String productName;
    private int stock;

    public Store toEntity() {
        return Store.builder()
                .productId(productId)
                .productName(productName)
                .stock(stock)
                .build();
    }
}
