package com.ppoox.localfood.store.adapter.out.persistence;

import com.ppoox.localfood.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "stores", itemResourceRel = "store", path = "store")
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByIdAndProductId(Long id, Long productId);
}
