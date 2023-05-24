package com.cpe.cardgame.repositories;

import com.cpe.cardgame.model.StoreTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreTransactionRepository extends JpaRepository<StoreTransaction, Integer> {
    // Additional custom methods can be defined here if needed
}