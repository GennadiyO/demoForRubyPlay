package com.rubyplay.demo.demo.repository;

import com.rubyplay.demo.demo.model.Visitor;

import java.util.List;

public interface CustomRepository {
    List<Visitor> showAllVisorsWhoVisitNumberOfNightClubs(Integer number);
}
