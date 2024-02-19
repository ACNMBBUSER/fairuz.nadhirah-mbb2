package com.fairuznadhirah.productprofile.controller;

import com.fairuznadhirah.productprofile.service.BoredService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bored")
public class BoredController {

    private final BoredService boredService;

    public BoredController(BoredService boredService) {
        this.boredService = boredService;
    }

    @GetMapping("/boredActivity")
    public ResponseEntity<String> boredActivity(){
        return boredService.getBoredActivity();
    }
}
