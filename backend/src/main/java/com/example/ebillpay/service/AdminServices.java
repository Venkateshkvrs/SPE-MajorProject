package com.example.ebillpay.service;

import com.example.ebillpay.dto.BillsLogsDTO;
import com.example.ebillpay.dto.OfficerDTO;
import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.Connections;
import com.example.ebillpay.entity.Officer;

public interface AdminServices {
    Integer addConnections(Integer customerId,Integer officerId);

    Integer addBill(BillsLogsDTO billsLogsDTO);
//
    OfficerDTO loginOfficer(String userName, String password);
}
