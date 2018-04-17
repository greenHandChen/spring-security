package com.ceh.spring.securityoatuth2.securityoatuth2.security.mapper;


import com.ceh.spring.securityoatuth2.securityoatuth2.security.domain.User;
import com.ceh.spring.securityoatuth2.securityoatuth2.security.dto.UserDTO;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
public interface UserMapper {
    User getUserByUserNameAndPassword(UserDTO u);

    Long registryUser(UserDTO u);
}
