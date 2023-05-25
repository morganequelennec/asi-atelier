package com.cpe.cardgame.model;

import jakarta.persistence.*;

@Entity
public class PlayParty {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIdA() {
        return userIdA;
    }

    public void setUserIdA(Integer userIdA) {
        this.userIdA = userIdA;
    }

    public Integer getUserIdB() {
        return userIdB;
    }

    public void setUserIdB(Integer userIdB) {
        this.userIdB = userIdB;
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id_a")
    private Integer userIdA;

    @Column(name = "user_id_b")
    private Integer userIdB;

    private String partyCode;

    private Boolean started;

    @Column(name = "winner_id")
    private Integer winnerId;
    

}