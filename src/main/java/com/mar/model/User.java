package com.mar.model;


import java.time.LocalDateTime;

public class User {
    private Integer userId;
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean loginStatus;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLogout;

    public User() {
        // no body
    }

    public User(String username, String email, String password, String role, boolean loginStatus, LocalDateTime lastLogin, LocalDateTime lastLogout) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.loginStatus = loginStatus;
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
    }

    public User(Integer userId, String username, String email, String password, String role, boolean loginStatus, LocalDateTime lastLogin, LocalDateTime lastLogout) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.loginStatus = loginStatus;
        this.lastLogin = lastLogin;
        this.lastLogout = lastLogout;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(LocalDateTime lastLogout) {
        this.lastLogout = lastLogout;
    }
}