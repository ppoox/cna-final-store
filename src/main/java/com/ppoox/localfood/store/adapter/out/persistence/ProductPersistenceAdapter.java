package com.ppoox.localfood.store.adapter.out.persistence;

import com.ppoox.localfood.store.application.port.out.persistence.ProductPersistencePort;
import com.ppoox.localfood.store.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
