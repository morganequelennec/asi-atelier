package com.cpe.cardgame.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "store_transaction")
public class StoreTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "card_id")
    private Integer cardId;

    private String action;

    private LocalDateTime timestamp;

    // Getters and setters
}
