package com.mar.model;

import java.sql.Date;

public class UserBO {
    private Integer user_id;
    private String username;
    private String email;
    private String password;
    private String role;
    private boolean login_sattus;
    private Date last_login;
    private Date last_logout;
    public UserBO(){
        // no body
    }

    public UserBO(String username, String email, String password, String role, boolean login_sattus, Date last_login, Date last_logout) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.login_sattus = login_sattus;
        this.last_login = last_login;
        this.last_logout = last_logout;
    }

    public UserBO(Integer user_id, String username, String email, String password, String role, boolean login_sattus, Date last_login, Date last_logout) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.login_sattus = login_sattus;
        this.last_login = last_login;
        this.last_logout = last_logout;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public boolean isLogin_sattus() {
        return login_sattus;
    }

    public void setLogin_sattus(boolean login_sattus) {
        this.login_sattus = login_sattus;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public Date getLast_logout() {
        return last_logout;
    }

    public void setLast_logout(Date last_logout) {
        this.last_logout = last_logout;
    }
}
