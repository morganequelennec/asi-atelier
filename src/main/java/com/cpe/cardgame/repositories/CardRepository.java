package com.cpe.cardgame.repositories;

import com.cpe.cardgame.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    // Additional custom methods can be defined here if needed
}