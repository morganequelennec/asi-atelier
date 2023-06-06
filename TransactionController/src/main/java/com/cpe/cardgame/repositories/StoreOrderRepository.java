package com.cpe.cardgame.repositories;


import com.cpe.cardgame.entity.StoreOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreOrderRepository extends JpaRepository<StoreOrder, Integer> {
    // Additional custom methods can be defined here if needed
    Page<StoreOrder> findAll(Pageable pageable);

    List<StoreOrder> findAllByUserId(Integer userId);

    Page<StoreOrder> findAllByUserId(Integer userId, Pageable pageable);

    @Query(value = "SELECT * FROM store_order o WHERE o.user_id = :userId AND o.card_id = :cardId", nativeQuery = true)
    StoreOrder getStoreOrderByUserAndCardId(@Param("userId") Integer userId, @Param("cardId") Integer cardId);
}