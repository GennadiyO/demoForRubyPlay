package com.rubyplay.demo.demo.service;

import com.rubyplay.demo.demo.exceptions.AppException;
import com.rubyplay.demo.demo.model.NightClub;
import com.rubyplay.demo.demo.model.Visitor;
import com.rubyplay.demo.demo.repository.NightClubRepository;
import com.rubyplay.demo.demo.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    private VisitorRepository visitorRepository;
    private NightClubRepository nightClubRepository;

    public Visitor createNewVisitor(String userName) {

        Visitor visitor = new Visitor();
        visitor.setVisitorName(userName);
        visitor.setVisits(new ArrayList<>());

        return visitorRepository.save(visitor);
    }

    public List<String> showAllVisitedNightClubs(String userName) {

        Visitor visitor = visitorRepository.findByVisitorNameEquals(userName)
                .orElseThrow(() -> new AppException("There no user with name =" + userName));

        return visitor.getVisits().stream()
                .map(visit -> visit.getNightClub().getNightClubName())
                .collect(Collectors.toList());
    }
    public List<String> showNotVisitedNightClubs(String userName) {

        List<String> visitedNightClubs = showAllVisitedNightClubs(userName);

        List<NightClub> allNightClubs = nightClubRepository.findAll();

        List<String> allNightClubNames = allNightClubs.stream()
                .map(NightClub::getNightClubName)
                .collect(Collectors.toList());

        allNightClubNames.removeAll(visitedNightClubs);

        return allNightClubNames;
    }

    public List<String> showAllVisorsWhoVisitNumberOfNightClubs(Integer nightClubNumber){

        List<Visitor> visitors = visitorRepository.showAllVisorsWhoVisitNumberOfNightClubs(nightClubNumber);

        return visitors.stream()
                .map(Visitor::getVisitorName)
                .collect(Collectors.toList());
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
