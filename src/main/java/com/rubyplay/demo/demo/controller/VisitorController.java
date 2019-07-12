package com.rubyplay.demo.demo.controller;

import com.rubyplay.demo.demo.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/visitor")
public class VisitorController {

    private VisitorService visitorService;

    @GetMapping("/show/visitedNightClubs")
    public ResponseEntity<List<String>> showAllVisitedNightClubs(@RequestParam("userName") String userName) {

        List<String> nightClubs = visitorService.showAllVisitedNightClubs(userName);

        return new ResponseEntity<>(nightClubs, HttpStatus.OK);
    }

    @GetMapping("/show/notVisitedNightClubs")
    public ResponseEntity<List<String>> showNotVisitedNightClubs(@RequestParam("userName") String userName) {

        List<String> nightClubs = visitorService.showNotVisitedNightClubs(userName);

        return new ResponseEntity<>(nightClubs, HttpStatus.OK);
    }

    @Autowired
    public void setVisitorService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }
}
