package fr.mapper;

import fr.dtoin.CardIn;
import fr.dtoin.PartyIn;
import fr.dtoin.StoreOrderIn;
import fr.dtoin.StoreTransactionIn;
import fr.dtoin.UserIn;
import fr.dtoout.CardOut;
import fr.dtoout.PartyOut;
import fr.dtoout.StoreOrderOut;
import fr.dtoout.StoreTransactionOut;
import fr.dtoout.UserOut;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T22:08:11+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
*/
public class ModelMapperCommonImpl implements ModelMapperCommon {

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

    @Override
    public PartyIn convert(PartyOut user) {
        if ( user == null ) {
            return null;
        }

        Integer userIdA = null;
        Integer userIdB = null;
        String partyCode = null;
        Boolean started = null;
        Integer winnerId = null;
        Integer currentPlayerId = null;
        Integer cardPlayerA = null;
        Integer cardPlayerB = null;

        userIdA = user.getUserIdA();
        userIdB = user.getUserIdB();
        partyCode = user.getPartyCode();
        started = user.getStarted();
        winnerId = user.getWinnerId();
        currentPlayerId = user.getCurrentPlayerId();
        cardPlayerA = user.getCardPlayerA();
        cardPlayerB = user.getCardPlayerB();

        PartyIn partyIn = new PartyIn( userIdA, userIdB, partyCode, started, winnerId, currentPlayerId, cardPlayerA, cardPlayerB );

        return partyIn;
    }

    @Override
    public PartyOut convert(PartyIn user) {
        if ( user == null ) {
            return null;
        }

        PartyOut partyOut = new PartyOut();

        partyOut.setUserIdA( user.getUserIdA() );
        partyOut.setUserIdB( user.getUserIdB() );
        partyOut.setPartyCode( user.getPartyCode() );
        partyOut.setStarted( user.getStarted() );
        partyOut.setWinnerId( user.getWinnerId() );
        partyOut.setCurrentPlayerId( user.getCurrentPlayerId() );
        partyOut.setCardPlayerA( user.getCardPlayerA() );
        partyOut.setCardPlayerB( user.getCardPlayerB() );

        return partyOut;
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
    public StoreOrderOut convert(StoreOrderIn user) {
        if ( user == null ) {
            return null;
        }

        StoreOrderOut storeOrderOut = new StoreOrderOut();

        storeOrderOut.setUserId( user.getUserId() );
        storeOrderOut.setCardId( user.getCardId() );

        return storeOrderOut;
    }

    @Override
    public StoreOrderIn convert(StoreOrderOut user) {
        if ( user == null ) {
            return null;
        }

        StoreOrderIn storeOrderIn = new StoreOrderIn();

        storeOrderIn.setUserId( user.getUserId() );
        storeOrderIn.setCardId( user.getCardId() );

        return storeOrderIn;
    }

    @Override
    public StoreTransactionOut convert(StoreTransactionIn user) {
        if ( user == null ) {
            return null;
        }

        StoreTransactionOut storeTransactionOut = new StoreTransactionOut();

        storeTransactionOut.setUserId( user.getUserId() );
        storeTransactionOut.setCardId( user.getCardId() );
        storeTransactionOut.setAction( user.getAction() );
        storeTransactionOut.setTimestamp( user.getTimestamp() );

        return storeTransactionOut;
    }

    @Override
    public StoreTransactionIn convert(StoreTransactionOut user) {
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
}
