package com.springboot.application.use_cases.order.infrastructure;

import com.springboot.application.use_cases.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
