package com.example.ebillpay.repository;

import com.example.ebillpay.entity.Connections;
import com.example.ebillpay.entity.OrderPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderPay, Integer> {
    @Query("select c from OrderPay c where c.orderId=?1")
    OrderPay findByOrderId(String orderId);
}
