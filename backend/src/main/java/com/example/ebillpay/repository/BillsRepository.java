package com.example.ebillpay.repository;

import com.example.ebillpay.entity.BillsLogs;
import com.example.ebillpay.entity.Connections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillsRepository extends JpaRepository<BillsLogs, Integer> {
    @Query("select c from BillsLogs c where c.connections.connectionId=?1")
    List<BillsLogs> findByConnectionId(Integer connectionId);

    @Query("select c from BillsLogs c order by c.BillslogsId desc limit 1")
    BillsLogs findLatestBill(Integer connectionId);
//    List<Connections> findByCustomerId(Integer customerId);
//
//    @Query("select b from Connections b where b.customerId=?1 and b.status=1")
//    List<Connections> unpaidBills(Integer customerId);
}
