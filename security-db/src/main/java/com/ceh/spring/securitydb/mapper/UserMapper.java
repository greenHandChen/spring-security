package com.ceh.spring.securitydb.mapper;

import com.ceh.spring.securitydb.domain.User;
import com.ceh.spring.securitydb.dto.UserDTO;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
public interface UserMapper {
    User getUserByUserNameAndPassword(UserDTO u);

    Long registryUser(UserDTO u);
}
