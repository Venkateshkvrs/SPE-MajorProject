package com.example.ebillpay.repository;

import com.example.ebillpay.entity.Customer;
import com.example.ebillpay.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    Officer findOneByUserNameAndPassword(String userName, String password);
}
