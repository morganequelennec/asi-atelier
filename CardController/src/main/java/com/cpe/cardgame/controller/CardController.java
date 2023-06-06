package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.entity.Card;
import com.cpe.cardgame.service.CardService;


import fr.api.UserApi;
import fr.mapper.ModelMapperCommon;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;

import fr.viewmodel.CardForm;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CardController extends BaseController {
    private final CardService cardService;
    private final UserApi userApi;

    public CardController(CardService cardService) {
        this.cardService = cardService;
        this.userApi = new UserApi();

        /*if(this.cardService.getAllCard(Optional.empty()).getResponse().size()<1)
        {*/
            for(int c = 0;c<10;c++)
            {
                Card card = new Card();
                card.setAffinity("fire");
                card.setAttack(12.0+c);
                card.setDefence(10.0+c);
                card.setFamily("fire family");
                card.setDescription("Super description of "+c);
                card.setEnergy(c+0.0);
                card.setHp(c*10.0);
                card.setName("Pokemon "+c);
                card.setToSell(Boolean.TRUE);
                card.setOriginalHp(c*10.0);
                card.setPrice(20.0);
                card.setSmallImgUrl("");
                card.setUserId(0);
                this.cardService.updateCard(card);
            }


        //}
    }

    @PostMapping("/card")
    public ResponseMessage<Card> createCard(Card card) {
        return cardService.updateCard(card);
    }

    @GetMapping("/card/{id}")
    public ResponseMessage<Card> getCardById(@PathVariable("id") int id) {
        return cardService.getCard(id);
    }



    @PostMapping("/buy-card/{cardId}")
    public ResponseMessage<Card> buyCardByUser(@PathVariable("cardId") int cardId, HttpServletRequest httprequest) {
        int userId = GetByUser(httprequest);

        return cardService.buyCardByUser(cardId, userId);
    }

    @PostMapping("/sell-card/{cardId}")
    public ResponseMessage<Card> sellCardByUser(@PathVariable("cardId") int cardId, HttpServletRequest httprequest) {
        var data = httprequest.getSession().getAttribute("USER");
        if (data == null) {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Not authenticated");
            return responseMessage;
        }

        Integer id = (Integer) data;
        if (id == null) {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Not authenticated");
            return responseMessage;
        }

        int userId = id;
        return cardService.sellCardByUser(cardId, userId);
    }

    @DeleteMapping("/card/{id}")
    public ResponseMessage<Card> deleteCardById(@PathVariable("id") int id) {
        return cardService.deleteCard(id);
    }

    @GetMapping("/cards")
    public ResponseMessage<List<Card>> getAllCards() {
        return cardService.getAllCard(Optional.empty());
    }

    @GetMapping("/cards-of-user")
    public ResponseMessage<List<Card>> getAllCardsByUserId(HttpServletRequest httprequest) {
        var user = GetByUser(httprequest);
        return cardService.getAllCardByUserId(user);
    }

    @GetMapping("/cards-of-user/available/{user_id}")
    public ResponseMessage<List<Card>> getAllCardsByUserIdAvailable(int user_id) {

        return cardService.getAllCardByUserIdAvailable(user_id);
    }
    private List<CardForm> convertToCardForms(List<Card> cards) {
        List<CardForm> cardForms = new ArrayList<>();
        for (Card card : cards) {
            CardForm cardForm = card.toCardForm();
            cardForms.add(cardForm);
        }
        return cardForms;
    }
    @GetMapping("/cards-buyable")
    public ResponseMessage<List<Card>> getAllCardsBuyable() {
        ResponseMessage<List<Card>> cardForms = new ResponseMessage<>(
                /*convertToCardForms(*/cardService.getAllCardCanBuy().getResponse()/*)*/
        );
        cardForms.setResponseCode(ResponseCode.SUCCESS);
        return cardForms;
    }

    @GetMapping("/cards/user/{userId}")
    public ResponseMessage<List<Card>> getCardsByUserId(@PathVariable("userId") Integer userId) {
        return cardService.getAllCardTransactionsForUserId(Optional.empty(), userId);
    }

    @GetMapping("/buy-card")
    public ResponseMessage<List<CardForm>> getBuyCardList(HttpServletRequest request) {
        int user = GetByUser(request);
        if (user == 0) {
            ResponseMessage<List<CardForm>> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Error: You are not logged in");
            return responseMessage;
        }

        return cardService.getBuyCardList();
    }


}