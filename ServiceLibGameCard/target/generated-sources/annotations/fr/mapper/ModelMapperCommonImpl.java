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
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T15:44:04+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ModelMapperCommonImpl implements ModelMapperCommon {

    @Override
    public CardIn convert(CardOut user) {
        if ( user == null ) {
            return null;
        }

        CardIn cardIn = new CardIn();

        return cardIn;
    }

    @Override
    public CardOut convert(CardIn user) {
        if ( user == null ) {
            return null;
        }

        CardOut cardOut = new CardOut();

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

        Integer id = null;

        PartyOut partyOut = new PartyOut( id, userIdA, userIdB, partyCode, started, winnerId, currentPlayerId, cardPlayerA, cardPlayerB );

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

        Integer id = null;

        UserOut userOut = new UserOut( id, login, pwd, account, lastName, surName, email, session );

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
