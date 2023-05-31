package com.cpe.cardgame.controller;

import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.model.PlayParty;
import com.cpe.cardgame.model.PlayPartyViewModel;
import com.cpe.cardgame.service.PlayPartyService;
import fr.api.CardApi;
import fr.api.UserApi;
import fr.dtoin.CardIn;
import fr.dtoin.PartyIn;
import fr.dtoout.CardOut;
import fr.dtoout.PartyOut;
import fr.mapper.ModelMapperCommon;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayPartyController extends BaseController {
    private final PlayPartyService playPartyService;
    private final UserApi userService;
    private final CardApi cardService;

    public PlayPartyController(PlayPartyService playPartyService) {
        this.playPartyService = playPartyService;
        this.userService = new UserApi();
        this.cardService = new CardApi();
    }

    @PostMapping("/play-party")
    public ResponseMessage<PartyOut> createCard(PartyIn card) {
        var model =  playPartyService.updatePlayParty(
                ModelMapper.INSTANCE.convert(card)
        );
        if(model.isSuccess())
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                   ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @PostMapping("/party-player-fight/{playerId}")
    public ResponseMessage<PartyOut> partyPlayerFight(@PathVariable("playerId") int playerId) {
        var model =  playPartyService.playerAttack(playerId);
        if(model.isSuccess())
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @GetMapping("/play-party/{id}")
    public ResponseMessage<PartyOut> getPlayPartyById(@PathVariable("id") int id) {
        var model =  playPartyService.getPlayParty(id);
        if(model.isSuccess())
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @PostMapping("/create-play-party")
    public ResponseMessage<PartyOut> createPlayParty(HttpServletRequest httprequest) {
        int user = GetByUser(httprequest);
        if(user == 0)
        {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.SUCCESS);
            playPartyResponseMessage.setMessage("You must be logged in");
            return playPartyResponseMessage;
        }
        var playerCards = this.cardService.getAllCardsByUserId(user);
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

        ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                ModelMapper.INSTANCE.convertToOut(response.getResponse())
        );
        responseMessage.setMessage(message);
        responseMessage.setResponseCode(ResponseCode.SUCCESS);
        return responseMessage;

    }

    @PostMapping("/update-user-card-play-party/{playPartyId}/{cardId}")
    public ResponseMessage<PartyOut> createPlayParty(@PathVariable("playPartyId") int playPartyId, @PathVariable("cardId") int cardId, HttpServletRequest httprequest) {
        int user = GetByUser(httprequest);
        if(user == 0)
        {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            playPartyResponseMessage.setMessage("You must be logged in");
            return playPartyResponseMessage;
        }
        var playParty = playPartyService.getPlayParty(playPartyId);
        var card = cardService.getCard(cardId);
        if(!playParty.isSuccess()||!card.isSuccess())
        {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.ERROR);
            playPartyResponseMessage.setMessage("Either the card or the playParty dont exist");
            return playPartyResponseMessage;
        }

        var playerCards = cardService.getAllCardTransactionsForUserId(user);
        Boolean cardFound = Boolean.FALSE;

        for(var cardP : playerCards.getResponse())
        {
            if(cardP.getId()==card.getResponse().getId())
            {
                cardFound = Boolean.TRUE;
            }
        }

        if(cardFound == Boolean.FALSE)
        {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.ERROR);
            playPartyResponseMessage.setMessage("You are not the card owner");
            return playPartyResponseMessage;
        }

        if(playParty.getResponse().getUserIdA() == user)
        {
            playParty.getResponse().setCardPlayerA(card.getResponse().getId());
            this.playPartyService.updatePlayParty(playParty.getResponse());
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.SUCCESS);
            return playPartyResponseMessage;
        }
        else if(playParty.getResponse().getUserIdB() == user)
        {
            playParty.getResponse().setCardPlayerB(card.getResponse().getId());
            this.playPartyService.updatePlayParty(playParty.getResponse());
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.SUCCESS);
            return playPartyResponseMessage;
        }
        else
        {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.ERROR);
            playPartyResponseMessage.setMessage("User dont belong to the party");
            return playPartyResponseMessage;
        }
    }

    @GetMapping("/join-play-party/{code}")
    public ResponseMessage<PartyOut> getPlayPartyByCode(@PathVariable("code") String code) {
        var model = playPartyService.getPlayPartyByCode(code);
        if(model.isSuccess())
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    List<CardOut> convertToCardOutList(List<CardIn> cards) {
        List<CardOut> cardOutList = new ArrayList<>();
        for (CardIn card : cards) {
            CardOut cardOut = ModelMapperCommon.INSTANCE.convert(card);
            cardOutList.add(cardOut);
        }
        return cardOutList;
    }

    List<CardIn> convertToCardInList(List<CardOut> cards) {
        List<CardIn> cardOutList = new ArrayList<>();
        for (CardOut card : cards) {
            CardIn cardOut = ModelMapperCommon.INSTANCE.convert(card);
            cardOutList.add(cardOut);
        }
        return cardOutList;
    }


    @RequestMapping(value="/view-player-party-data/{id}", method = RequestMethod.GET)
    public ResponseMessage<PlayPartyViewModel> createUserAction( @PathVariable("id") int id, HttpServletRequest httprequest){
        int user = GetByUser(httprequest);
        if(user == 0)
        {
            ResponseMessage<PlayPartyViewModel> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("You must be logged in !");
            return responseMessage;
        }

        var test = this.playPartyService.getPlayParty(id);
        if(!test.isSuccess())
        {
            ResponseMessage<PlayPartyViewModel> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Party not found !");
            return responseMessage;
        }
        var cards_player_a = this.cardService.getAllCardsByUserId(test.getResponse().getUserIdA());
        var cards_player_b = this.cardService.getAllCardsByUserId(test.getResponse().getUserIdB());
        var this_user_cards = this.cardService.getAllCardsByUserId(user);

        PlayPartyViewModel playPartyViewModel = new PlayPartyViewModel();

        playPartyViewModel.setPlayParty(
                test.getResponse()
        );
        playPartyViewModel.setCardUserList(convertToCardInList(this_user_cards.getResponse()));
        playPartyViewModel.setPlayerCardsA(convertToCardInList(cards_player_a.getResponse()));
        playPartyViewModel.setPlayerCardsB(convertToCardInList(cards_player_b.getResponse()));
        ResponseMessage<PlayPartyViewModel> responseMessage = new ResponseMessage<>(playPartyViewModel);
        responseMessage.setResponseCode(ResponseCode.SUCCESS);
        return responseMessage;
    }


}