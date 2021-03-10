package com.bd.controller;

import com.bd.exception.WrongCredentialsException;
import com.bd.security.HeaderEncryptor;
import com.bd.security.PasswordEncryptor;
import com.bd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "signIn", method = RequestMethod.POST)
public class SignInController {
    UserService userService;
    HeaderEncryptor headerEncryptor;
    PasswordEncryptor passwordEncryptor;

    @Autowired
    public void AuthController(UserService userService, HeaderEncryptor headerEncryptor, PasswordEncryptor passwordEncryptor) {
        this.userService = userService;
        this.headerEncryptor = headerEncryptor;
        this.passwordEncryptor = passwordEncryptor;
    }

    @PostMapping
    void authorize(@RequestHeader(name = "Authorization") String header) throws WrongCredentialsException {
        String login = headerEncryptor.decodeLoginFromHeaderBasic64(header);
        String password = headerEncryptor.decodePasswordFromHeaderBasic64(header);
        if (!userService.isCredentialsValid(login,password)){
            throw new WrongCredentialsException();
        }
    }
}
