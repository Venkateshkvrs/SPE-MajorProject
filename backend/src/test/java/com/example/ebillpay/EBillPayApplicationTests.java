//package com.example.ebillpay;
//
//import com.example.ebillpay.entity.Customer;
//import com.example.ebillpay.repository.LoginRepository;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//
//@SpringBootTest
//class EBillPayApplicationTests {
//
//    @Before("")
//    public void setup() {
//        // Setup any mock data or behavior here
//    }
//
//    @Test
//    public void testLoginCustomer() {
//        String userName = "vaishu";
//        String password = "vaishu";
//
//        Customer mockCustomer = new Customer();
//        mockCustomer.setAddress("123 Main St");
//        mockCustomer.setEmail("vaishnavi@gmail.com");
//        mockCustomer.setFirstName("Vashnavi");
//        mockCustomer.setLastName("Gangarde");
//        mockCustomer.setMobileNumber("9865321470");
//        mockCustomer.setPassword("vaishu");
//        mockCustomer.setUserName("vaishu");
//
//        LoginRepository mockRepo = mock(LoginRepository.class);
//        when(mockRepo.findOneByUserNameAndPassword("vaishu", "vaishu")).thenReturn(mockCustomer);
//
//        Customer result = mockRepo.findOneByUserNameAndPassword("vaishu","vaishu");
//        assertNotNull(result);
//        assertEquals(mockCustomer.getCustomerId(), result.getCustomerId());
//        assertEquals(mockCustomer.getFirstName(), result.getFirstName());
//        assertEquals(mockCustomer.getLastName(), result.getLastName());
//        assertEquals(mockCustomer.getEmail(), result.getEmail());
//        assertEquals(mockCustomer.getMobileNumber(), result.getMobileNumber());
//        assertEquals(mockCustomer.getAddress(), result.getAddress());
//    }
//
//}