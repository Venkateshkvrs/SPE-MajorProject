package com.example.ebillpay.repository;

import com.example.ebillpay.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Customer, Integer> {

    Customer findOneByUserNameAndPassword(String userName, String password);
    Customer findByCustomerId(Integer customerId);
}
