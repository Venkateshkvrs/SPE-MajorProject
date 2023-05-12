//package com.example.ebillpay;
//
//import com.example.ebillpay.dto.OfficerDTO;
//import com.example.ebillpay.entity.Officer;
//import com.example.ebillpay.repository.BillsRepository;
//import com.example.ebillpay.repository.ConnectionRepository;
//import com.example.ebillpay.repository.LoginRepository;
//import com.example.ebillpay.repository.OfficerRepository;
//import com.example.ebillpay.service.AdminServices;
//import com.example.ebillpay.service.AdminServicesImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class EBillPayApplicationTests {
//
//    @Mock
//    private OfficerRepository officerRepository;
//
//    private AdminServices adminServices;
//
//
//    @Mock
//    private LoginRepository loginRepository;
//    @Mock
//    private ConnectionRepository connectionRepository;
//    @Mock
//    private BillsRepository billsRepository;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        adminServices = new AdminServicesImpl(officerRepository,loginRepository,connectionRepository,billsRepository);
//    }
//
//    @Test
//    public void testLoginOfficer_ValidCredentials_ReturnsOfficerDTO() {
//        // Arrange
//        String userName = "admin";
//        String password = "password";
//        Officer officer = new Officer();
//        officer.setMobileNumber("1234567890");
//        officer.setArea("Example Area");
//        officer.setOfficerName("John Doe");
//        officer.setEmail("john@example.com");
//        officer.setOfficerId(1);
//        officer.setRole("admin");
//        officer.setUserName("admin");
//        officer.setPassword("password");
//
//        when(officerRepository.findOneByUserNameAndPassword(userName, password)).thenReturn(officer);
//
//        // Act
//        OfficerDTO result = adminServices.loginOfficer(userName, password);
//
//        // Assert
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(officer.getMobileNumber(), result.getMobileNumber());
//        Assertions.assertEquals(officer.getArea(), result.getArea());
//        Assertions.assertEquals(officer.getOfficerName(), result.getOfficerName());
//        Assertions.assertEquals(officer.getEmail(), result.getEmail());
//        Assertions.assertEquals(officer.getOfficerId(), result.getOfficerId());
//        Assertions.assertEquals(officer.getRole(), result.getRole());
//    }
//
//
//}
