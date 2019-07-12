package com.rubyplay.demo.demo.controller;

import com.rubyplay.demo.demo.service.NightClubService;
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
@RequestMapping("/api/nightClubs")
public class NightClubController {

    private NightClubService nightClubService;
    private VisitorService visitorService;

    @GetMapping("/show/allVisitors")
    public ResponseEntity<List<String>> showAllVisitors(@RequestParam("nightClubName") String nightClubName) {

        List<String> visitors = nightClubService.showAllVisitors(nightClubName);

        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @GetMapping("/show/visitorsWithMoreThan2DiffNightClubs")
    public ResponseEntity<List<String>> showVisitorsWithMoreThan2DiffNightClubs() {

        List<String> visitors = visitorService.showAllVisorsWhoVisitNumberOfNightClubs(1);

        return new ResponseEntity<>(visitors, HttpStatus.OK);
    }

    @Autowired
    public void setNightClubService(NightClubService nightClubService) {
        this.nightClubService = nightClubService;
    }

    @Autowired
    public void setVisitorService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }
}
