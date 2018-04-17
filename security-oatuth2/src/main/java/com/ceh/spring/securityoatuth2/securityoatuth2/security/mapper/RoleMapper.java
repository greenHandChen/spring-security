package com.ceh.spring.securityoatuth2.securityoatuth2.security.mapper;


import com.ceh.spring.securityoatuth2.securityoatuth2.security.domain.Role;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
public interface RoleMapper {
    List<Role> getRolesByUserId(Long userId);

}
