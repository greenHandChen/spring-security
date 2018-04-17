package com.ceh.spring.securitydb.config.security;

import com.ceh.spring.securitydb.domain.Role;
import com.ceh.spring.securitydb.dto.UserDTO;
import com.ceh.spring.securitydb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO u = new UserDTO();
        u.setUsername(username);
        u = userService.getUserByUserNameAndPassword(u);
        if (u == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        // 存放用户的权限列表
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createSimpleGrantedAuthority(u);
        return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), simpleGrantedAuthorities);
    }

    // 设置权限列表
    protected List<SimpleGrantedAuthority> createSimpleGrantedAuthority(UserDTO u) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role r : u.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        }
        return authorities;
    }
}
