package com.example.ebillpay.repository;

import com.example.ebillpay.entity.Connections;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connections, Integer> {
    Connections findByConnectionId(Integer connectionsId);

    @Modifying
    @Transactional
    @Query("update Connections set charges=?2 where connectionId=?1")
    public void updateCharges(Integer connectionId,Integer charges);

//    @Modifying
//    @Transactional
//    @Query("update Connections c set c.total=coalesce(c.penalty,0)+c.charges where c.connectionId=?1")
//    public void updateTotal(Integer connectionId);

    @Query("select c from Connections c where c.customer.customerId=?1")
    List<Connections> findConnections(Integer customerId);

    @Query("select c.connectionId from Connections c where c.customer.customerId=?1")
    List<Integer> findByCustomerId(Integer customerId);

    @Modifying
    @Transactional
    @Query("update Connections set charges=0 where connectionId=?1")
    public void payComplete(Integer connectionId);
}
