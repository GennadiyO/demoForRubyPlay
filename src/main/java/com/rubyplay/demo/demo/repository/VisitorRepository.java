package com.rubyplay.demo.demo.repository;

import com.rubyplay.demo.demo.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VisitorRepository extends JpaRepository<Visitor, Integer>, CustomRepository {

    Optional<Visitor> findByVisitorNameEquals(String visitorName);

    List<Visitor> findAllByVisitsGreaterThan(Integer integer);
}
