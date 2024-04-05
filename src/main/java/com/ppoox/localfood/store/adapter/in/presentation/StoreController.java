package com.ppoox.localfood.store.adapter.in.presentation;

import com.ppoox.localfood.store.application.port.in.presentation.StorePresentationPort;
import com.ppoox.localfood.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StorePresentationPort storePresentationPort;

    @GetMapping(path = "", produces = { "application/hal+json" })
    public CollectionModel<StoreModel> getOrders() {
        List<Store> orders = storePresentationPort.getStores();

        List<StoreModel> orderModels = new ArrayList<>();
        for (Store order : orders) {
            StoreModel orderModel = new StoreModel();
            BeanUtils.copyProperties(order, orderModel);
            orderModels.add(orderModel);
        }

        Link link = linkTo(StoreController.class).withSelfRel();
        return CollectionModel.of(orderModels, link);
    }

    @PostMapping(path = "", produces = { "application/hal+json" })
    public StoreModel updateProduct(@RequestBody CreateStoreDto createStoreDto) {
        Store store = storePresentationPort.createStore(createStoreDto);

        StoreModel storeModel = new StoreModel();
        BeanUtils.copyProperties(store, storeModel);

        Link link = linkTo(StoreController.class).withSelfRel();
        storeModel.add(link);

        return storeModel;
    }

    @PatchMapping(path = "/product", produces = { "application/hal+json" })
    public StoreModel updateProduct(@RequestBody UpdateProductDto updateProductDto) {
        Store store = storePresentationPort.updateProduct(updateProductDto);

        StoreModel storeModel = new StoreModel();
        BeanUtils.copyProperties(store, storeModel);

        Link link = linkTo(StoreController.class).withSelfRel();
        storeModel.add(link);

        return storeModel;
    }
}
