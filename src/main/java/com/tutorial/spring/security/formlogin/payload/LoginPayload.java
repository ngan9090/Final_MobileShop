package com.tutorial.spring.security.formlogin.payload;

public class LoginPayload {
    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginPayload() {
    }

    @Override
    public String toString() {
        return "LoginPayload{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
