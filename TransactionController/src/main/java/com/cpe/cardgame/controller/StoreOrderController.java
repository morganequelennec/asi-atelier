package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.entity.StoreOrder;
import com.cpe.cardgame.entity.StoreTransaction;
import com.cpe.cardgame.service.StoreOrderService;

import com.cpe.cardgame.service.StoreTransactionService;
import fr.api.CardApi;
import fr.api.UserApi;
import fr.dtoin.StoreOrderIn;
import fr.dtoout.StoreOrderOut;
import fr.dtoout.StoreTransactionOut;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import org.apache.catalina.User;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreOrderController extends BaseController {
    private final StoreOrderService storeOrderService;

    private final CardApi cardApi = new CardApi();
    private final UserApi userApi = new UserApi();
    private final StoreTransactionService storeTransactionService;

    public StoreOrderController(
            StoreOrderService storeOrderService,
            StoreTransactionService storeTransactionService
    ) {
        this.storeOrderService = storeOrderService;
        this.storeTransactionService = storeTransactionService;
    }

    @PostMapping("/storeOrder")
    public ResponseMessage<StoreOrderOut> createStoreOrder(StoreOrderIn storeOrder) {
        var model = this.storeOrderService.updateStoreOrder(
                ModelMapper.INSTANCE.convert(storeOrder)
        );
        if(model.isSuccess())
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @GetMapping("/storeOrder/{id}")
    public ResponseMessage<StoreOrderOut> getStoreOrderById(@PathVariable("id") int id) {

        var model = this.storeOrderService.getStoreOrder(
                id
        );
        if(model.isSuccess())
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @DeleteMapping("/storeOrder/{id}")
    public ResponseMessage<StoreOrderOut> deleteStoreOrderById(@PathVariable("id") int id) {
        var model = this.storeOrderService.deleteStoreOrder(
                id
        );
        if(model.isSuccess())
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }

    }
    List<StoreOrderOut> convertToStoreOrderOutList(List<StoreOrder> transactions) {
        List<StoreOrderOut> transactionOutList = new ArrayList<>();
        for (StoreOrder transaction : transactions) {
            StoreOrderOut transactionOut = ModelMapper.INSTANCE.convertToOut(transaction);
            transactionOutList.add(transactionOut);
        }
        return transactionOutList;
    }
    @GetMapping("/storeOrders")
    public ResponseMessage<List<StoreOrderOut>> getStores() {
        var model = this.storeOrderService.getAllStoreOrder(Optional.empty());
        if(model.isSuccess())
        {
            ResponseMessage<List<StoreOrderOut>> responseMessage = new ResponseMessage<>(
                    convertToStoreOrderOutList(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<List<StoreOrderOut>> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }
    @GetMapping("/storeOrders/{userId}")
    public ResponseMessage<List<StoreOrderOut>> getStoreOrdersByUserId(@PathVariable Integer userId) {
        var model = this.storeOrderService.getAllStoreOrderForUserId(Optional.empty(), userId);
        if(model.isSuccess())
        {
            ResponseMessage<List<StoreOrderOut>> responseMessage = new ResponseMessage<>(
                    convertToStoreOrderOutList(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<List<StoreOrderOut>> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @GetMapping("/storeOrdersCard/MakeBuy/{cardId}")
    public ResponseMessage<StoreOrderOut> buyCardForUser(HttpServletRequest httpServletRequest, @PathVariable Integer cardId) {
        var user = this.GetByUser(httpServletRequest);
        var the_user = userApi.getUserById(user);
        var the_card = cardApi.getCard(cardId);
        //We check if the user has enough amount in his account
        if(the_user.getResponse().getAccount()-the_card.getResponse().getPrice()<0)
        {
            ResponseMessage<StoreOrderOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You dont have enough money");
            return responseMessage;
        }
        StoreOrder storeOrder =new StoreOrder();
        storeOrder.setCardId(the_card.getResponse().getId());
        storeOrder.setUserId(the_user.getResponse().getId());
        var storeOrderResult = this.storeOrderService.getStoreOrderByTuple(the_user.getResponse().getId(),the_card.getResponse().getId());
        //If an order already exist for the corresponding tuple user, card
        if(storeOrderResult.isSuccess())
        {
            storeOrder = storeOrderResult.getResponse();
        }
        else
        {
            // We create/save the user order and its transaction
            storeOrderResult = this.storeOrderService.updateStoreOrder(storeOrder);
            storeOrder = storeOrderResult.getResponse();
        }

        // We create the corresponding transaction
        StoreTransaction transaction = new StoreTransaction();
        transaction.setCardId(storeOrder.getCardId());
        transaction.setUserId(storeOrder.getUserId());
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAction("Buy Card");

        // We update the user account
        the_user.getResponse().setAccount(the_user.getResponse().getAccount()-the_card.getResponse().getPrice());
        this.userApi.updateUser(ModelMapper.INSTANCE.convert(the_user.getResponse()));

        //We get the owner of the card and update its account :
        if(the_card.getResponse().getUserId()!=0)
        {
            var owner = this.userApi.getUserById(the_card.getResponse().getUserId());
            owner.getResponse().setAccount(owner.getResponse().getAccount()+the_card.getResponse().getPrice());
            this.userApi.updateUser(ModelMapper.INSTANCE.convert(owner.getResponse()));
        }


        //we update the card owner :
        the_card.getResponse().setUserId(user);
        the_card.getResponse().setToSell(Boolean.FALSE);
        this.cardApi.updateCard(ModelMapper.INSTANCE.convert(the_card.getResponse()));


        var transactionResult = this.storeTransactionService.updateStoreTransaction(transaction);


        return storeOrderResult.toType(ModelMapper.INSTANCE.convertToOut(storeOrderResult.getResponse()));
    }


    @GetMapping("/storeOrdersCard/MakeSell/{cardId}")
    public ResponseMessage<StoreOrderOut> sellCardForUser(HttpServletRequest httpServletRequest, @PathVariable Integer cardId) {
        var user = this.GetByUser(httpServletRequest);
        var the_user = userApi.getUserById(user);
        var the_card = cardApi.getCard(cardId);
        //Prepare sell order with transaction
        StoreOrder storeOrder =new StoreOrder();
        storeOrder.setCardId(the_card.getResponse().getId());
        storeOrder.setUserId(the_user.getResponse().getId());
        var storeOrderResult = this.storeOrderService.getStoreOrderByTuple(the_user.getResponse().getId(),the_card.getResponse().getId());
        //If an order already exist for the corresponding tuple user, card
        if(storeOrderResult.isSuccess())
        {
            storeOrder = storeOrderResult.getResponse();
        }
        else
        {
            // We create/save the user order and its transaction
            storeOrderResult = this.storeOrderService.updateStoreOrder(storeOrder);
            storeOrder = storeOrderResult.getResponse();
        }

        // We create the corresponding transaction
        StoreTransaction transaction = new StoreTransaction();
        transaction.setCardId(storeOrder.getCardId());
        transaction.setUserId(storeOrder.getUserId());
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAction("Sell Card");


        //we update the card owner :
        the_card.getResponse().setToSell(Boolean.TRUE);
        this.cardApi.updateCard(ModelMapper.INSTANCE.convert(the_card.getResponse()));


        var transactionResult = this.storeTransactionService.updateStoreTransaction(transaction);


        return storeOrderResult.toType(ModelMapper.INSTANCE.convertToOut(storeOrderResult.getResponse()));
    }
    // Other request mappings for CRUD operations or custom queries can be defined here
}