package com.ppoox.localfood.store.application.port.in.presentation;

import com.ppoox.localfood.store.adapter.in.presentation.CreateStoreDto;
import com.ppoox.localfood.store.adapter.in.presentation.UpdateProductDto;
import com.ppoox.localfood.store.domain.Store;

import java.util.List;

public interface StorePresentationPort {
    Store updateProduct(UpdateProductDto updateProductDto);

    Store createStore(CreateStoreDto createStoreDto);

    List<Store> getStores();
}
