package com.example.affablebean.ds;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product extends IdClass{


    private String name;
    private double price;
    private String description;
    private LocalDate lastUpdate;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Product() {

    }

    public Product(String name, double price, String description, LocalDate lastUpdate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdate = lastUpdate;
    }

    public void addOrderProduct(OrderProduct orderProduct) {
        orderProduct.setProduct(this);
        this.orderProducts.add(orderProduct);
    }

}
