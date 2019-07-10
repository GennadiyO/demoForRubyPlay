package com.rubyplay.demo.demo.repository;

import com.rubyplay.demo.demo.model.Visits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitsRepository extends JpaRepository<Visits, Integer> {
    List<Visits> findAllByUserName(String userName);
    List<Visits> findAllByNightClubName(String nightClubName);
    List<Visits> findAllByUserNameIsNot(String userName);
}
