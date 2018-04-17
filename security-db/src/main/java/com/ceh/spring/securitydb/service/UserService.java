package com.ceh.spring.securitydb.service;

import com.ceh.spring.securitydb.domain.Role;
import com.ceh.spring.securitydb.domain.User;
import com.ceh.spring.securitydb.dto.UserDTO;
import com.ceh.spring.securitydb.dto.UserRoleDTO;
import com.ceh.spring.securitydb.mapper.RoleMapper;
import com.ceh.spring.securitydb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
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
