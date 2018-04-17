package com.ceh.securitypwd.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by enHui.Chen on 2018/3/28.
 */
public class UserNoRoleException extends AuthenticationException {
    public UserNoRoleException(String errorMsg) {
        super(errorMsg);
    }
}
