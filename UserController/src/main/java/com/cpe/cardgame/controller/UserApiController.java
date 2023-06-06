package com.cpe.cardgame.controller;


import com.cpe.cardgame.entity.UserGame;
import com.cpe.cardgame.service.UserService;
import fr.utils.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserApiController extends BaseController {
    private final UserService userService;


    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/get-my-profile", method = RequestMethod.GET)
    public ResponseMessage<UserGame> GetMyUserProfile(HttpServletRequest httprequest){
        var user = GetByUser(httprequest);
        var user_n = userService.getUser(user);
        return user_n;
    }

    @RequestMapping(value = "/is-auth", method = RequestMethod.POST)
    public ResponseMessage<String> isAuth(@RequestBody Map<String, String> requestBody) {
        String token = requestBody.get("token");
        var user = checkAuth(token);

        return new ResponseMessage<String>(user.hasBody() ? user.getBody() : "");
    }
}