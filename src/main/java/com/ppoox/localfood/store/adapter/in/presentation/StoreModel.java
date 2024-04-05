package com.ppoox.localfood.store.adapter.in.presentation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class StoreModel extends RepresentationModel<StoreModel> {

    private Long id;
    private Long productId;
    private String productName;
    private int stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedBy;

}
