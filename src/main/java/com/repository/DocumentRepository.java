package com.repository;

import com.entity.Document;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.math.BigDecimal;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("select recipientOrganization.cname, payerOrganization.cname, amount from Document where guid = ?1")
    String find(String guid);

    @Query("SELECT  AVG(amount) FROM Document")
    BigDecimal findAmount();
}
