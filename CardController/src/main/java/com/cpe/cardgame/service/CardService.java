package com.cpe.cardgame.service;

import com.cpe.cardgame.entity.Card;
import com.cpe.cardgame.repositories.CardRepository;
import fr.api.CardApi;
import fr.api.UserApi;
import fr.mapper.ModelMapperCommon;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import fr.viewmodel.CardForm;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository storeOrderRepository;
    private final CardApi cardApi = new CardApi();
    private final UserApi userApi = new UserApi();

    public CardService(CardRepository storeOrderRepository) {
        this.storeOrderRepository = storeOrderRepository;
    }

    // Example method for updating a user
    public ResponseMessage<Card> updateCard(Card storeOrder) {
        var result =  storeOrderRepository.save(storeOrder);
        ResponseMessage<Card> responseMessage = new ResponseMessage<>(result);
        if(result == null)
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("Card not found");
        }
        else
        {
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        return responseMessage;
    }

    public ResponseMessage<Card> buyCardByUser(int cardId, int userId) {
        var user = userApi.getUserById(userId);
        var card = this.getCard(cardId);

        if (!card.isSuccess()) {
            return card;
        }

        if (!user.isSuccess()) {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(user.getResponseCode());
            responseMessage.setMessage(user.getMessage());
            return responseMessage;
        }

        if (user.getResponse().getId() == card.getResponse().getUserId()) {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You already own this item!");
            return responseMessage;
        }

        if (user.getResponse().getAccount() < card.getResponse().getPrice()) {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You don't have enough balance on your account to buy this item!");
            return responseMessage;
        } else {
            var newUser = user.getResponse();
            var newCard = card.getResponse();

            if (newCard.getUserId() != 0) {
                var rUser = userApi.getUserById(newCard.getUserId());
                if (rUser.isSuccess()) {
                    rUser.getResponse().setAccount(rUser.getResponse().getAccount() + newCard.getPrice());
                    userApi.updateUser(ModelMapperCommon.INSTANCE.convert(rUser.getResponse()));
                }
            }

            newUser.setAccount(newUser.getAccount() - newCard.getPrice());
            newCard.setUserId(newUser.getId());
            newCard.setToSell(Boolean.FALSE);
            userApi.updateUser(ModelMapperCommon.INSTANCE.convert(newUser));

            var resultUser = userApi.getUserById(newUser.getId());
            if (!resultUser.isSuccess()) {
                ResponseMessage<Card> responseMessage = new ResponseMessage<>(newCard);
                responseMessage.setResponseCode(resultUser.getResponseCode());
                responseMessage.setMessage(resultUser.getMessage());
                return responseMessage;
            }

            var resultCard = this.updateCard(newCard);
            if (!resultCard.isSuccess()) {
                return resultCard;
            }

            ResponseMessage<Card> responseMessage = new ResponseMessage<>(resultCard.getResponse());
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
    }


    public ResponseMessage<Card> getCard(Integer id) {
        var result =  storeOrderRepository.findById(id);
        ResponseMessage<Card> responseMessage = new ResponseMessage<>(result.get());
        if(!result.isPresent())
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("Card not found");
        }
        else
        {
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        return responseMessage;
    }

    public ResponseMessage<Card> sellCardByUser(int cardId, int userId) {
        var user = userApi.getUserById(userId);
        var card = this.getCard(cardId);

        if (!card.isSuccess()) {
            return card;
        }

        if (!user.isSuccess()) {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(user.getResponseCode());
            responseMessage.setMessage(user.getMessage());
            return responseMessage;
        }

        if (user.getResponse().getId() == card.getResponse().getUserId()) {
            card.getResponse().setToSell(Boolean.TRUE);
            return this.updateCard(card.getResponse());
        } else {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(card.getResponse());
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You are not the card owner");
            return responseMessage;
        }
    }


    public ResponseMessage<List<Card>> getAllCard(Optional<Pageable> filter) {

        ResponseMessage<List<Card>> responseMessage = null;
        try {
            if(filter.isPresent())
            {
                var data = storeOrderRepository.findAll(filter.get());
                responseMessage = new ResponseMessage<>(data.getContent());
                responseMessage.setResponseCode(ResponseCode.SUCCESS);
            }
            else
            {
                var data = storeOrderRepository.findAll();
                responseMessage = new ResponseMessage<>(data);
                responseMessage.setResponseCode(ResponseCode.SUCCESS);
            }
        }
        catch (Exception e)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Failed to get all Card " +(filter.isPresent()?"(with filter)":"") + " with error :"+e.getMessage());
        }
        return responseMessage;
    }

    public ResponseMessage<List<CardForm>> getBuyCardList() {
        var cardList = this.getAllCardCanBuy();
        List<CardForm> cardFormList = new ArrayList<>();

        for (Card card : cardList.getResponse()) {
            cardFormList.add(card.toCardForm());
        }

        ResponseMessage<List<CardForm>> responseMessage = new ResponseMessage<>(cardFormList);
        responseMessage.setResponseCode(ResponseCode.SUCCESS);
        return responseMessage;
    }



    public ResponseMessage<List<Card>> getAllCardCanBuy() {

        ResponseMessage<List<Card>> responseMessage = null;
        try {
            var data = storeOrderRepository.findAllByUserIdZero();
            responseMessage = new ResponseMessage<>(data);
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        catch (Exception e)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Failed to get all Card that can be bought with error :"+e.getMessage());
        }
        return responseMessage;
    }

    public ResponseMessage<List<Card>> getAllCardByUserId(int user_id) {

        ResponseMessage<List<Card>> responseMessage = null;
        if(user_id==0)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setMessage("No cards for user id 0");
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        try {
            var data = storeOrderRepository.findAllByUserId(user_id);
            responseMessage = new ResponseMessage<>(data);
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        catch (Exception e)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Failed to get all Card that the user own with error :"+e.getMessage());
        }
        return responseMessage;
    }

    public ResponseMessage<List<Card>> getAllCardByUserIdAvailable(int user_id) {

        ResponseMessage<List<Card>> responseMessage = null;
        if(user_id==0)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setMessage("No cards for user id 0");
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        try {
            var data = storeOrderRepository.findAllByUserIdCardAvailable(user_id);
            responseMessage = new ResponseMessage<>(data);
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        catch (Exception e)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Failed to get all Card that the user own and are available with error :"+e.getMessage());
        }
        return responseMessage;
    }

    public ResponseMessage<Card> deleteCard(Card storeOrder) {
        storeOrderRepository.delete(storeOrder);
        var result = storeOrderRepository.findById(storeOrder.getId());

        if(!result.isPresent())
        {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(storeOrder);
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(storeOrder);
            responseMessage.setMessage("Card deletion failed");
            responseMessage.setResponseCode(ResponseCode.ERROR);
            return responseMessage;
        }

    }

    public ResponseMessage<Card> deleteCard(int cardId) {
        var result = storeOrderRepository.findById(cardId);
        if(result.isPresent())
        {
            return deleteCard(result.get());
        }
        else
        {
            ResponseMessage<Card> responseMessage = new ResponseMessage<>(null);
            responseMessage.setMessage("StoreTransaction deletion failed");
            responseMessage.setResponseCode(ResponseCode.ERROR);
            return responseMessage;
        }
    }

    public ResponseMessage<List<Card>> getAllCardTransactionsForUserId(Optional<Pageable> filter, Integer userId) {

        ResponseMessage<List<Card>> responseMessage = null;
        if(userId==0)
        {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setMessage("No cards for user id 0");
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        try {
            if (filter.isPresent()) {
                var data = storeOrderRepository.findAllByUserId(userId, filter.get());
                responseMessage = new ResponseMessage<>(data.getContent());
                responseMessage.setResponseCode(ResponseCode.SUCCESS);
            } else {
                var data = storeOrderRepository.findAllByUserId(userId);
                responseMessage = new ResponseMessage<>(data);
                responseMessage.setResponseCode(ResponseCode.SUCCESS);
            }
        } catch (Exception e) {
            responseMessage = new ResponseMessage<>(new ArrayList<>());
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Failed to get all Card transactions " + (filter.isPresent() ? "(with filter)" : "") + " with error: " + e.getMessage());
        }
        return responseMessage;
    }
}