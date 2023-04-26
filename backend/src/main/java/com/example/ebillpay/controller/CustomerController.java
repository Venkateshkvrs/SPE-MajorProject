package com.example.ebillpay.controller;


import com.example.ebillpay.dto.ConnectionDTO;
import com.example.ebillpay.dto.CustomerDTO;
import com.example.ebillpay.dto.PaymentLogsDTO;
import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.Connections;
import com.example.ebillpay.entity.Customer;
import com.example.ebillpay.entity.PaymentLogs;
import com.example.ebillpay.service.CustomerService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public Integer addCustomer(@RequestBody Customer customer){
        Integer id=customerService.addCustomer(customer);
        return id;
    }

    @PostMapping("/login")
    public CustomerDTO loginCustomer(@RequestParam("userName") String userName, @RequestParam("password") String password){
        CustomerDTO customerDTO=customerService.loginCustomer(userName,password);
        return customerDTO;
    }

    @GetMapping("/connections")
    public List<ConnectionDTO> getConnections(@RequestParam Integer customerId){
        return customerService.getConnections(customerId);
    }

    @GetMapping("/get-bills")
    public List<BillsLogs> getBills(@RequestParam Integer customerId){
        return customerService.getBills(customerId);
    }

    @PostMapping("/order-request")
    public String pay(@RequestParam Integer amount, @RequestParam Integer connectionId) throws RazorpayException {
        return customerService.pay(amount,connectionId);
    }

    @PostMapping("/save-payment")
    public Integer savePayment(@RequestBody PaymentLogsDTO paymentLogsDTO){
        Integer paymentId=customerService.savePay(paymentLogsDTO);
        return paymentId;
    }

    @GetMapping("/payment-history")
    public List<PaymentLogs> paymentHistory(@RequestParam Integer customerId){
        return customerService.paymentHistory(customerId);
    }
}
