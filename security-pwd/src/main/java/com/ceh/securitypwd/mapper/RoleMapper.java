package com.ceh.securitypwd.mapper;


import com.ceh.securitypwd.domain.Role;

import java.util.List;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
public interface RoleMapper {
    List<Role> getRolesByUserId(Long userId);

}
