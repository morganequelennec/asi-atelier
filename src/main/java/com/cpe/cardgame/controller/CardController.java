package com.cpe.cardgame.controller;

import com.cpe.cardgame.model.Card;
import com.cpe.cardgame.model.StoreTransaction;
import com.cpe.cardgame.service.CardService;
import com.cpe.cardgame.service.StoreTransactionService;
import com.cpe.cardgame.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/card")
    public ResponseMessage<Card> createCard(Card card) {
        return cardService.updateCard(card);
    }

    @GetMapping("/card/{id}")
    public ResponseMessage<Card> getCardById(@PathVariable("id") int id) {
        return cardService.getCard(id);
    }

    @DeleteMapping("/card/{id}")
    public ResponseMessage<Card> deleteCardById(@PathVariable("id") int id) {
        return cardService.deleteCard(id);
    }

    @GetMapping("/cards")
    public ResponseMessage<List<Card>> getAllCards() {
        return cardService.getAllCard(Optional.empty());
    }

    @GetMapping("/cards/user/{userId}")
    public ResponseMessage<List<Card>> getCardsByUserId(@PathVariable("userId") Integer userId) {
        return cardService.getAllCardTransactionsForUserId(Optional.empty(), userId);
    }
}