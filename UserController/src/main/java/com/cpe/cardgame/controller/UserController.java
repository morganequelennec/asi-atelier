package com.cpe.cardgame.controller;


import com.cpe.cardgame.ModelMapper;
import com.cpe.cardgame.entity.UserGame;
import com.cpe.cardgame.service.UserService;
import fr.dtoin.UserIn;
import fr.dtoout.UserOut;
import fr.mapper.ModelMapperCommon;
import fr.utils.KeyHost;
import fr.utils.ResponseCode;
import fr.utils.ResponseMessage;
import fr.viewmodel.AuthDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController {
    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseMessage<UserOut> createUser(@RequestBody UserIn userGame) {
        var model = this.userService.updateUser(ModelMapper.INSTANCE.convert(userGame));
        if(model.isSuccess())
        {
            ResponseMessage<UserOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<UserOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            return responseMessage;
        }
    }

    @GetMapping("/user/{id}")
    public ResponseMessage<UserOut> getUserById(@PathVariable("id") int id) {
         var model = this.userService.getUser(id);
        if(model.isSuccess())
        {
            ResponseMessage<UserOut> responseMessage = new ResponseMessage<>(
                    ModelMapper.INSTANCE.convertToOut(model.getResponse())
            );
            responseMessage.setResponseCode(ResponseCode.SUCCESS);
            return responseMessage;
        }
        else
        {
            ResponseMessage<UserOut> responseMessage = new ResponseMessage<>(
                    null
            );
            responseMessage.setResponseCode(ResponseCode.ERROR);
            return responseMessage;
        }
    }
    @GetMapping(value = { "/connexion"})
	public String connexion(Model model) {
		AuthDTO userform = new AuthDTO();
		model.addAttribute("connectForm", userform);
		return "connectForm";
	}
    @PostMapping(value="/connexion")
    public ResponseMessage<UserOut> connecUser(@ModelAttribute("connectForm") AuthDTO userform, HttpServletRequest httprequest){
        var user = this.userService.connect(userform.getUsername(), userform.getPassword());
        if(user.isSuccess())
        {
            if(KeyHost.DataKey ==null)
            {
                KeyHost.DataKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            }
            String jwt = Jwts.builder()
                    .setSubject(user.getResponse().getId().toString()) // Assuming user ID is a String
                    .signWith(KeyHost.DataKey)
                    .compact();
            user.getResponse().setSession(jwt);
            return user.toType(ModelMapper.INSTANCE.convertToOut(user.getResponse()));
        }
        else
        {
            return user.toNull();
        }
    }

    @GetMapping(value="/my-profile")
    public ResponseMessage<UserOut> UserProfile( HttpServletRequest httprequest){
        var user = GetByUser(httprequest);
        if(user == 0)
        {
            ResponseMessage<UserOut> responseMessage = new ResponseMessage<UserOut>(null);
            responseMessage.setResponseCode(ResponseCode.FORBIDDEN);
            responseMessage.setMessage("You must log in");
            return responseMessage;
        }
        var profile = this.userService.getUser(user);
        if(profile.isSuccess())
        {
            return profile.toType(ModelMapper.INSTANCE.convertToOut(profile.getResponse()));
        }
        else
        {
            return profile.toNull();
        }
    }


    @GetMapping(value = { "/create-user"})
	public String createUser() {
		UserGame userform = new UserGame();
		return "createForm";
	}
    @PostMapping(value="/create-user")
    public ResponseMessage<UserOut> createUserAction(@ModelAttribute("createForm") UserGame userform){
        var user = this.userService.updateUser(userform);
        if(user.isSuccess())
        {
            return user.toType(ModelMapper.INSTANCE.convertToOut(user.getResponse()));
        }
        else
        {
            return user.toNull();
        }
    }

}