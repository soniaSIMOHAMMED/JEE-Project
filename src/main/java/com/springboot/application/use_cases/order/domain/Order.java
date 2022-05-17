package com.springboot.application.use_cases.order.domain;

import com.springboot.application.use_cases.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table( name = "orders")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "test")
    private String test;

/*    @OneToMany(mappedBy = "order")
    private List<Product> products;*/

}
