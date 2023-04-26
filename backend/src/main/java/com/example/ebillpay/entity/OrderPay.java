package com.example.ebillpay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class OrderPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderRequestId;

    @Column(nullable = false)
    private Integer connectionId;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Integer attempts;
    @Column(nullable = false)
    private String receiptId;
}
