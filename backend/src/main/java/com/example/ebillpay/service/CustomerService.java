package com.example.ebillpay.service;

import com.example.ebillpay.dto.ConnectionDTO;
import com.example.ebillpay.dto.CustomerDTO;
import com.example.ebillpay.dto.PaymentLogsDTO;
import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.Connections;
import com.example.ebillpay.entity.Customer;
import com.example.ebillpay.entity.PaymentLogs;
import com.razorpay.RazorpayException;

import java.util.List;

public interface CustomerService {
    Integer addCustomer(Customer customer);

    CustomerDTO loginCustomer(String userName, String password);

    List<ConnectionDTO> getConnections(Integer customerId);

    List<BillsLogs> getBills(Integer customerId);

    String pay(Integer amount, Integer connectionId) throws RazorpayException;
    Integer savePay(PaymentLogsDTO paymentLogsDTO);

    List<PaymentLogs> paymentHistory(Integer customerId);

//    List<Connections> billsDetails(Integer customerId);
//
//    List<Connections> unpaidDetails(Integer customerId);
}
