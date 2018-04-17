package com.ceh.securitypwd.service;


import com.ceh.securitypwd.dto.UserRoleDTO;
import com.ceh.securitypwd.mapper.UserRoleMapper;
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
