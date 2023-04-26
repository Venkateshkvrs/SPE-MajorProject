package com.example.ebillpay.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Connections> connectionsList;
}
