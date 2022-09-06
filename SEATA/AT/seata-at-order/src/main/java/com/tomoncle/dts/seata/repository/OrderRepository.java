package com.tomoncle.dts.seata.repository;

import com.tomoncle.dts.seata.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
