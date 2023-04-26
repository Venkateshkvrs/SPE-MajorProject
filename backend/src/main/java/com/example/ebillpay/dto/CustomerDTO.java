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
public class CustomerDTO {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String mobileNumber;
}
