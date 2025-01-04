package com.github.angelglgl.pmtemplater.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;
import com.github.angelglgl.pmtemplater.services.IAuthService;
import com.github.angelglgl.pmtemplater.services.models.dto.LoginDTO;
import com.github.angelglgl.pmtemplater.services.models.dto.ResponseDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthControllers {
    @Autowired
    IAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody UsersEntity user) throws Exception {
        return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody LoginDTO loginRequest) throws Exception{
        HashMap<String,String> login = authService.login(loginRequest);
        if(login.containsKey("jwt")){
            return new ResponseEntity<>(login, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
        }
    }
}
