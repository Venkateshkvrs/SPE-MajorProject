package com.example.ebillpay.service;

import com.example.ebillpay.dto.ConnectionDTO;
import com.example.ebillpay.dto.CustomerDTO;
import com.example.ebillpay.dto.PaymentLogsDTO;
import com.example.ebillpay.entity.*;
import com.example.ebillpay.repository.*;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final LoginRepository loginRepo;
    private final ConnectionRepository connectionRepository;
    private final BillsRepository billsRepository;
    private final OrderRepository orderRepository;
    private final PaymentLogsRepository paymentLogsRepository;
    public Integer addCustomer(Customer customer){
        loginRepo.save(customer);
        log.info("New Customer Registered. Cust.Id. Generated is:["+customer.getCustomerId()+"]");
        return customer.getCustomerId();
    }

    public CustomerDTO loginCustomer(String userName, String password) {
        Customer customer = loginRepo.findOneByUserNameAndPassword(userName, password);
        if (customer != null) {
            CustomerDTO customerDTO=CustomerDTO.builder()
                    .customerId(customer.getCustomerId())
                    .address(customer.getAddress())
                    .email(customer.getEmail())
                    .lastName(customer.getLastName())
                    .firstName(customer.getFirstName())
                    .mobileNumber(customer.getMobileNumber())
                    .build();
            log.info("Customer ["+customerDTO.getCustomerId()+"] Successfully Logged in to the system.");
            return customerDTO;
        }
        log.info("Invalid Login attempted with credentials: ["+userName+"]");
        return null;
    }

    public List<ConnectionDTO> getConnections(Integer customerId){
        List<Connections> connections=connectionRepository.findConnections(customerId);
        List<ConnectionDTO> connectionDTO=new ArrayList<>();
        for(Connections c:connections){
            BillsLogs billsLogs=billsRepository.findLatestBill(c.getConnectionId());
            ConnectionDTO connectionDTO1=ConnectionDTO.builder()
                    .connectionsId(c.getConnectionId())
                    .connection_start_date(c.getConection_date())
                    .currentDue(c.getCharges())
                    .pvsBillDate((billsLogs != null && billsLogs.getDate() != null) ? billsLogs.getDate() : null)
                    .approvedOfficer(c.getOfficerID())
                    .build();
            connectionDTO.add(connectionDTO1);
        }
        log.info("All Connections of Customer: ["+customerId+"] is requested and thus, sent.");
        return connectionDTO;
    }

    public List<BillsLogs> getBills(Integer customerId){
        List<Integer> connectionId=connectionRepository.findByCustomerId(customerId);
        List<BillsLogs> billsLogs=new ArrayList<>();
        for(Integer i:connectionId){
            List<BillsLogs> billsLogs1=billsRepository.findByConnectionId(i);
            if(billsLogs1.size()!=0)
                billsLogs.addAll(billsLogs1);
        }
        log.info("All Bills of Customer's Power Connections: ["+customerId+"] is requested and thus, sent.");
        return billsLogs;
    }


//    private final OrderRepository orderRepository;
//    private final OrderRepository orderRepository;
    public String pay(Integer amount, Integer connectionId) throws RazorpayException {
        RazorpayClient instance = new RazorpayClient("rzp_test_kRPj6ppuSwuqJP", "YkQtIjKFO8ayAf9fJlda3l9W");
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount*100);
            orderRequest.put("currency", "INR");

            String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";

            Random random = new Random();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                int index = random.nextInt(CHARACTERS.length());
                builder.append(CHARACTERS.charAt(index));
            }
            orderRequest.put("receipt", builder.toString());
            JSONObject notes = new JSONObject();
            notes.put("notes_key_1", "Tea, Earl Grey, Hot");
            notes.put("notes_key_1", "Tea, Earl Grey, Hot");
            orderRequest.put("notes", notes);

            Order order = instance.orders.create(orderRequest);
            System.out.println(order);

            String status=order.get("status");
            System.out.println(status);

            OrderPay orderPay=OrderPay.builder()
                    .orderId(order.get("id"))
                    .status(order.get("status"))
                    .amount(order.get("amount"))
                    .connectionId(connectionId)
                    .attempts(order.get("attempts"))
                    .receiptId(builder.toString())
                    .build();
            orderRepository.save(orderPay);
            log.info("Payment Order Request to Connection: ["+connectionId+"] and Amount: ["+amount+"] thus, made.");
            return order.toString();
        } catch (RazorpayException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Integer savePay(PaymentLogsDTO paymentLogsDTO){
        Connections connections=connectionRepository.findByConnectionId(paymentLogsDTO.getConnectionId());
        OrderPay orderPay=orderRepository.findByOrderId(paymentLogsDTO.getOrderId());
        Date date = Date.valueOf(LocalDate.now());
        PaymentLogs paymentLogs=PaymentLogs.builder()
                .connectionsPayment(connections)
                .orderId(paymentLogsDTO.getOrderId())
                .id(paymentLogsDTO.getId())
                .paymentSignature(paymentLogsDTO.getPaymentSignature())
                .amount(orderPay.getAmount())
                .date(date)
                .build();
        paymentLogsRepository.save(paymentLogs);

        orderPay.setStatus("paid");
        orderRepository.save(orderPay);

        connectionRepository.payComplete(paymentLogsDTO.getConnectionId());
        log.info("Payment Details saved for Order: ["+paymentLogs.getOrderId()+"] is Order Id.");
        return paymentLogs.getPaymentId();
    }

    public List<PaymentLogs> paymentHistory(Integer customerId){
        List<PaymentLogs> paymentLogs = paymentLogsRepository.paymentHistory(customerId);
        log.info("All Payment Bills History of Customer's Power Connections: ["+customerId+"] is requested and thus, sent.");
        return paymentLogs;
    }
}
