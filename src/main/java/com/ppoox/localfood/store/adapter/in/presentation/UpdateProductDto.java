package com.ppoox.localfood.store.adapter.in.presentation;

import com.ppoox.localfood.store.domain.Store;
import lombok.Getter;

@Getter
public class UpdateProductDto {

    private Long id;
    private Long productId;
    private String productName;

    public Store toEntity() {
        return Store.builder()
                .id(id)
                .productId(productId)
                .productName(productName)
                .build();
    }
}
