package com.springboot.application.use_cases.product.infrastructure;

import com.springboot.application.use_cases.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByFragrance();

}
