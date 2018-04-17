package com.ceh.securitypwd.service;


import com.ceh.securitypwd.domain.Role;
import com.ceh.securitypwd.domain.User;
import com.ceh.securitypwd.dto.UserDTO;
import com.ceh.securitypwd.dto.UserRoleDTO;
import com.ceh.securitypwd.mapper.RoleMapper;
import com.ceh.securitypwd.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleService userRoleService;

    public UserDTO getUserByUserNameAndPassword(UserDTO userDTO) {
        User u = userMapper.getUserByUserNameAndPassword(userDTO);
        if (u != null) {
            userDTO = new UserDTO();
            userDTO.setId(u.getId());
            userDTO.setUsername(u.getUsername());
            userDTO.setPassword(u.getPassword());
            List<Role> roles = roleMapper.getRolesByUserId(u.getId());
            if (roles != null && roles.size() > 0) {
                userDTO.setRoles(roles);
            }
            return userDTO;
        }
        return null;
    }

    public boolean registryUser(UserDTO userDTO) {
        User user = userMapper.getUserByUserNameAndPassword(userDTO);
        if (user == null) {
            UserRoleDTO userRoleDTO = new UserRoleDTO();
            if (userMapper.registryUser(userDTO) > 0) {
                user = userMapper.getUserByUserNameAndPassword(userDTO);
                if (user != null) {
                    userRoleDTO.setRoleId(1l);
                    userRoleDTO.setUserId(user.getId());
                    userRoleService.insertUserRole(userRoleDTO);
                    return true;
                }
            }
        }
        return false;
    }

}
