package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.service.StoreOrderService;

import fr.dtoin.StoreOrderIn;
import fr.dtoout.StoreOrderOut;
import fr.dtoout.StoreTransactionOut;
import fr.model.StoreOrder;
import fr.model.StoreTransaction;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreOrderController {
    private final StoreOrderService storeOrderService;

    public StoreOrderController(StoreOrderService storeOrderService) {
        this.storeOrderService = storeOrderService;
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
    // Other request mappings for CRUD operations or custom queries can be defined here
}