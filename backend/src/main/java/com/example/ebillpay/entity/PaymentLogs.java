package com.example.ebillpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class PaymentLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @ManyToOne
    @JoinColumn(name = "connectionIdPay",nullable = false)
    private Connections connectionsPayment;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String orderId;
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String paymentSignature;

}
