package com.repository;

import com.entity.Document;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DocumentGrudRepository extends CrudRepository<Document, Long> {
    @Query("select recipientOrganization.cname, payerOrganization.cname, amount, number from Document where guid = ?1")
    String findDocument(String guid);
    @Query("select COUNT(e) from Document e where e.recipientOrganization.cname = ?1")
    int findCountRecipient(String cname);
    @Query("select COUNT(e) from Document e where e.payerOrganization.cname = ?1")
    int findCountPay(String cname);
    @Query("SELECT SUM(e.amount)/COUNT(e) FROM Document e ")
    BigDecimal findAmount();
}
