package com.cpe.cardgame.service;

import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.model.PlayParty;
import com.cpe.cardgame.model.PlayPartyViewModel;
import com.cpe.cardgame.repositories.PlayPartyRepository;
import fr.api.CardApi;
import fr.api.UserApi;
import fr.dtoin.CardIn;
import fr.dtoout.CardOut;
import fr.dtoout.PartyOut;
import fr.mapper.ModelMapperCommon;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayPartyService {

    private final PlayPartyRepository storeOrderRepository;
    private final UserApi userRepository;
    private final CardApi cardRepository;

    public PlayPartyService(
            PlayPartyRepository storeOrderRepository
    ) {
        this.storeOrderRepository = storeOrderRepository;
        this.cardRepository = new CardApi();
        this.userRepository = new UserApi();
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

    public ResponseMessage<PartyOut> createPlayParty(int userId) {
        var playerCards = this.cardRepository.getAllCardsByUserId(userId);
        PlayParty playParty = new PlayParty();
        playParty.setCardPlayerB(0);
        playParty.setWinnerId(0);
        playParty.setCurrentPlayerId(userId);
        playParty.setUserIdB(0);
        playParty.setUserIdA(userId);
        playParty.setPartyCode("BVBDBVDN");
        playParty.setStarted(Boolean.TRUE);

        if (playerCards.getResponse().size() > 0) {
            playParty.setCardPlayerA(playerCards.getResponse().get(0).getId());
        }

        var response = this.updatePlayParty(playParty);
        var message = "http://localhost:8080/view-player-party/" + response.getResponse().getId();
        response.setMessage(message);

        ResponseMessage<PartyOut> responseMessage = new ResponseMessage<>(
                ModelMapper.INSTANCE.convertToOut(response.getResponse())
        );
        responseMessage.setMessage(message);
        responseMessage.setResponseCode(ResponseCode.SUCCESS);
        return responseMessage;
    }

    List<CardOut> convertToCardOutList(List<CardIn> cards) {
        List<CardOut> cardOutList = new ArrayList<>();
        for (CardIn card : cards) {
            CardOut cardOut = ModelMapperCommon.INSTANCE.convert(card);
            cardOutList.add(cardOut);
        }
        return cardOutList;
    }

    List<CardIn> convertToCardInList(List<CardOut> cards) {
        List<CardIn> cardOutList = new ArrayList<>();
        for (CardOut card : cards) {
            CardIn cardOut = ModelMapperCommon.INSTANCE.convert(card);
            cardOutList.add(cardOut);
        }
        return cardOutList;
    }

    public ResponseMessage<PlayPartyViewModel> getPlayPartyData(int playPartyId, int userId) {
        var playParty = this.getPlayParty(playPartyId);
        if (!playParty.isSuccess()) {
            ResponseMessage<PlayPartyViewModel> responseMessage = new ResponseMessage<>(null);
            responseMessage.setResponseCode(ResponseCode.ERROR);
            responseMessage.setMessage("Party not found!");
            return responseMessage;
        }

        var cardsPlayerA = cardRepository.getAllCardsByUserId(playParty.getResponse().getUserIdA());
        var cardsPlayerB = cardRepository.getAllCardsByUserId(playParty.getResponse().getUserIdB());
        var thisUserCards = cardRepository.getAllCardsByUserId(userId);

        PlayPartyViewModel playPartyViewModel = new PlayPartyViewModel();
        playPartyViewModel.setPlayParty(playParty.getResponse());
        playPartyViewModel.setCardUserList(convertToCardInList(thisUserCards.getResponse()));
        playPartyViewModel.setPlayerCardsA(convertToCardInList(cardsPlayerA.getResponse()));
        playPartyViewModel.setPlayerCardsB(convertToCardInList(cardsPlayerB.getResponse()));

        ResponseMessage<PlayPartyViewModel> responseMessage = new ResponseMessage<>(playPartyViewModel);
        responseMessage.setResponseCode(ResponseCode.SUCCESS);
        return responseMessage;
    }



    public ResponseMessage<PartyOut> updateUserCardPlayParty(int playPartyId, int cardId, int userId) {
        var playParty = this.getPlayParty(playPartyId);
        var card = cardRepository.getCard(cardId);

        if (!playParty.isSuccess() || !card.isSuccess()) {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.ERROR);
            playPartyResponseMessage.setMessage("Either the card or the playParty doesn't exist");
            return playPartyResponseMessage;
        }

        var playerCards = cardRepository.getAllCardTransactionsForUserId(userId);
        boolean cardFound = false;

        for (var cardP : playerCards.getResponse()) {
            if (cardP.getId() == card.getResponse().getId()) {
                cardFound = true;
                break;
            }
        }

        if (!cardFound) {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.ERROR);
            playPartyResponseMessage.setMessage("You are not the card owner");
            return playPartyResponseMessage;
        }

        if (playParty.getResponse().getUserIdA() == userId) {
            playParty.getResponse().setCardPlayerA(card.getResponse().getId());
            this.updatePlayParty(playParty.getResponse());
        } else if (playParty.getResponse().getUserIdB() == userId) {
            playParty.getResponse().setCardPlayerB(card.getResponse().getId());
            this.updatePlayParty(playParty.getResponse());
        } else {
            ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
            playPartyResponseMessage.setResponseCode(ResponseCode.ERROR);
            playPartyResponseMessage.setMessage("User doesn't belong to the party");
            return playPartyResponseMessage;
        }

        ResponseMessage<PartyOut> playPartyResponseMessage = new ResponseMessage<>(null);
        playPartyResponseMessage.setResponseCode(ResponseCode.SUCCESS);
        return playPartyResponseMessage;
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

    public ResponseMessage<PlayParty> updatePlayPartyPlayer(int id, int playerId) {
        var result =  storeOrderRepository.findById(id);

        ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(result.get());
        if(!result.isPresent())
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("PlayParty not found");
        }
        else
        {
            if(result.get().getUserIdB()==0)
            {
                result.get().setUserIdB(playerId);
                var data = storeOrderRepository.save(result.get());
                responseMessage.setResponse(data);
                responseMessage.setResponseCode(ResponseCode.SUCCESS);
            }
            else {
                responseMessage.setResponseCode(ResponseCode.ERROR);
                responseMessage.setMessage("A second player already in this party, you are a spectator");
            }
        }
        return responseMessage;
    }


    public ResponseMessage<PlayParty> playerAttack(int id) {
        var result =  storeOrderRepository.findById(id);

        ResponseMessage<PlayParty> responseMessage = new ResponseMessage<>(result.get());
        if(!result.isPresent())
        {
            responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
            responseMessage.setMessage("PlayParty not found");
            return responseMessage;
        }
        else
        {
            if(result.get().getWinnerId()!=0)
            {
                if(result.get().getUserIdA()==result.get().getWinnerId())
                {
                    responseMessage.setResponseCode(ResponseCode.SUCCESS);
                    responseMessage.setMessage("Player A is the winner !");
                    return responseMessage;
                }
                else if(result.get().getUserIdB()==result.get().getWinnerId())
                {
                    responseMessage.setResponseCode(ResponseCode.SUCCESS);
                    responseMessage.setMessage("Player B is the winner !");
                    return responseMessage;
                }
                else
                {
                    responseMessage.setResponseCode(ResponseCode.ERROR);
                    responseMessage.setMessage("There is an error, neither of the two player is the winner, the game is corrupted !");
                    return responseMessage;
                }

            }
            if(result.get().getUserIdB()==0)
            {
                responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
                responseMessage.setMessage("Second PlayParty not found");
                return responseMessage;
            }
            else if(result.get().getCardPlayerA()==0 || result.get().getCardPlayerB()==0)
            {
                responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
                responseMessage.setMessage("All player need to select a card to play");
                return responseMessage;
            }
            else {
                var first_player = userRepository.getUserById(result.get().getUserIdA());
                var second_player = userRepository.getUserById(result.get().getUserIdB());

                var first_card = cardRepository.getCard(result.get().getCardPlayerA());
                var second_card = cardRepository.getCard(result.get().getCardPlayerB());

                if(!first_player.isSuccess() || !second_player.isSuccess())
                {
                    responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
                    responseMessage.setMessage("One of the two player dont exist");
                    return responseMessage;
                }
                else if(!first_card.isSuccess() || !second_card.isSuccess())
                {
                    responseMessage.setResponseCode(ResponseCode.NOT_FOUND);
                    responseMessage.setMessage("One of the two card dont exist");
                    return responseMessage;
                }
                else
                {
                    var player_a = first_player.getResponse();
                    var player_b = second_player.getResponse();

                    var card_a = first_card.getResponse();
                    var card_b = second_card.getResponse();




                    if(result.get().getCurrentPlayerId()==player_a.getId())
                    {
                        if(card_b.getHp()<card_a.getAttack())
                        {
                            card_b.setHp(0.0);
                            result.get().setWinnerId(player_a.getId());
                            player_a.setAccount(player_a.getAccount()+40.0);
                        }
                        else
                        {
                            card_b.setHp(card_b.getHp()-card_a.getAttack());
                        }
                    }
                    else
                    {
                        if(card_a.getHp()<card_b.getAttack())
                        {
                            card_a.setHp(0.0);
                            result.get().setWinnerId(player_b.getId());
                            player_b.setAccount(player_b.getAccount()+40.0);
                        }
                        else
                        {
                            card_a.setHp(card_a.getHp()-card_b.getAttack());
                        }
                    }

                    if(result.get().getCurrentPlayerId()==0)
                    {
                        result.get().setCurrentPlayerId(player_a.getId());
                    }
                    else if(result.get().getCurrentPlayerId()!=0)
                    {
                        if(result.get().getCurrentPlayerId()==player_a.getId())
                        {
                            result.get().setCurrentPlayerId(player_b.getId());
                        }
                        else
                        {
                            result.get().setCurrentPlayerId(player_a.getId());
                        }
                    }

                    userRepository.updateUser(ModelMapperCommon.INSTANCE.convert(player_a));
                    userRepository.updateUser(ModelMapperCommon.INSTANCE.convert(player_b));

                    cardRepository.updateCard(ModelMapperCommon.INSTANCE.convert(card_a));
                    cardRepository.updateCard(ModelMapperCommon.INSTANCE.convert(card_b));

                    storeOrderRepository.save(result.get());
                }
            }
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