package com.aegarland.sample.vending.fulfillment.service;

import com.aegarland.sample.vending.fulfillment.domain.Product;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by aeg on 3/2/2016.
 */
@RepositoryRestResource(collectionResourceRel = "product", exported = true)
public interface ProductRepository
        extends org.springframework.data.repository.Repository<Product,Integer> {
    List<Product> findAll();
    Product findOne(Integer id);
}
