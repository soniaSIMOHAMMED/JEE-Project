package com.springboot.application.use_cases.order.exposition;

import com.springboot.application.use_cases.product.domain.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    public Long orderId;
    public String test;

    //private List<Product> products;

}
