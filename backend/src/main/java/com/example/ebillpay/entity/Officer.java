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
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer officerId;
    @Column(nullable = false)
    private String officerName;
    @Column(nullable = false)
    private String area;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
}
