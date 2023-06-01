package com.cpe.cardgame;

import com.cpe.cardgame.entity.Card;
import fr.dtoin.CardIn;
import fr.dtoin.UserIn;
import fr.dtoout.CardOut;
import fr.dtoout.UserOut;
import fr.viewmodel.CardForm;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T20:30:47+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
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
    public UserIn convertToIn(Card user) {
        if ( user == null ) {
            return null;
        }

        String login = null;
        String pwd = null;
        Double account = null;
        String lastName = null;
        String surName = null;
        String email = null;
        String session = null;

        UserIn userIn = new UserIn( login, pwd, account, lastName, surName, email, session );

        return userIn;
    }

    @Override
    public UserOut convertToOut(Card user) {
        if ( user == null ) {
            return null;
        }

        Integer id = null;

        id = user.getId();

        String login = null;
        String pwd = null;
        Double account = null;
        String lastName = null;
        String surName = null;
        String email = null;
        String session = null;

        UserOut userOut = new UserOut( id, login, pwd, account, lastName, surName, email, session );

        return userOut;
    }
}
