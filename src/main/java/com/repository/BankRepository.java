package com.repository;

import com.entity.Bank;
import com.entity.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
    boolean existsBankByBic(String Bic);

    Bank findById(long id);

    boolean existsBankByAccount(String account);

    Bank findByTreasury(Treasury treasury);

    @Override
    @Query("SELECT  e FROM Bank e WHERE e.exist=true ")
    List<Bank> findAll();
}
