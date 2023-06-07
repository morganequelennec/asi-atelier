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
    date = "2023-06-07T20:00:03+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
*/
public class ModelMapperCommonImpl implements ModelMapperCommon {

    @Override
    public CardIn convert(CardOut user) {
        if ( user == null ) {
            return null;
        }

        CardIn cardIn = new CardIn();

        cardIn.setAffinity( user.getAffinity() );
        cardIn.setAttack( user.getAttack() );
        cardIn.setDescription( user.getDescription() );
        cardIn.setEnergy( user.getEnergy() );
        cardIn.setFamily( user.getFamily() );
        cardIn.setHp( user.getHp() );
        cardIn.setId( user.getId() );
        cardIn.setImgUrl( user.getImgUrl() );
        cardIn.setName( user.getName() );
        cardIn.setOriginalHp( user.getOriginalHp() );
        cardIn.setPrice( user.getPrice() );
        cardIn.setSmallImgUrl( user.getSmallImgUrl() );
        cardIn.setToSell( user.getToSell() );
        cardIn.setUserId( user.getUserId() );

        return cardIn;
    }

    @Override
    public CardOut convert(CardIn user) {
        if ( user == null ) {
            return null;
        }

        CardOut cardOut = new CardOut();

        cardOut.setAffinity( user.getAffinity() );
        cardOut.setAttack( user.getAttack() );
        cardOut.setDescription( user.getDescription() );
        cardOut.setEnergy( user.getEnergy() );
        cardOut.setFamily( user.getFamily() );
        cardOut.setHp( user.getHp() );
        cardOut.setId( user.getId() );
        cardOut.setImgUrl( user.getImgUrl() );
        cardOut.setName( user.getName() );
        cardOut.setOriginalHp( user.getOriginalHp() );
        cardOut.setPrice( user.getPrice() );
        cardOut.setSmallImgUrl( user.getSmallImgUrl() );
        cardOut.setToSell( user.getToSell() );
        cardOut.setUserId( user.getUserId() );

        return cardOut;
    }

    @Override
    public PartyIn convert(PartyOut user) {
        if ( user == null ) {
            return null;
        }

        PartyIn partyIn = new PartyIn();

        partyIn.setCardPlayerA( user.getCardPlayerA() );
        partyIn.setCardPlayerB( user.getCardPlayerB() );
        partyIn.setCurrentPlayerId( user.getCurrentPlayerId() );
        partyIn.setMise( user.getMise() );
        partyIn.setPartyCode( user.getPartyCode() );
        partyIn.setPartyName( user.getPartyName() );
        partyIn.setStarted( user.getStarted() );
        partyIn.setUserIdA( user.getUserIdA() );
        partyIn.setUserIdB( user.getUserIdB() );
        partyIn.setWinnerId( user.getWinnerId() );

        return partyIn;
    }

    @Override
    public PartyOut convert(PartyIn user) {
        if ( user == null ) {
            return null;
        }

        PartyOut partyOut = new PartyOut();

        partyOut.setCardPlayerA( user.getCardPlayerA() );
        partyOut.setCardPlayerB( user.getCardPlayerB() );
        partyOut.setCurrentPlayerId( user.getCurrentPlayerId() );
        partyOut.setMise( user.getMise() );
        partyOut.setPartyCode( user.getPartyCode() );
        partyOut.setPartyName( user.getPartyName() );
        partyOut.setStarted( user.getStarted() );
        partyOut.setUserIdA( user.getUserIdA() );
        partyOut.setUserIdB( user.getUserIdB() );
        partyOut.setWinnerId( user.getWinnerId() );

        return partyOut;
    }

    @Override
    public UserIn convert(UserOut user) {
        if ( user == null ) {
            return null;
        }

        UserIn userIn = new UserIn();

        userIn.setAccount( user.getAccount() );
        userIn.setEmail( user.getEmail() );
        userIn.setId( user.getId() );
        userIn.setLastName( user.getLastName() );
        userIn.setLogin( user.getLogin() );
        userIn.setPwd( user.getPwd() );
        userIn.setSession( user.getSession() );
        userIn.setSurName( user.getSurName() );

        return userIn;
    }

    @Override
    public UserOut convert(UserIn user) {
        if ( user == null ) {
            return null;
        }

        UserOut userOut = new UserOut();

        userOut.setAccount( user.getAccount() );
        userOut.setEmail( user.getEmail() );
        userOut.setId( user.getId() );
        userOut.setLastName( user.getLastName() );
        userOut.setLogin( user.getLogin() );
        userOut.setPwd( user.getPwd() );
        userOut.setSession( user.getSession() );
        userOut.setSurName( user.getSurName() );

        return userOut;
    }

    @Override
    public StoreOrderOut convert(StoreOrderIn user) {
        if ( user == null ) {
            return null;
        }

        StoreOrderOut storeOrderOut = new StoreOrderOut();

        storeOrderOut.setCardId( user.getCardId() );
        storeOrderOut.setUserId( user.getUserId() );

        return storeOrderOut;
    }

    @Override
    public StoreOrderIn convert(StoreOrderOut user) {
        if ( user == null ) {
            return null;
        }

        StoreOrderIn storeOrderIn = new StoreOrderIn();

        storeOrderIn.setCardId( user.getCardId() );
        storeOrderIn.setUserId( user.getUserId() );

        return storeOrderIn;
    }

    @Override
    public StoreTransactionOut convert(StoreTransactionIn user) {
        if ( user == null ) {
            return null;
        }

        StoreTransactionOut storeTransactionOut = new StoreTransactionOut();

        storeTransactionOut.setAction( user.getAction() );
        storeTransactionOut.setCardId( user.getCardId() );
        storeTransactionOut.setTimestamp( user.getTimestamp() );
        storeTransactionOut.setUserId( user.getUserId() );

        return storeTransactionOut;
    }

    @Override
    public StoreTransactionIn convert(StoreTransactionOut user) {
        if ( user == null ) {
            return null;
        }

        StoreTransactionIn storeTransactionIn = new StoreTransactionIn();

        storeTransactionIn.setAction( user.getAction() );
        storeTransactionIn.setCardId( user.getCardId() );
        storeTransactionIn.setTimestamp( user.getTimestamp() );
        storeTransactionIn.setUserId( user.getUserId() );

        return storeTransactionIn;
    }
}
