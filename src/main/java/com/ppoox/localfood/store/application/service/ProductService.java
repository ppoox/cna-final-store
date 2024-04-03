package com.ppoox.localfood.store.application.service;

import com.ppoox.localfood.store.application.port.in.presentation.ProductPresentationPort;
import com.ppoox.localfood.store.application.port.out.persistence.ProductPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductPresentationPort {

    private final ProductPersistencePort productPersistencePort;

}
