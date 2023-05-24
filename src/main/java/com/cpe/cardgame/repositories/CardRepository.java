package com.cpe.cardgame.repositories;

import com.cpe.cardgame.model.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    // Additional custom methods can be defined here if needed
    Page<Card> findAll(Pageable pageable);

    List<Card> findAllByUserId(Integer userId);

    Page<Card> findAllByUserId(Integer userId, Pageable pageable);
}