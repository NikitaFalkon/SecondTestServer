package com.repository;

import com.entity.Document;
import com.model.Result;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DocumentCrudRepository extends CrudRepository<Document, Long> {
    @Query("select recipientOrganization.cname, payerOrganization.cname, amount from Document where guid = ?1")
    String find(String guid);

    @Query("SELECT  AVG(amount) FROM Document")
    BigDecimal findAmount();
}