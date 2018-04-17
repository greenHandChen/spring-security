package com.ceh.securitypwd.security;

import com.ceh.securitypwd.domain.Role;
import com.ceh.securitypwd.dto.UserDTO;
import com.ceh.securitypwd.security.exception.UserNoRoleException;
import com.ceh.securitypwd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/28.
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(s);
        userDTO = userService.getUserByUserNameAndPassword(userDTO);
        if (userDTO == null) {
            throw new UsernameNotFoundException("未找到当前用户！");
        }
        if (userDTO.getRoles() == null || userDTO.getRoles().size() < 1) {
            throw new UserNoRoleException("当前用户未分配角色！");
        }
        // 用户名，密码，用户角色列表
        return new User(userDTO.getUsername(), userDTO.getPassword(), geSimpleGrantedAuthorities(userDTO));
    }

    private List<SimpleGrantedAuthority> geSimpleGrantedAuthorities(UserDTO userDTO) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : userDTO.getRoles()) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }
}
