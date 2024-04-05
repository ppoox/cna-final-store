package com.ppoox.localfood.store.application.service;

import com.ppoox.localfood.store.adapter.in.presentation.CreateStoreDto;
import com.ppoox.localfood.store.adapter.in.presentation.UpdateProductDto;
import com.ppoox.localfood.store.application.port.in.presentation.StorePresentationPort;
import com.ppoox.localfood.store.application.port.out.persistence.StorePersistencePort;
import com.ppoox.localfood.store.domain.Store;
import com.ppoox.localfood.store.domain.event.ProductChangeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService implements StorePresentationPort {

    private final StorePersistencePort storePersistencePort;
    private final StreamBridge streamBridge;

    @Override
    public Store updateProduct(UpdateProductDto updateProductDto) {
        Store store = storePersistencePort.findByIdAndProductId(updateProductDto.getId(), updateProductDto.getProductId())
                .orElseThrow();
        store.changeProductName(updateProductDto.getProductName());

        Store updatedStore = storePersistencePort.save(store);

        streamBridge.send("productChanged-out-0", new ProductChangeEvent(updatedStore));
        return updatedStore;
    }

    @Override
    public Store createStore(CreateStoreDto createStoreDto) {
        return storePersistencePort.save(createStoreDto.toEntity());
    }

    @Override
    public List<Store> getStores() {
        return storePersistencePort.findAll();
    }
}
