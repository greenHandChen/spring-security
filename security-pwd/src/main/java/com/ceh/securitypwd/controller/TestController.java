package com.ceh.securitypwd.controller;

import com.ceh.securitypwd.dto.UserDTO;
import com.ceh.securitypwd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO getUser(UserDTO userDTO) {
        return userService.getUserByUserNameAndPassword(userDTO);
    }
}
