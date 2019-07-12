package com.rubyplay.demo.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "visitors")
public class Visitor {
    private int id;
    private String visitorName;
    private List<Visit> visits;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    @Column(name = "visitor_name")
    public String getVisitorName() {
        return visitorName;
    }

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Visit> getVisits() {
        return visits;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }
    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
