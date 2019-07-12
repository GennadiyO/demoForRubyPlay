package com.rubyplay.demo.demo.repository;

import com.rubyplay.demo.demo.model.Visitor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomRepositoryImpl implements CustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Visitor> showAllVisorsWhoVisitNumberOfNightClubs(Integer number) { //The native query can be changed to criteria query

        Query nativeQuery = em.createNativeQuery(
                "select * from visitors where id IN (select visitor_id from visits group by night_club_id having count(*) > ?)",
                Visitor.class);
        nativeQuery.setParameter(1, String.valueOf(number));

        return (List<Visitor>) nativeQuery.getResultList();
    }
}
