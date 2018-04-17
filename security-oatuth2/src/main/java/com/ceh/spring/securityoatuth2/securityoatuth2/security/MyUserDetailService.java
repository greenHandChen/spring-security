package com.ceh.spring.securityoatuth2.securityoatuth2.security;

import com.ceh.spring.securityoatuth2.securityoatuth2.security.domain.Role;
import com.ceh.spring.securityoatuth2.securityoatuth2.security.domain.User;
import com.ceh.spring.securityoatuth2.securityoatuth2.security.dto.UserDTO;
import com.ceh.spring.securityoatuth2.securityoatuth2.security.mapper.RoleMapper;
import com.ceh.spring.securityoatuth2.securityoatuth2.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enHui.Chen on 2018/4/10.
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(s);
        User user = userMapper.getUserByUserNameAndPassword(userDTO);
        if (user == null) {
            throw new UsernameNotFoundException("未找到该用户！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = getSimpleGrantedAuthority(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),simpleGrantedAuthorities);
    }

    public List<SimpleGrantedAuthority> getSimpleGrantedAuthority(User user) {
        List<Role> roles = roleMapper.getRolesByUserId(user.getId());
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return simpleGrantedAuthorities;
    }
}
