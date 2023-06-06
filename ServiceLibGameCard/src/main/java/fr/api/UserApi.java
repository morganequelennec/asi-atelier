package fr.api;

import fr.UrlConstant;
import fr.dtoin.UserIn;
import fr.dtoout.UserOut;
import fr.utils.ResponseMessage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class UserApi {
    private static final String BASE_URL = "http://service-user";
    private RestTemplate restTemplate;

    public UserApi() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseMessage<UserOut> createUser(UserIn userGame) {
        String url = BASE_URL + "/users";
        HttpEntity<UserIn> request = new HttpEntity<>(userGame);

        ResponseEntity<ResponseMessage<UserOut>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<ResponseMessage<UserOut>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to create user");
        }
    }

    public ResponseMessage<UserOut> getUserById(int id) {
        String url = BASE_URL + "/user/" + id;

        ResponseEntity<ResponseMessage<UserOut>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseMessage<UserOut>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to retrieve user with ID: " + id);
        }
    }

    public ResponseMessage<String> isAuth(String token) {
        String url = BASE_URL + "/is-auth";

        // Create request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("token", token);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<ResponseMessage<String>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ResponseMessage<String>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error case
            throw new RuntimeException("Failed to authenticate with token: " + token);
        }
    }

    public void updateUser(UserIn user) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/users";

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set the request body
        HttpEntity<UserIn> requestEntity = new HttpEntity<>(user, headers);

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