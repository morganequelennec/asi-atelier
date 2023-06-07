package com.cpe.cardgame.controller;

import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.model.PlayParty;
import com.cpe.cardgame.model.PlayPartyCreateViewModel;
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
    public ResponseMessage<PartyOut> createPlayParty(HttpServletRequest httprequest, @RequestBody PlayPartyCreateViewModel playPartyCreateViewModel) {
        int user = GetByUser(httprequest);
        if (user == 0) {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.SUCCESS);
            playPartyResponseMessage.setMessage("You must be logged in");
            return playPartyResponseMessage;
        }

        return playPartyService.createPlayParty(user, playPartyCreateViewModel);
    }

    @PostMapping("/update-user-card-play-party/{playPartyId}/{cardId}")
    public ResponseMessage<PartyOut> updateUserCardPlayParty(@PathVariable("playPartyId") int playPartyId, @PathVariable("cardId") int cardId, HttpServletRequest httprequest) {
        int user = GetByUser(httprequest);
        if (user == 0) {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            playPartyResponseMessage.setMessage("You must be logged in");
            return playPartyResponseMessage;
        }

        return playPartyService.updateUserCardPlayParty(playPartyId, cardId, user);
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




    @GetMapping("/view-player-party-data/{id}")
    public ResponseMessage<PlayPartyViewModel> getPlayPartyData(@PathVariable("id") int id, HttpServletRequest httprequest) {
        int user = GetByUser(httprequest);
        if (user == 0) {
            ResponseMessage<PlayPartyViewModel> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("You must be logged in!");
            return responseMessage;
        }

        return playPartyService.getPlayPartyData(id, user);
    }


}