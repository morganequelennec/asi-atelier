package com.cpe.cardgame;

import com.cpe.cardgame.entity.StoreOrder;
import com.cpe.cardgame.entity.StoreTransaction;
import fr.dtoin.StoreOrderIn;
import fr.dtoin.StoreTransactionIn;
import fr.dtoout.StoreOrderOut;
import fr.dtoout.StoreTransactionOut;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T15:45:55+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
}
