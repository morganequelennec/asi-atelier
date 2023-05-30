package fr.viewmodel.dto;

import fr.model.Card;
import fr.model.PlayParty;

import java.util.List;

public class PlayPartyViewModel {


    public PlayParty getPlayParty() {
        return playParty;
    }

    public void setPlayParty(PlayParty playParty) {
        this.playParty = playParty;
    }

    public List<Card> getCardUserList() {
        return cardUserList;
    }

    public void setCardUserList(List<Card> cardUserList) {
        this.cardUserList = cardUserList;
    }

    public List<Card> getPlayerCardsA() {
        return playerCardsA;
    }

    public void setPlayerCardsA(List<Card> playerCardsA) {
        this.playerCardsA = playerCardsA;
    }

    public List<Card> getPlayerCardsB() {
        return playerCardsB;
    }

    public void setPlayerCardsB(List<Card> playerCardsB) {
        this.playerCardsB = playerCardsB;
    }

    private PlayParty playParty;
    private List<Card> cardUserList;
    private List<Card> playerCardsA;
    private List<Card> playerCardsB;

}