package com.cpe.cardgame.controller;

import fr.api.UserApi;
import fr.utils.KeyHost;
import fr.utils.ResponseMessage;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Key;

public class BaseController {

    public UserApi userApi = new UserApi();

    //@RequestMapping(value = "/check-auth", method = RequestMethod.GET)
    public ResponseMessage<String> checkAuth(HttpServletRequest httprequest) {
        Cookie[] cookies = httprequest.getCookies();

        if (cookies != null) {
            String jwtToken = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JWT_TOKEN")) {
                    jwtToken = cookie.getValue();
                    break;
                }
            }

            if (jwtToken != null) {
                return userApi.isAuth(jwtToken);
            }
        }

        // Handle unauthenticated requests
        return new ResponseMessage<String>("");
    }

    public int GetByUser(HttpServletRequest httprequest)
    {
        var result = checkAuth(httprequest);
        if(result.getResponse().length()<1)
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(result.getResponse());
        }
        /*var data = httprequest.getSession().getAttribute("USER");
        if(data == null)
        {
            return 0;
        }
        var id = (Integer)data;
        if(id == null)
        {
            return 0;
        }
        return id;*/
    }
}