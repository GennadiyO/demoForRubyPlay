package com.rubyplay.demo.demo.service;

import com.rubyplay.demo.demo.exceptions.AppException;
import com.rubyplay.demo.demo.model.NightClub;
import com.rubyplay.demo.demo.repository.NightClubRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NightClubService {
    private NightClubRepository nightClubRepository;

    public NightClub createNewNightClub(String nightClubName) {
        NightClub nightClub = new NightClub();
        nightClub.setNightClubName(nightClubName);
        nightClub.setVisits(new ArrayList<>());
        return nightClubRepository.save(nightClub);
    }

    public List<String> showAllVisitors(String nightClubName) {

        NightClub nightClub = nightClubRepository.findByNightClubNameEquals(nightClubName)
                .orElseThrow(() -> new AppException("There no night club with name = " + nightClubName));

        return nightClub.getVisits().stream()
                .map(visit -> visit.getVisitor().getVisitorName())
                .collect(Collectors.toList());
    }

    @Autowired
    public void setNightClubRepository(NightClubRepository nightClubRepository) {
        this.nightClubRepository = nightClubRepository;
    }
}
