package com.rubyplay.demo.demo.service;

import com.rubyplay.demo.demo.model.NightClub;
import com.rubyplay.demo.demo.model.Visit;
import com.rubyplay.demo.demo.model.Visitor;
import com.rubyplay.demo.demo.repository.NightClubRepository;
import com.rubyplay.demo.demo.repository.VisitRepository;
import com.rubyplay.demo.demo.repository.VisitorRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitsService {

    private VisitorService visitorService;
    private NightClubService nightClubService;

    private VisitRepository visitRepository;
    private VisitorRepository visitorRepository;
    private NightClubRepository nightClubRepository;

    public void registerVisit(String userName, String nightClubName) {

        Visit visit = visitRepository.findByNightClub_NightClubNameAndVisitor_VisitorName(nightClubName, userName)
                .orElse(null);
        if (visit == null){
            Visit newVisit = new Visit();

            Visitor visitor = visitorRepository.findByVisitorNameEquals(userName)
                    .orElse(null);
            if (visitor == null){
                visitor = visitorService.createNewVisitor(userName);
            }

            NightClub nightClub = nightClubRepository.findByNightClubNameEquals(nightClubName)
                    .orElse(null);

            if (nightClub == null){
                nightClub = nightClubService.createNewNightClub(nightClubName);
            }

            newVisit.setVisitor(visitor);
            newVisit.setNightClub(nightClub);
            visitor.getVisits().add(newVisit);
            nightClub.getVisits().add(newVisit);

            visitRepository.save(newVisit);
        }
    }

    @Autowired
    public void setVisitorService(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @Autowired
    public void setNightClubService(NightClubService nightClubService) {
        this.nightClubService = nightClubService;
    }

    @Autowired
    public void setVisitRepository(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Autowired
    public void setVisitorRepository(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Autowired
    public void setNightClubRepository(NightClubRepository nightClubRepository) {
        this.nightClubRepository = nightClubRepository;
    }
}
