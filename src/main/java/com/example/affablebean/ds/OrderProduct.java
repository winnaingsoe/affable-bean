package com.example.affablebean.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_products")
public class OrderProduct extends IdClass {

    private int quantity;
    @ManyToOne
    private CustomerOrder customerOrder;
    @ManyToOne
    private Product product;
}
