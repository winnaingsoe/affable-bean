package com.example.affablebean.dao;

import com.example.affablebean.ds.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends CrudRepository<Category,Integer> {
}
