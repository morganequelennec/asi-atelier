package com.cpe.cardgame.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Key;

public class BaseController {
    @RequestMapping(value = "/check-auth", method = RequestMethod.GET)
    public ResponseEntity<?> checkAuth(HttpServletRequest httprequest) {
        String jwtToken = (String) httprequest.getSession().getAttribute("JWT_TOKEN");

        if (jwtToken != null) {
            try {
                Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwtToken)
                        .getBody();

                // Extract user ID from claims and perform necessary operations
                String userId = claims.getSubject();
                // ...

                return ResponseEntity.ok().build();
            } catch (Exception e) {
                // Handle invalid/expired tokens
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            // Handle unauthenticated requests
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    public int GetByUser(HttpServletRequest httprequest)
    {
        if(!checkAuth(httprequest).getStatusCode().equals(HttpStatus.OK))
        {
            return 0;
        }
        var data = httprequest.getSession().getAttribute("USER");
        if(data == null)
        {
            return 0;
        }
        var id = (Integer)data;
        if(id == null)
        {
            return 0;
        }
        return id;
    }
}