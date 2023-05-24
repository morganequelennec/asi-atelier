package com.cpe.cardgame.repositories;

import com.cpe.cardgame.model.StoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOrderRepository extends JpaRepository<StoreOrder, Integer> {
    // Additional custom methods can be defined here if needed
}