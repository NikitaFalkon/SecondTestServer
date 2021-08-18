package com.repository;

import com.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("select recipientOrganization.cname, payerOrganization.cname, amount from Document where guid = ?1")
    String find(String guid);

    @Query("SELECT  AVG(amount) FROM Document where exist=true")
    BigDecimal findAmount();

    @Override
    @Query("SELECT  e FROM Document e WHERE e.exist=true ")
    List<Document> findAll();

    Document findById(long id);
}
