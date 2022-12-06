package com.example.affablebean;

import com.example.affablebean.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AffableBeanApplication implements CommandLineRunner {

    private final ProductService productService;

    public AffableBeanApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AffableBeanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productService.createDb();

        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from product");
        JPAUtil.checkData("select * from customer");
        JPAUtil.checkData("select * from customer_order");
        JPAUtil.checkData("select * from order_products");
    }
}
