package com.ppoox.localfood.store.adapter.out.persistence;

import com.ppoox.localfood.store.application.port.out.persistence.StorePersistencePort;
import com.ppoox.localfood.store.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StorePersistenceAdapter implements StorePersistencePort {

    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Optional<Store> findByIdAndProductId(Long id, Long productId) {
        return storeRepository.findByIdAndProductId(id, productId);
    }

    @Override
    public Store save(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }
}
