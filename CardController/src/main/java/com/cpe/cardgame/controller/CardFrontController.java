package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.entity.Card;
import fr.dtoout.CardOut;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import fr.viewmodel.AuthDTO;
import fr.viewmodel.CardForm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardFrontController extends BaseController {

    private final CardController cardController;

    public CardFrontController(CardController cardController) {
        this.cardController = cardController;
    }
    @RequestMapping(value = { "/create-card"}, method = RequestMethod.GET)
    public String CreateCard(Model model) {
        CardForm card = new CardForm();
        model.addAttribute("cardForm", card);
        return "createCardForm";
    }
    @PostMapping(value="/create-card")
    public ResponseMessage<CardOut> createUserAction(@ModelAttribute("cardForm") CardForm cardForm){
        var test = this.cardController.createCard(ModelMapper.INSTANCE.convert(cardForm));
        if(test.isSuccess())
        {
            return test.toType(ModelMapper.INSTANCE.convertToOut(test.getResponse()));
        }
        else {
            return test.toNull();
        }
    }

    @GetMapping(value="/view-card/{id}")
    public ResponseMessage<CardOut> createUserAction(@PathVariable("id") int id){
        var test = this.cardController.getCardById(id);
        if(test.isSuccess())
        {
            return test.toType(ModelMapper.INSTANCE.convertToOut(test.getResponse()));
        }
        else {
            return test.toNull();
        }
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
//var id = Integer.valueOf((String) httprequest.getSession().getAttribute("USER")); HttpServletRequest httprequest
    @GetMapping(value="/buy-card-page")
    public ResponseMessage<List<CardOut>> buyCardList(HttpServletRequest httprequest){
        var user = GetByUser(httprequest);
        if(user == 0)
        {
            ResponseMessage<List<CardOut>> responseMessage = new ResponseMessage<>(null);
            responseMessage.setMessage("You must be logged in");
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            return responseMessage;
        }
        var test = this.cardController.getAllCardsBuyable();
        if(test.isSuccess())
        {
            return test.toType(convertToCardOutList(test.getResponse()));
        }
        else {
            return test.toNull();
        }
    }

    private List<CardOut> convertToCardOutList(List<Card> cards) {
        List<CardOut> cardForms = new ArrayList<>();
        for (Card card : cards) {
            CardOut cardForm = ModelMapper.INSTANCE.convertToOut(card);
            cardForms.add(cardForm);
        }
        return cardForms;
    }

    @RequestMapping(value="/get-my-cards", method = RequestMethod.GET)
    public ResponseMessage<List<CardOut>> getMyCards(HttpServletRequest httprequest){
        var data = httprequest.getSession().getAttribute("USER");
        if(data == null)
        {
            ResponseMessage<List<CardOut>> responseMessage = new ResponseMessage<>(null);
            responseMessage.setMessage("You must be logged in");
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            return responseMessage;
        }
        var id = (Integer)data;
        if(id == null)
        {
            ResponseMessage<List<CardOut>> responseMessage = new ResponseMessage<>(null);
            responseMessage.setMessage("User id is wrong");
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            return responseMessage;
        }
        var test = this.cardController.getAllCardsByUserId(httprequest);
        if(test.isSuccess())
        {
            return test.toType(convertToCardOutList(test.getResponse()));
        }
        else {
            return test.toNull();
        }
    }

}