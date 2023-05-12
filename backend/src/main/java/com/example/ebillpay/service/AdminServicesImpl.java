package com.example.ebillpay.service;

import com.example.ebillpay.dto.BillsLogsDTO;
import com.example.ebillpay.dto.OfficerDTO;
import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.Connections;
import com.example.ebillpay.entity.Customer;
import com.example.ebillpay.entity.Officer;
import com.example.ebillpay.repository.BillsRepository;
import com.example.ebillpay.repository.ConnectionRepository;
import com.example.ebillpay.repository.LoginRepository;
import com.example.ebillpay.repository.OfficerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Slf4j

@RequiredArgsConstructor
public class AdminServicesImpl implements AdminServices{


    private final OfficerRepository officerRepository;
    public OfficerDTO loginOfficer(String userName, String password) {
        Officer officer = officerRepository.findOneByUserNameAndPassword(userName, password);
        if (officer != null) {
            OfficerDTO officerDTO=OfficerDTO.builder()
                    .mobileNumber(officer.getMobileNumber())
                    .area(officer.getArea())
                    .officerName(officer.getOfficerName())
                    .email(officer.getEmail())
                    .officerId(officer.getOfficerId())
                    .role(officer.getRole())
                    .build();
            log.info("Officer ["+officerDTO.getOfficerId()+"] Successfully Logged in to the system.");
            return officerDTO;
        }
        log.info("Invalid Officer Login attempted with credentials: ["+userName+"]");
        return null;
    }


    private final LoginRepository loginRepository;
    private final ConnectionRepository connectionRepository;
    public Integer addConnections(Integer customerId,Integer approvedOfficerId){
        Customer customer= loginRepository.findByCustomerId(customerId);
        Date date = Date.valueOf(LocalDate.now());
//        System.out.println(customer);
        Connections connections=Connections.builder()
                .customer(customer)
                .conection_date(date)
                .officerID(approvedOfficerId)
                .status(1)
                .charges(0)
                .build();
//        System.out.println(connections);
        connectionRepository.save(connections);
        log.info("New Connection Added to Cust.Id. ["+customerId+"], Generated connection-id:["+connections.getConnectionId()+"]");
        return connections.getConnectionId();
    }


    private final BillsRepository billsRepository;
    public Integer addBill(BillsLogsDTO billsLogsDTO){
        Connections connections=connectionRepository.findByConnectionId(billsLogsDTO.getConnectionsId());
        Date date = Date.valueOf(LocalDate.now());
        BillsLogs billsLogs=BillsLogs.builder()
                .amount(billsLogsDTO.getAmount())
                .officerId(billsLogsDTO.getOfficerId())
                .date(date)
                .connections(connections)
                .duration(billsLogsDTO.getDuration())
                .description(billsLogsDTO.getDescription())
                .build();
        billsRepository.save(billsLogs);

//        Integer connectionCharges=0;
//        if(connections.getCharges()!=null)connectionCharges=connections.getCharges();
        Integer charges=connections.getCharges()+billsLogsDTO.getAmount();
        connectionRepository.updateCharges(connections.getConnectionId(),charges);
        log.info("New Bill Added to Connection Id. ["+billsLogsDTO.getConnectionsId()+"], Generated bill-id:["+billsLogs.getBillslogsId()+"]");

        return billsLogs.getBillslogsId();
    }
}