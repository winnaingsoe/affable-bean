package com.example.affablebean.dao;

import com.example.affablebean.ds.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {
}
