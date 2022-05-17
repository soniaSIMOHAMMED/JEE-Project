package com.springboot.application.use_cases.order.domain;

import com.springboot.application.use_cases.product.domain.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "order")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

}
