package com.rubyplay.demo.demo.repository;

import com.rubyplay.demo.demo.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Optional<Visit> findByNightClub_NightClubNameAndVisitor_VisitorName(String nightClubName, String visitorName);
}
