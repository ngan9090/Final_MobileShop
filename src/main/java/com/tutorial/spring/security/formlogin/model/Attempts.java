package com.tutorial.spring.security.formlogin.model;

import javax.persistence.*;

@Entity
@Table(name = "attempt")
public class Attempts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="attempts")
    private Integer attempts;

    public Attempts() {
    }

    public Attempts(String username, int attempts) {
        this.username = username;
        this.attempts = attempts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public String toString() {
        return "Attempts{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", attempts=" + attempts +
                '}';
    }
}
