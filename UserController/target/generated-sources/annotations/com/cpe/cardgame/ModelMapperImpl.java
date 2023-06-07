package com.cpe.cardgame;

import com.cpe.cardgame.entity.UserGame;
import fr.dtoin.UserIn;
import fr.dtoout.UserOut;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T20:35:17+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public UserGame convert(UserIn user) {
        if ( user == null ) {
            return null;
        }

        UserGame userGame = new UserGame();

        userGame.setSession( user.getSession() );
        userGame.setLogin( user.getLogin() );
        userGame.setPwd( user.getPwd() );
        userGame.setAccount( user.getAccount() );
        userGame.setLastName( user.getLastName() );
        userGame.setSurName( user.getSurName() );
        userGame.setEmail( user.getEmail() );

        return userGame;
    }

    @Override
    public UserGame convert(UserOut user) {
        if ( user == null ) {
            return null;
        }

        UserGame userGame = new UserGame();

        userGame.setSession( user.getSession() );
        userGame.setId( user.getId() );
        userGame.setLogin( user.getLogin() );
        userGame.setPwd( user.getPwd() );
        userGame.setAccount( user.getAccount() );
        userGame.setLastName( user.getLastName() );
        userGame.setSurName( user.getSurName() );
        userGame.setEmail( user.getEmail() );

        return userGame;
    }

    @Override
    public UserIn convertToIn(UserGame user) {
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
    public UserOut convertToOut(UserGame user) {
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
        userOut.setId( user.getId() );

        return userOut;
    }
}
