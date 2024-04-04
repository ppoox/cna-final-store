package com.ppoox.localfood.store.adapter.out.persistence;

import com.ppoox.localfood.store.domain.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "stores", itemResourceRel = "store", path = "store")
public interface StoreRepository extends CrudRepository<Store, Long> {

    Optional<Store> findByIdAndProductId(Long id, Long productId);
}
