package com.cpe.cardgame.model;

public class PlayPartyCreateViewModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMise() {
        return mise;
    }

    public void setMise(Double mise) {
        this.mise = mise;
    }

    private String name;

    private Double mise;
}