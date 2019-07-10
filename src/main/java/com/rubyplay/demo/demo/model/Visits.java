package com.rubyplay.demo.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visits")
public class Visits {

    private int id;
    private Date time;
    private String userName;
    private String nightClubName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    @Column(name = "night_club_name")
    public String getNightClubName() {
        return nightClubName;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setNightClubName(String nightClubName) {
        this.nightClubName = nightClubName;
    }
}
