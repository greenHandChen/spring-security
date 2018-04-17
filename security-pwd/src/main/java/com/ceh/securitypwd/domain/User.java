package com.ceh.securitypwd.domain;

import com.ceh.securitypwd.annotation.Table;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
