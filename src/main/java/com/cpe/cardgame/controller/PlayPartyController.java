package com.cpe.cardgame.controller;

import com.cpe.cardgame.model.Card;
import com.cpe.cardgame.model.PlayParty;
import com.cpe.cardgame.service.CardService;
import com.cpe.cardgame.service.PlayPartyService;
import com.cpe.cardgame.service.UserService;
import com.cpe.cardgame.utils.ResponseCode;
import com.cpe.cardgame.utils.ResponseMessage;
import com.cpe.cardgame.viewmodel.AuthDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayPartyController {
    private final PlayPartyService playPartyService;
    private final UserService userService;
    private final CardService cardService;

    public PlayPartyController(PlayPartyService playPartyService, UserService userService, CardService cardService) {
        this.playPartyService = playPartyService;
        this.userService = userService;
        this.cardService = cardService;
    }

    @PostMapping("/play-party")
    public ResponseMessage<PlayParty> createCard(PlayParty card) {
        return playPartyService.updatePlayParty(card);
    }

    @PostMapping("/party-player-fight/{playerId}")
    public ResponseMessage<PlayParty> partyPlayerFight(@PathVariable("playerId") int playerId) {
        return playPartyService.playerAttack(playerId);
    }

    @GetMapping("/play-party/{id}")
    public ResponseMessage<PlayParty> getPlayPartyById(@PathVariable("id") int id) {
        return playPartyService.getPlayParty(id);
    }

    @PostMapping("/create-play-party")
    public ResponseMessage<PlayParty> createPlayParty(HttpServletRequest httprequest) {
        int user = GetByUser(httprequest);
        if(user == 0)
        {
            ResponseMessage<PlayParty> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.SUCCESS);
            playPartyResponseMessage.setMessage("You must be logged in");
            return playPartyResponseMessage;
        }
        var playerCards = this.cardService.getAllCardByUserId(user);
        PlayParty playParty = new PlayParty();
        playParty.setCardPlayerB(0);
        playParty.setWinnerId(0);
        playParty.setCurrentPlayerId(user);
        playParty.setUserIdB(0);
        playParty.setUserIdA(user);
        playParty.setPartyCode("BVBDBVDN");
        playParty.setStarted(Boolean.TRUE);
        if(playerCards.getResponse().size()>0)
        {
            playParty.setCardPlayerA(playerCards.getResponse().get(0).getId());
        }
        var response =  playPartyService.updatePlayParty(playParty);
        var message = "http://localhost:8080/view-player-party/"+response.getResponse().getId();
        response.setMessage(message);
        return response;
    }

    @GetMapping("/join-play-party/{code}")
    public ResponseMessage<PlayParty> getPlayPartyByCode(@PathVariable("code") String code) {
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