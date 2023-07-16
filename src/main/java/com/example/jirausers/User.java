package com.example.jirausers;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;

    public String userId;
    public String email;
    public String fullName;
    public String jobTitle;
    public String department;
    public String startDate;
    public Boolean active;
    public String team;
    public String phone;

    public User() {
    }

    public User(String userId, String email, String fullName, String jobTitle, String department, String startDate,
            Boolean active, String team, String phone) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.startDate = startDate;
        this.active = active;
        this.team = team;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, userId='%s', email='%s', fullName='%s', jobTitle='%s', department='%s', startDate='%s', active='%b', team='%s', phone='%s']",
                id, userId, email, fullName, jobTitle, department, startDate, active, team, phone);
    }
}
