package com.example.ebillpay;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EBillPayApplication {

    public static void main(String[] args) throws RazorpayException {
        SpringApplication.run(EBillPayApplication.class, args);
    }
}
