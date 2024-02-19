package com.fairuznadhirah.productprofile.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @GetMapping("/userDemo")
    public ResponseEntity<String> userDemo(){
        return ResponseEntity.ok("User profile secured!");
    }

    @GetMapping("/adminDemo")
    public ResponseEntity<String> adminDemo(){
        return ResponseEntity.ok("Admin profile secured!");
    }
}
