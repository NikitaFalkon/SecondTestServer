package com.repository;

import com.entity.Bank;
import com.entity.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
    boolean existsBankByBic(String Bic);

    Bank findByBic(String Bic);

    boolean existsBankByAccount(String account);

    Bank findByTreasury(Treasury treasury);
}
