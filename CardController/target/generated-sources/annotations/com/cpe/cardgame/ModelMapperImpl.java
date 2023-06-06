package com.cpe.cardgame;

import com.cpe.cardgame.entity.Card;
import fr.dtoin.CardIn;
import fr.dtoout.CardOut;
import fr.viewmodel.CardForm;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T18:22:09+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public Card convert(CardIn user) {
        if ( user == null ) {
            return null;
        }

        Card card = new Card();

        return card;
    }

    @Override
    public Card convert(CardOut user) {
        if ( user == null ) {
            return null;
        }

        Card card = new Card();

        card.setOriginalHp( user.getOriginalHp() );
        card.setToSell( user.getToSell() );
        card.setId( user.getId() );
        card.setName( user.getName() );
        card.setDescription( user.getDescription() );
        card.setFamily( user.getFamily() );
        card.setAffinity( user.getAffinity() );
        card.setImgUrl( user.getImgUrl() );
        card.setSmallImgUrl( user.getSmallImgUrl() );
        card.setEnergy( user.getEnergy() );
        card.setHp( user.getHp() );
        card.setAttack( user.getAttack() );
        card.setPrice( user.getPrice() );
        card.setUserId( user.getUserId() );

        return card;
    }

    @Override
    public Card convert(CardForm user) {
        if ( user == null ) {
            return null;
        }

        Card card = new Card();

        card.setToSell( user.getToSell() );
        card.setId( user.getId() );
        card.setName( user.getName() );
        card.setDescription( user.getDescription() );
        card.setFamily( user.getFamily() );
        card.setAffinity( user.getAffinity() );
        card.setImgUrl( user.getImgUrl() );
        card.setSmallImgUrl( user.getSmallImgUrl() );
        card.setEnergy( user.getEnergy() );
        card.setHp( user.getHp() );
        card.setDefence( user.getDefence() );
        card.setAttack( user.getAttack() );
        card.setPrice( user.getPrice() );
        card.setUserId( user.getUserId() );

        return card;
    }

    @Override
    public CardForm convert(Card user) {
        if ( user == null ) {
            return null;
        }

        CardForm cardForm = new CardForm();

        cardForm.setId( user.getId() );
        cardForm.setToSell( user.getToSell() );
        cardForm.setName( user.getName() );
        cardForm.setDescription( user.getDescription() );
        cardForm.setFamily( user.getFamily() );
        cardForm.setAffinity( user.getAffinity() );
        cardForm.setImgUrl( user.getImgUrl() );
        cardForm.setSmallImgUrl( user.getSmallImgUrl() );
        cardForm.setEnergy( user.getEnergy() );
        cardForm.setHp( user.getHp() );
        cardForm.setDefence( user.getDefence() );
        cardForm.setAttack( user.getAttack() );
        cardForm.setPrice( user.getPrice() );
        cardForm.setUserId( user.getUserId() );

        return cardForm;
    }

    @Override
    public CardIn convertToIn(Card user) {
        if ( user == null ) {
            return null;
        }

        CardIn cardIn = new CardIn();

        return cardIn;
    }

    @Override
    public CardOut convertToOut(Card user) {
        if ( user == null ) {
            return null;
        }

        CardOut cardOut = new CardOut();

        cardOut.setId( user.getId() );
        cardOut.setName( user.getName() );
        cardOut.setDescription( user.getDescription() );
        cardOut.setFamily( user.getFamily() );
        cardOut.setAffinity( user.getAffinity() );
        cardOut.setImgUrl( user.getImgUrl() );
        cardOut.setSmallImgUrl( user.getSmallImgUrl() );
        cardOut.setEnergy( user.getEnergy() );
        cardOut.setHp( user.getHp() );
        cardOut.setToSell( user.getToSell() );
        cardOut.setUserId( user.getUserId() );
        cardOut.setPrice( user.getPrice() );
        cardOut.setOriginalHp( user.getOriginalHp() );
        cardOut.setAttack( user.getAttack() );

        return cardOut;
    }
}
