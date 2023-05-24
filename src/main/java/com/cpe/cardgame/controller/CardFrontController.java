package com.cpe.cardgame.controller;

import com.cpe.cardgame.model.Card;
import com.cpe.cardgame.model.UserGame;
import com.cpe.cardgame.service.CardService;
import com.cpe.cardgame.service.UserService;
import com.cpe.cardgame.viewmodel.AuthDTO;
import com.cpe.cardgame.viewmodel.CardForm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CardFrontController {

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
    @RequestMapping(value="/create-card", method = RequestMethod.POST)
    public String createUserAction(Model model,@ModelAttribute("cardForm") CardForm cardForm){
        var test = this.cardController.createCard(cardForm.toCard());

        model.addAttribute("cardData", cardForm);
        return "viewCard";
    }

    @RequestMapping(value="/view-card/{id}", method = RequestMethod.GET)
    public String createUserAction(Model model, @PathVariable("id") int id){
        var test = this.cardController.getCardById(id);

        model.addAttribute("cardData", test.getResponse());
        return "viewCard";
    }

    @RequestMapping(value="/buy-card", method = RequestMethod.GET)
    public String buyCardList(Model model){
        var test = this.cardController.getAllCardsBuyable();
        model.addAttribute("cardList", test.getResponse());
        return "buyCard";
    }

}