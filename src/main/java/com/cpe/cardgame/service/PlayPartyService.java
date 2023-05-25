package com.cpe.cardgame.service;

import com.cpe.cardgame.model.PlayParty;
import com.cpe.cardgame.model.StoreOrder;
import com.cpe.cardgame.repositories.PlayPartyRepository;
import com.cpe.cardgame.repositories.StoreOrderRepository;
import com.cpe.cardgame.utils.ResponseCode;
import com.cpe.cardgame.utils.ResponseMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PlayPartyService {

    private final PlayPartyRepository storeOrderRepository;

    public PlayPartyService(PlayPartyRepository storeOrderRepository) {
        this.storeOrderRepository = storeOrderRepository;
    }

    // Example method for updating a user
    public ResponseMessage<PlayParty> updatePlayParty(PlayParty storeOrder) {
        var result =  storeOrderRepository.save(storeOrder);
        ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(result);
        if(result == null)
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("PlayParty not found");
        }
        else
        {
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        return responseMessage;
    }

    public ResponseMessage<PlayParty> getPlayParty(Integer id) {
        var result =  storeOrderRepository.findById(id);
        ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(result.get());
        if(!result.isPresent())
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("PlayParty not found");
        }
        else
        {
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        return responseMessage;
    }

    public ResponseMessage<PlayParty> getPlayPartyByCode(String code) {
        var result =  storeOrderRepository.findByCode(code);
        ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(result.get());
        if(!result.isPresent())
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("PlayParty not found");
        }
        else
        {
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
        }
        return responseMessage;
    }

    public ResponseMessage<List<PlayParty>> getAllPlayParty(Optional<Pageable> filter) {

        ResponseMessage<List<PlayParty>> responseMessage = null;
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
            responseMessage.setMessage("Failed to get all PlayParty " +(filter.isPresent()?"(with filter)":"") + " with error :"+e.getMessage());
        }
        return responseMessage;
    }



    public ResponseMessage<PlayParty> deletePlayParty(PlayParty storeOrder) {
        storeOrderRepository.delete(storeOrder);
        var result = storeOrderRepository.findById(storeOrder.getId());

        if(!result.isPresent())
        {
            ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(storeOrder);
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(storeOrder);
            responseMessage.setMessage("PlayParty deletion failed");
            responseMessage.setResponseCode(ResponseCode.ERROR);
            return responseMessage;
        }

    }

    public ResponseMessage<PlayParty> deletePlayParty(int storeOrder) {
        var result = storeOrderRepository.findById(storeOrder);
        if(result.isPresent())
        {
            return deletePlayParty(result.get());
        }
        else
        {
            ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(null);
            responseMessage.setMessage("PlayParty deletion failed");
            responseMessage.setResponseCode(ResponseCode.ERROR);
            return responseMessage;
        }
    }
}