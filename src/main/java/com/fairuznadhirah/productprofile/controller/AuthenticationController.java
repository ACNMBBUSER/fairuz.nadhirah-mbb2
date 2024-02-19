package com.fairuznadhirah.productprofile.controller;

import com.fairuznadhirah.productprofile.model.AuthenticationResponse;
import com.fairuznadhirah.productprofile.model.UserProfile;
import com.fairuznadhirah.productprofile.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserProfile request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody UserProfile request){
        return ResponseEntity.ok(authenticationService.response(request));
    }
}
