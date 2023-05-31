package com.cpe.cardgame.controller;

import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.entity.StoreTransaction;
import com.cpe.cardgame.service.StoreTransactionService;
import fr.dtoin.StoreTransactionIn;
import fr.dtoout.StoreTransactionOut;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreTransactionController {
    private final StoreTransactionService storeTransactionService;

    public StoreTransactionController(StoreTransactionService storeTransactionService) {
        this.storeTransactionService = storeTransactionService;
    }

    @PostMapping("/storeTransaction")
    public ResponseMessage<StoreTransactionOut> createStoreTransaction(StoreTransactionIn storeTransaction) {
        var model= this.storeTransactionService.updateStoreTransaction(
                ModelMapper.INSTANCE.convert(storeTransaction)
        );
        if(model.isSuccess())
        {
            ResponseMessage<StoreTransactionOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<StoreTransactionOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }

    }

    @GetMapping("/storeTransaction/{id}")
    public ResponseMessage<StoreTransactionOut> getStoreTransactionById(@PathVariable("id") int id) {
        var model = this.storeTransactionService.getStoreTransaction(id);
        if(model.isSuccess())
        {
            ResponseMessage<StoreTransactionOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<StoreTransactionOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }

    }

    @DeleteMapping("/storeTransaction/{id}")
    public ResponseMessage<StoreTransactionOut> deleteStoreTransactionById(@PathVariable("id") int id) {
        var model = this.storeTransactionService.deleteStoreTransaction(id);
        if(model.isSuccess())
        {
            ResponseMessage<StoreTransactionOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<StoreTransactionOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    List<StoreTransactionOut> convertToStoreTransactionOutList(List<StoreTransaction> transactions) {
        List<StoreTransactionOut> transactionOutList = new ArrayList<>();
        for (StoreTransaction transaction : transactions) {
            StoreTransactionOut transactionOut = ModelMapper.INSTANCE.convertToOut(transaction);
            transactionOutList.add(transactionOut);
        }
        return transactionOutList;
    }

    @GetMapping("/storeTransactions")
    public ResponseMessage<List<StoreTransactionOut>> getStoreTransactions() {
        var model = this.storeTransactionService.getAllStoreTransaction(Optional.empty());
        if(model.isSuccess())
        {
            ResponseMessage<List<StoreTransactionOut>> responseMessage = new ResponseMessage<>(
                    convertToStoreTransactionOutList(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<List<StoreTransactionOut>> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    @GetMapping("/storeTransactions/{userId}")
    public ResponseMessage<List<StoreTransactionOut>> getStoreTransactionsByUserId(@PathVariable Integer userId) {
        var model = this.storeTransactionService.getAllStoreTransactionForUserId(Optional.empty(), userId);
        if(model.isSuccess())
        {
            ResponseMessage<List<StoreTransactionOut>> responseMessage = new ResponseMessage<>(
                    convertToStoreTransactionOutList(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<List<StoreTransactionOut>> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage(model.getMessage());
            return responseMessage;
        }
    }

    // Other request mappings for CRUD operations or custom queries can be defined here
}