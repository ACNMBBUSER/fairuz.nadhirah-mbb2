package com.fairuznadhirah.productprofile.controller;

import com.fairuznadhirah.productprofile.service.BoredService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bored")
@AllArgsConstructor
public class BoredController {

    private final BoredService boredService;

    @GetMapping("/boredActivity")
    public ResponseEntity<String> boredActivity(){
        return boredService.getBoredActivity();
    }
}
