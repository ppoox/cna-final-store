package com.ppoox.localfood.store.adapter.out.persistence;

import com.ppoox.localfood.store.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products", itemResourceRel = "product", path = "product")
public interface ProductRepository extends CrudRepository<Product, Long> {
}
