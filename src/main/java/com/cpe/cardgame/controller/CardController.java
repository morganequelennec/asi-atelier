package com.cpe.cardgame.controller;

import com.cpe.cardgame.model.Card;
import com.cpe.cardgame.model.StoreTransaction;
import com.cpe.cardgame.service.CardService;
import com.cpe.cardgame.service.StoreTransactionService;
import com.cpe.cardgame.service.UserService;
import com.cpe.cardgame.utils.ResponseCode;
import com.cpe.cardgame.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {
    private final CardService cardService;
    private final UserService userService;

    public CardController(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    @PostMapping("/card")
    public ResponseMessage<Card> createCard(Card card) {
        return cardService.updateCard(card);
    }

    @GetMapping("/card/{id}")
    public ResponseMessage<Card> getCardById(@PathVariable("id") int id) {
        return cardService.getCard(id);
    }

    @GetMapping("/buy-card/{cardId}/user/{userId}")
    public ResponseMessage<Card> buyCardByUser(
            @PathVariable("cardId") int cardid,
            @PathVariable("userId") int userId
            )
    {
        var user = userService.getUser(userId);
        var card = cardService.getCard(cardid);
        if(!card.isSuccess())
        {
            return card;
        }
        if(!user.isSuccess())
        {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(user.getResponseCode());
            responseMessage.setMessage(user.getMessage());
            return responseMessage;
        }
        if(user.getResponse().getId()==card.getResponse().getUserId())
        {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You already own this item !");
            return responseMessage;
        }
        if(user.getResponse().getAccount()<card.getResponse().getPrice())
        {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You don't have enough balance on your account to buy this item !");
            return responseMessage;
        }
        else
        {
            var new_user = user.getResponse();
            var new_card = card.getResponse();
            new_user.setAccount(new_user.getAccount()-new_card.getPrice());
            new_card.setUserId(new_user.getId());
            var result_user = userService.updateUser(new_user);
            if(!result_user.isSuccess())
            {
                ResponseMessage<Card> responseMessage = new ResponseMessage<>(new_card);
                responseMessage.setResponseCode(result_user.getResponseCode());
                responseMessage.setMessage(result_user.getMessage());
                return responseMessage;
            }
            var result_card = cardService.updateCard(new_card);
            if(!result_card.isSuccess())
            {
                return result_card;
            }

            ResponseMessage<Card> responseMessage = new ResponseMessage<>(result_card.getResponse());
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
    }

    @DeleteMapping("/card/{id}")
    public ResponseMessage<Card> deleteCardById(@PathVariable("id") int id) {
        return cardService.deleteCard(id);
    }

    @GetMapping("/cards")
    public ResponseMessage<List<Card>> getAllCards() {
        return cardService.getAllCard(Optional.empty());
    }

    @GetMapping("/cards/user/{user_id}")
    public ResponseMessage<List<Card>> getAllCardsByUserId(int user_id) {
        return cardService.getAllCardByUserId(user_id);
    }

    @GetMapping("/cards-buyable")
    public ResponseMessage<List<Card>> getAllCardsBuyable() {
        return cardService.getAllCardCanBuy();
    }

    @GetMapping("/cards/user/{userId}")
    public ResponseMessage<List<Card>> getCardsByUserId(@PathVariable("userId") Integer userId) {
        return cardService.getAllCardTransactionsForUserId(Optional.empty(), userId);
    }
}