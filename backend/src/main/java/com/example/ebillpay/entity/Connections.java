package com.example.ebillpay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Connections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer connectionId;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;
    private Integer charges;
    private Integer status;
    @Column(nullable = false)
    private Date conection_date;
    @Column(nullable = false)
    private Integer officerID;

    @OneToMany(mappedBy = "connections",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BillsLogs> billsLogs;


    @OneToMany(mappedBy = "connectionsPayment",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PaymentLogs> paymentLogs;
}
