package com.example.ebillpay.dto;

import com.example.ebillpay.entity.Connections;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillsLogsDTO {
    private Integer connectionsId;
    private Integer amount;
    private Integer officerId;
    private Integer duration;
    private String description;
}
