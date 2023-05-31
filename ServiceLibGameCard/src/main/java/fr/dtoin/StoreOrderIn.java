package fr.dtoin;

import jakarta.persistence.Column;

public class StoreOrderIn {
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }


    private Integer userId;

    private Integer cardId;
}