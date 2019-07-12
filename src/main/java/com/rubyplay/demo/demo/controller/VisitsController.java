package com.rubyplay.demo.demo.controller;

import com.rubyplay.demo.demo.service.VisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visits")
public class VisitsController {

    private VisitsService visitsService;

    @GetMapping("/register")
    public ResponseEntity<String> registerUser
            (@RequestParam("userName") String userName, @RequestParam("nightClubName") String nightClubName) {

        visitsService.registerVisit(userName, nightClubName);

        return new ResponseEntity<>("registered", HttpStatus.OK);
    }

    @Autowired
    public void setVisitsService(VisitsService visitsService) {
        this.visitsService = visitsService;
    }
}
