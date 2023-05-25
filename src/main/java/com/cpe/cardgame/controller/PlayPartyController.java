package com.cpe.cardgame.controller;

import com.cpe.cardgame.model.Card;
import com.cpe.cardgame.model.PlayParty;
import com.cpe.cardgame.service.CardService;
import com.cpe.cardgame.service.PlayPartyService;
import com.cpe.cardgame.service.UserService;
import com.cpe.cardgame.utils.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayPartyController {
    private final PlayPartyService playPartyService;
    private final UserService userService;

    public PlayPartyController(PlayPartyService playPartyService, UserService userService) {
        this.playPartyService = playPartyService;
        this.userService = userService;
    }

    @PostMapping("/play-party")
    public ResponseMessage<PlayParty> createCard(PlayParty card) {
        return playPartyService.updatePlayParty(card);
    }

    @GetMapping("/play-party/{id}")
    public ResponseMessage<PlayParty> getCardById(@PathVariable("id") int id) {
        return playPartyService.getPlayParty(id);
    }

    @GetMapping("/join-play-party/{code}")
    public ResponseMessage<PlayParty> getCardById(@PathVariable("code") String code) {
        return playPartyService.getPlayPartyByCode(code);
    }

    public int GetByUser(HttpServletRequest httprequest)
    {
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