package com.example.ebillpay.controller;

import com.example.ebillpay.dto.BillsLogsDTO;
import com.example.ebillpay.dto.OfficerDTO;
import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.Connections;
import com.example.ebillpay.entity.Officer;
import com.example.ebillpay.service.AdminServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class OfficerController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("/officer-login")
    public OfficerDTO officerLogin(@RequestParam("userName") String userName, @RequestParam("password") String password){
        return adminServices.loginOfficer(userName,password);
    }
    @PostMapping("/add-connection")
    public Integer addConnections(@RequestParam Integer customerId,@RequestParam Integer approvedOfficerId){
        System.out.println("xyz");
        return adminServices.addConnections(customerId,approvedOfficerId);
    }
    
    @PostMapping("/add-bill")
    public Integer addBill(@RequestBody BillsLogsDTO billsLogsDTO){
        return adminServices.addBill(billsLogsDTO);
    }
}