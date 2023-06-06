package com.cpe.cardgame;

import com.cpe.cardgame.entity.StoreOrder;
import com.cpe.cardgame.entity.StoreTransaction;
import fr.dtoin.CardIn;
import fr.dtoin.StoreOrderIn;
import fr.dtoin.StoreTransactionIn;
import fr.dtoin.UserIn;
import fr.dtoout.CardOut;
import fr.dtoout.StoreOrderOut;
import fr.dtoout.StoreTransactionOut;
import fr.dtoout.UserOut;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T22:08:19+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public StoreTransactionIn convertToIn(StoreTransaction user) {
        if ( user == null ) {
            return null;
        }

        StoreTransactionIn storeTransactionIn = new StoreTransactionIn();

        storeTransactionIn.setUserId( user.getUserId() );
        storeTransactionIn.setCardId( user.getCardId() );
        storeTransactionIn.setAction( user.getAction() );
        storeTransactionIn.setTimestamp( user.getTimestamp() );

        return storeTransactionIn;
    }

    @Override
    public StoreTransactionOut convertToOut(StoreTransaction user) {
        if ( user == null ) {
            return null;
        }

        StoreTransactionOut storeTransactionOut = new StoreTransactionOut();

        storeTransactionOut.setId( user.getId() );
        storeTransactionOut.setUserId( user.getUserId() );
        storeTransactionOut.setCardId( user.getCardId() );
        storeTransactionOut.setAction( user.getAction() );
        storeTransactionOut.setTimestamp( user.getTimestamp() );

        return storeTransactionOut;
    }

    @Override
    public StoreTransaction convert(StoreTransactionIn user) {
        if ( user == null ) {
            return null;
        }

        StoreTransaction storeTransaction = new StoreTransaction();

        storeTransaction.setUserId( user.getUserId() );
        storeTransaction.setCardId( user.getCardId() );
        storeTransaction.setAction( user.getAction() );
        storeTransaction.setTimestamp( user.getTimestamp() );

        return storeTransaction;
    }

    @Override
    public StoreTransaction convert(StoreTransactionOut user) {
        if ( user == null ) {
            return null;
        }

        StoreTransaction storeTransaction = new StoreTransaction();

        storeTransaction.setId( user.getId() );
        storeTransaction.setUserId( user.getUserId() );
        storeTransaction.setCardId( user.getCardId() );
        storeTransaction.setAction( user.getAction() );
        storeTransaction.setTimestamp( user.getTimestamp() );

        return storeTransaction;
    }

    @Override
    public StoreOrderIn convertToIn(StoreOrder user) {
        if ( user == null ) {
            return null;
        }

        StoreOrderIn storeOrderIn = new StoreOrderIn();

        storeOrderIn.setUserId( user.getUserId() );
        storeOrderIn.setCardId( user.getCardId() );

        return storeOrderIn;
    }

    @Override
    public StoreOrderOut convertToOut(StoreOrder user) {
        if ( user == null ) {
            return null;
        }

        StoreOrderOut storeOrderOut = new StoreOrderOut();

        storeOrderOut.setId( user.getId() );
        storeOrderOut.setUserId( user.getUserId() );
        storeOrderOut.setCardId( user.getCardId() );

        return storeOrderOut;
    }

    @Override
    public StoreOrder convert(StoreOrderIn user) {
        if ( user == null ) {
            return null;
        }

        StoreOrder storeOrder = new StoreOrder();

        storeOrder.setUserId( user.getUserId() );
        storeOrder.setCardId( user.getCardId() );

        return storeOrder;
    }

    @Override
    public StoreOrder convert(StoreOrderOut user) {
        if ( user == null ) {
            return null;
        }

        StoreOrder storeOrder = new StoreOrder();

        storeOrder.setId( user.getId() );
        storeOrder.setUserId( user.getUserId() );
        storeOrder.setCardId( user.getCardId() );

        return storeOrder;
    }

    @Override
    public UserOut convert(UserIn user) {
        if ( user == null ) {
            return null;
        }

        UserOut userOut = new UserOut();

        userOut.setSession( user.getSession() );
        userOut.setLogin( user.getLogin() );
        userOut.setPwd( user.getPwd() );
        userOut.setAccount( user.getAccount() );
        userOut.setLastName( user.getLastName() );
        userOut.setSurName( user.getSurName() );
        userOut.setEmail( user.getEmail() );

        return userOut;
    }

    @Override
    public UserIn convert(UserOut user) {
        if ( user == null ) {
            return null;
        }

        String session = null;
        String login = null;
        String pwd = null;
        Double account = null;
        String lastName = null;
        String surName = null;
        String email = null;

        session = user.getSession();
        login = user.getLogin();
        pwd = user.getPwd();
        account = user.getAccount();
        lastName = user.getLastName();
        surName = user.getSurName();
        email = user.getEmail();

        UserIn userIn = new UserIn( login, pwd, account, lastName, surName, email, session );

        return userIn;
    }

    @Override
    public CardIn convert(CardOut user) {
        if ( user == null ) {
            return null;
        }

        CardIn cardIn = new CardIn();

        cardIn.setName( user.getName() );
        cardIn.setDescription( user.getDescription() );
        cardIn.setFamily( user.getFamily() );
        cardIn.setAffinity( user.getAffinity() );
        cardIn.setImgUrl( user.getImgUrl() );
        cardIn.setSmallImgUrl( user.getSmallImgUrl() );
        cardIn.setEnergy( user.getEnergy() );
        cardIn.setHp( user.getHp() );
        cardIn.setPrice( user.getPrice() );
        cardIn.setOriginalHp( user.getOriginalHp() );
        cardIn.setUserId( user.getUserId() );
        cardIn.setToSell( user.getToSell() );

        return cardIn;
    }

    @Override
    public CardOut convert(CardIn user) {
        if ( user == null ) {
            return null;
        }

        CardOut cardOut = new CardOut();

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

        return cardOut;
    }
}
