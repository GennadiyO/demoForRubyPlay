package com.rubyplay.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "visits")
public class Visit {

    private int id;
    private Visitor visitor;
    private NightClub nightClub;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    public Visitor getVisitor() {
        return visitor;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "night_club_id", nullable = false)
    public NightClub getNightClub() {
        return nightClub;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
    public void setNightClub(NightClub nightClub) {
        this.nightClub = nightClub;
    }
}
