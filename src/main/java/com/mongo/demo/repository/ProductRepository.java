package com.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.demo.model.Products;

@Repository
public interface ProductRepository extends MongoRepository<Products, String> {

}
