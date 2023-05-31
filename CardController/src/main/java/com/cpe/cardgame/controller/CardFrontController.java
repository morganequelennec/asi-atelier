package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import fr.viewmodel.AuthDTO;
import fr.viewmodel.CardForm;
import jakarta.servlet.http.HttpServletRequest;
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
        var test = this.cardController.createCard(ModelMapper.INSTANCE.convert(cardForm));

        model.addAttribute("cardData", cardForm);
        return "viewCard";
    }

    @RequestMapping(value="/view-card/{id}", method = RequestMethod.GET)
    public String createUserAction(Model model, @PathVariable("id") int id){
        /*var test = this.cardController.getCardById(id);

        model.addAttribute("cardData", test.getResponse());*/
        return "viewCard";
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
    @RequestMapping(value="/buy-card-page", method = RequestMethod.GET)
    public String buyCardList(Model model, HttpServletRequest httprequest){
        var user = GetByUser(httprequest);
        if(user == 0)
        {
            AuthDTO authForm = new AuthDTO();
            model.addAttribute("connectForm", authForm);
            return "connectForm";
        }
        var test = this.cardController.getAllCardsBuyable();
        model.addAttribute("cardList", test.getResponse());
        return "buyCard";
    }

    @RequestMapping(value="/get-my-cards", method = RequestMethod.GET)
    public String getMyCards(Model model, HttpServletRequest httprequest){
        var data = httprequest.getSession().getAttribute("USER");
        if(data == null)
        {
            AuthDTO authForm = new AuthDTO();
            model.addAttribute("connectForm", authForm);
            return "connectForm";
        }
        var id = (Integer)data;
        if(id == null)
        {
            AuthDTO authForm = new AuthDTO();
            model.addAttribute("connectForm", authForm);
            return "connectForm";
        }

        //var test = this.cardController.getAllCardsByUserId(id);
        //model.addAttribute("cardList", test.getResponse());
        return "buyerCards";
    }

}