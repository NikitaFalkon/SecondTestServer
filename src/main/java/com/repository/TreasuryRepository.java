package com.repository;

import com.entity.Treasury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreasuryRepository extends JpaRepository<Treasury, Long> {
    Treasury findById(long id);

    Treasury findByAcc(String acc);

    @Override
    @Query("SELECT  e FROM Treasury e WHERE e.exist=true ")
    List<Treasury> findAll();
}
