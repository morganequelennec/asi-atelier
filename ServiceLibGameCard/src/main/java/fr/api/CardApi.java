package fr.api;

import fr.UrlConstant;
import fr.dtoin.CardIn;
import fr.dtoout.CardOut;
import fr.utils.ResponseMessage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CardApi {
    private static final String BASE_URL = UrlConstant.getCardUrlPath();

    public ResponseMessage<List<CardOut>> getAllCardsByUserId(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/cards-of-user/" + userId;

        ResponseEntity<ResponseMessage<List<CardOut>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseMessage<List<CardOut>>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve cards for user ID: " + userId);
        }
    }

    public ResponseMessage<CardOut> getCard(int cardId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/card/" + cardId;

        ResponseEntity<ResponseMessage<CardOut>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseMessage<CardOut>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve cards for user ID: " + cardId);
        }
    }

    public ResponseMessage<CardOut> updateCard(CardIn card) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/card";

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set the request body
        HttpEntity<CardIn> requestEntity = new HttpEntity<>(card, headers);

        ResponseEntity<ResponseMessage<CardOut>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ResponseMessage<CardOut>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to update card: " + card.toString());
        }
    }
    public ResponseMessage<List<CardOut>> getAllCardTransactionsForUserId(Integer userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/cards/user/" + userId;

        ResponseEntity<ResponseMessage<List<CardOut>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseMessage<List<CardOut>>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve card transactions for user ID: " + userId);
        }
    }
}