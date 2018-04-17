package com.ceh.securitypwd.mapper;


import com.ceh.securitypwd.domain.User;
import com.ceh.securitypwd.dto.UserDTO;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
public interface UserMapper {
    User getUserByUserNameAndPassword(UserDTO u);

    Long registryUser(UserDTO u);
}
