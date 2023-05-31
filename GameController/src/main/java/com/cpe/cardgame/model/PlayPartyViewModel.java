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

}