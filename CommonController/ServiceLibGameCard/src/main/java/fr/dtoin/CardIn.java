package fr.dtoin;

import fr.model.Card;

public class CardIn {
    private Integer id;

    private String name;
    private String description;
    private String family;
    private String affinity;
    private String imgUrl;
    private String smallImgUrl;
    private Double energy;
    private Double hp;

    public Card toCard() {
        Card card = new Card();
        card.setId(this.id);
        card.setName(this.name);
        card.setDescription(this.description);
        card.setFamily(this.family);
        card.setAffinity(this.affinity);
        card.setImgUrl(this.imgUrl);
        card.setSmallImgUrl(this.smallImgUrl);
        card.setEnergy(this.energy);
        card.setHp(this.hp);
        return card;
    }
}