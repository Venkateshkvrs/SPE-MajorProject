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
public class OfficerDTO {
    private Integer officerId;
    private String officerName;
    private String area;
    private String email;
    private String mobileNumber;
    private String role;
}
