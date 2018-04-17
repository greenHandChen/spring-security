package com.ceh.spring.securitydb.dto;

import com.ceh.spring.securitydb.domain.Role;
import lombok.Data;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
public class UserDTO {
    private Long id;
    private String username;
    private String password;

    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
