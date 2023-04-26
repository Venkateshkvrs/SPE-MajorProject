package com.example.ebillpay.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentLogsDTO {
    private Integer connectionId;
    private String orderId;
    private String id;
    private String paymentSignature;
}
