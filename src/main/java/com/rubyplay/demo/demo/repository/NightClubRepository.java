package com.rubyplay.demo.demo.repository;

import com.rubyplay.demo.demo.model.NightClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NightClubRepository extends JpaRepository<NightClub, Integer> {

    Optional<NightClub> findByNightClubNameEquals(String nightClubName);
}
