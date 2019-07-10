package com.rubyplay.demo.demo.service;

import com.rubyplay.demo.demo.model.Visits;
import com.rubyplay.demo.demo.repository.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitsService {

    private VisitsRepository visitsRepository;

    public void registerVisit(String userName, String nightClubName) {

        Visits visit = new Visits();
        visit.setTime(new Date());
        visit.setUserName(userName);
        visit.setNightClubName(nightClubName);
        visitsRepository.save(visit);
    }

    public List<String> showAllVisitors(String nightClubName) {

        List<Visits> visits = visitsRepository.findAllByNightClubName(nightClubName);

        return visits.stream()
                .map(Visits::getUserName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> showAllVisitedNightClubs(String userName) {

        List<Visits> visits = visitsRepository.findAllByUserName(userName);

        return visits.stream()
                .map(Visits::getNightClubName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> showNotVisitedNightClubs(String userName) {

        List<Visits> visits = visitsRepository.findAllByUserNameIsNot(userName);

        return visits.stream()
                .map(Visits::getNightClubName)
                .distinct()
                .collect(Collectors.toList());
    }

    @Autowired
    public void setVisitsRepository(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }
}
