package com.rubyplay.demo.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nightclubs")
public class NightClub {
    private int id;
    private String nightClubName;
    private List<Visit> visits;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    @Column(name = "night_club_name")
    public String getNightClubName() {
        return nightClubName;
    }

    @OneToMany(mappedBy = "nightClub", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Visit> getVisits() {
        return visits;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNightClubName(String nightClubName) {
        this.nightClubName = nightClubName;
    }
    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
