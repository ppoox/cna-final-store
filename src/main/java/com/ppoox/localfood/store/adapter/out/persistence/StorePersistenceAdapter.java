package com.ppoox.localfood.store.adapter.out.persistence;

import com.ppoox.localfood.store.application.port.out.persistence.StorePersistencePort;
import com.ppoox.localfood.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StorePersistenceAdapter implements StorePersistencePort {

    private final StoreRepository storeRepository;

    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    public Optional<Store> findByIdAndProductId(Long id, Long productId) {
        return storeRepository.findByIdAndProductId(id, productId);
    }

    public Store save(Store store) {
        return storeRepository.save(store);
    }
}
