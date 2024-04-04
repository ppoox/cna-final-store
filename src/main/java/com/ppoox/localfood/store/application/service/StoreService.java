package com.ppoox.localfood.store.application.service;

import com.ppoox.localfood.store.application.port.in.presentation.StorePresentationPort;
import com.ppoox.localfood.store.application.port.out.persistence.StorePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService implements StorePresentationPort {

    private final StorePersistencePort storePersistencePort;

}
