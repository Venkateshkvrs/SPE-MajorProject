package com.example.ebillpay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectionDTO {
    private Integer connectionsId;

    private Date connection_start_date;
    private Date pvsBillDate;
//    private Date pvsPaymentDate;
//    private Integer pvsPaidAmount;
    private Integer currentDue;
    private Integer approvedOfficer;
}
