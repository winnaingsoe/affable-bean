package com.example.affablebean.service;

import com.example.affablebean.dao.CategoryDao;
import com.example.affablebean.dao.CustomerDao;
import com.example.affablebean.ds.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ProductService {
    private final CategoryDao categoryDao;
    private final CustomerDao customerDao;

    public ProductService(CategoryDao categoryDao, CustomerDao customerDao) {
        this.categoryDao = categoryDao;
        this.customerDao = customerDao;
    }

    @Transactional
    public void createDb() {
        Category c1 = new Category();
        c1.setName("Fruits");
        Category c2 = new Category();
        c2.setName("Diary");

        Product p1 = new Product("Apple", 2000, "Fresh Fruit", LocalDate.now());
        Product p2 = new Product("Orange", 1000, "Fresh Fruit", LocalDate.now());
        Product p3 = new Product("Milk", 2000, "Fresh Diary", LocalDate.now());
        Product p4 = new Product("Butter", 2500, "Fresh Diary", LocalDate.now());

        Customer customer1 = new Customer("John Doe", "john@gmail.com","55-555-55", "Love Loane", "Yangon", "111");
        Customer customer2 = new Customer("Thomas Hardy", "hardy@gmail.com","56-555-56", "Dream Land", "Yangon", "222");

        CustomerOrder customerOrder1 = new CustomerOrder(2, LocalDate.now(),12345);
        CustomerOrder customerOrder2 = new CustomerOrder(3, LocalDate.now(),12345);
        CustomerOrder customerOrder3 = new CustomerOrder(4, LocalDate.now(),12345);
        CustomerOrder customerOrder4 = new CustomerOrder(2, LocalDate.now(),12345);

        OrderProduct orderProduct1 = new OrderProduct();
        orderProduct1.setQuantity(30);
        OrderProduct orderProduct2 = new OrderProduct();
        orderProduct2.setQuantity(20);
        OrderProduct orderProduct3 = new OrderProduct();
        orderProduct3.setQuantity(10);
        OrderProduct orderProduct4 = new OrderProduct();
        orderProduct4.setQuantity(5);

        // mapping
        c1.addProduct(p1);
        c1.addProduct(p2);
        c2.addProduct(p3);
        c2.addProduct(p4);

        customer1.addCustomerOrder(customerOrder1);
        customer1.addCustomerOrder(customerOrder2);
        customer2.addCustomerOrder(customerOrder3);
        customer2.addCustomerOrder(customerOrder4);

        customerOrder1.addOrderProduct(orderProduct1);
        p1.addOrderProduct(orderProduct1);

        customerOrder2.addOrderProduct(orderProduct2);
        p2.addOrderProduct(orderProduct2);

        customerOrder3.addOrderProduct(orderProduct3);
        p3.addOrderProduct(orderProduct3);

        customerOrder4.addOrderProduct(orderProduct4);
        p4.addOrderProduct(orderProduct4);

        categoryDao.save(c1);
        categoryDao.save(c2);

        customerDao.save(customer1);
        customerDao.save(customer2);




    }
}
