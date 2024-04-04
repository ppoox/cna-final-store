package com.ppoox.localfood.store.application.port.out.persistence;

import com.ppoox.localfood.store.domain.Store;

import java.util.Optional;

public interface StorePersistencePort {

    Optional<Store> findById(Long id);

    Optional<Store> findByIdAndProductId(Long id, Long productId);

    Store save(Store store);
}
