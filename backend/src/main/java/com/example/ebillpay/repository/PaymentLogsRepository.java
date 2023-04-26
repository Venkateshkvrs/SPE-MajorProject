package com.example.ebillpay.repository;

import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.PaymentLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentLogsRepository extends JpaRepository<PaymentLogs, Integer> {
    @Query("select c from PaymentLogs c where c.connectionsPayment.customer.customerId=?1")
    List<PaymentLogs> paymentHistory(Integer customerId);
}
