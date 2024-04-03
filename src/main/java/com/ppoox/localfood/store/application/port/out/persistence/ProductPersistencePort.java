package com.ppoox.localfood.store.application.port.out.persistence;

import com.ppoox.localfood.store.domain.Product;

import java.util.Optional;

public interface ProductPersistencePort {

    Optional<Product> findById(Long id);

    Product save(Product product);
}
