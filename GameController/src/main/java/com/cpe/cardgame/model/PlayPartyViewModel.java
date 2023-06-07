package com.cpe.cardgame.model;


import fr.dtoin.CardIn;

import java.util.List;

public class PlayPartyViewModel {


    public PlayParty getPlayParty() {
        return playParty;
    }

    public void setPlayParty(PlayParty playParty) {
        this.playParty = playParty;
    }

    public List<CardIn> getCardUserList() {
        return cardUserList;
    }

    public void setCardUserList(List<CardIn> cardUserList) {
        this.cardUserList = cardUserList;
    }

    public List<CardIn> getPlayerCardsA() {
        return playerCardsA;
    }

    public void setPlayerCardsA(List<CardIn> playerCardsA) {
        this.playerCardsA = playerCardsA;
    }

    public List<CardIn> getPlayerCardsB() {
        return playerCardsB;
    }

    public void setPlayerCardsB(List<CardIn> playerCardsB) {
        this.playerCardsB = playerCardsB;
    }

    private PlayParty playParty;
    private List<CardIn> cardUserList;
    private List<CardIn> playerCardsA;
    private List<CardIn> playerCardsB;

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public Double getWinnerGain() {
        return winnerGain;
    }

    public void setWinnerGain(Double winnerGain) {
        this.winnerGain = winnerGain;
    }

    private String winnerName = "";
    private Double winnerGain = 0.0;

    public Integer getPlayerWinnerSide() {
        return playerWinnerSide;
    }

    public void setPlayerWinnerSide(Integer playerWinnerSide) {
        this.playerWinnerSide = playerWinnerSide;
    }

    private Integer playerWinnerSide = -1;

}