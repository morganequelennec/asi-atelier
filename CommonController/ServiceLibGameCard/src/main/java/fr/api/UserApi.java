package fr.api;

import fr.UrlConstant;
import fr.model.UserGame;
import fr.utils.ResponseMessage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class UserApi {
    private static final String BASE_URL = UrlConstant.getUserUrlPath();
    private RestTemplate restTemplate;

    public UserApi() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseMessage<UserGame> createUser(UserGame userGame) {
        String url = BASE_URL + "/users";
        HttpEntity<UserGame> request = new HttpEntity<>(userGame);

        ResponseEntity<ResponseMessage<UserGame>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<ResponseMessage<UserGame>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to create user");
        }
    }

    public ResponseMessage<UserGame> getUserById(int id) {
        String url = BASE_URL + "/user/" + id;

        ResponseEntity<ResponseMessage<UserGame>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseMessage<UserGame>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve user with ID: " + id);
        }
    }

    public void updateUser(UserGame user) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/user";

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set the request body
        HttpEntity<UserGame> requestEntity = new HttpEntity<>(user, headers);

        ResponseEntity<Void> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("User updated successfully.");
        } else {
            // Handle error case
            throw new RuntimeException("Failed to update user.");
        }
    }
}