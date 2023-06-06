package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.service.PlayPartyService;
import fr.api.CardApi;
import fr.dtoout.PartyOut;
import fr.viewmodel.AuthDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayPartyFrontController extends BaseController {
    private final PlayPartyController playPartyController;
    private final PlayPartyService playPartyService;
    private final CardApi cardController;

    public PlayPartyFrontController(PlayPartyController playPartyController, PlayPartyService playPartyService) {
        this.playPartyController = playPartyController;
        this.cardController = new CardApi();
        this.playPartyService = playPartyService;
    }


    @GetMapping(value="/view-player-party/{id}")
    public String createUserAction(@PathVariable("id") int id, HttpServletRequest httprequest){
        int user = GetByUser(httprequest);
        if(user == 0)
        {
            return "connectForm";
        }
        /*var test = this.playPartyController.getPlayPartyById(id);
        var cards_player_a = this.cardController.getCardsByUserId(test.getResponse().getUserIdA());
        var cards_player_b = this.cardController.getCardsByUserId(test.getResponse().getUserIdB());
        var this_user_cards = this.cardController.getCardsByUserId(user);

        model.addAttribute("playerParty", test.getResponse());
        model.addAttribute("userCards", this_user_cards.getResponse());
        model.addAttribute("playerCardsA", cards_player_a.getResponse());
        model.addAttribute("playerCardsB", cards_player_b.getResponse());*/
        return "playParty";
    }

    @GetMapping(value="/view-player-party/second-player/{id}")
    public String SetSecondPlayer(@PathVariable("id") int id, HttpServletRequest httprequest){
        int user = GetByUser(httprequest);
        if(user == 0)
        {
            return "mustConnect";
        }
        var test = this.playPartyController.getPlayPartyById(id);
        test.getResponse().setUserIdB(user);
        var cards = this.cardController.getAllCardsByUserId(user);
        test.getResponse().setCardPlayerB(cards.getResponse().get(0).getId());
        this.playPartyService.updatePlayParty(ModelMapper.INSTANCE.convert(test.getResponse()));
        return "";
    }


}