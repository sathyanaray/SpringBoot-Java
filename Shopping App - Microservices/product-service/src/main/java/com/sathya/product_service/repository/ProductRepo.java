package com.sathya.product_service.repository;

import com.sathya.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,String> {
}
