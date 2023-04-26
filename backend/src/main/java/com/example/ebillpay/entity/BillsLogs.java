package com.example.ebillpay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BillsLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BillslogsId;
    @ManyToOne
    @JoinColumn(name = "connectionId",nullable = false)
    private Connections connections;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Integer amount;
    @Column(nullable = false)
    private Integer officerId;
    @Column(nullable = false)
    private Integer duration;
    @Column
    private String description;
}
