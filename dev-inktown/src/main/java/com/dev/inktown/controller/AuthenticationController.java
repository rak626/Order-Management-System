package com.dev.inktown.controller;

import com.dev.inktown.model.AuthenticationResp;
import com.dev.inktown.model.SignInRequest;
import com.dev.inktown.model.SignupRequest;
import com.dev.inktown.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
@Log
public class AuthenticationController {


    private final AuthenticationService authenticationService;
    @PostMapping("/signUp")
    public ResponseEntity<AuthenticationResp> signUp(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authenticationService.signUp(signupRequest));
    }
    @PostMapping("/signIn")
    public AuthenticationResp signIn(@RequestBody SignInRequest signInRequest){
        log.severe("in controller");

        return authenticationService.signIn(signInRequest);

    }
}
