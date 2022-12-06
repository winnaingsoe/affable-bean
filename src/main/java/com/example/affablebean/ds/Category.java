package com.example.affablebean.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass {

    private String name;
    @OneToMany(mappedBy = "category" ,cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        product.setCategory(this);
        this.products.add(product);
    }
}
