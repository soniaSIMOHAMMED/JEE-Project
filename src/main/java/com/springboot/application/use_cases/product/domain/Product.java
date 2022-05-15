package com.springboot.application.use_cases.product.domain;

import com.springboot.application.use_cases.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table( name = "products")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column( name = "product_name", nullable = false )
    private String productName;

    @Column( name = "fragrance", nullable = false )
    private String fragrance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
