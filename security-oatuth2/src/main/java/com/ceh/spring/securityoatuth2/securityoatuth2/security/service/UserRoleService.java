package com.ceh.spring.securityoatuth2.securityoatuth2.security.service;


import com.ceh.spring.securityoatuth2.securityoatuth2.security.dto.UserRoleDTO;
import com.ceh.spring.securityoatuth2.securityoatuth2.security.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enHui.Chen on 2018/3/23 0023.
 */
@Service
public class UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    public int insertUserRole(UserRoleDTO userRoleDTO) {
        return userRoleMapper.insertUserRole(userRoleDTO);
    }
}
