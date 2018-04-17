package com.ceh.securitypwd.controller;


import com.ceh.securitypwd.dto.UserDTO;
import com.ceh.securitypwd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2018/3/23 0023.
 */
@RestController
public class RegistryController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public String registry(UserDTO userDTO) {
        // 不按照指定数据格式返回，ajax回调将为error
        // 建议key和value均用双引号括起
        if (userService.registryUser(userDTO)) {
            return "{\"success\":\"true\",\"msg\":\"registrySuccess\"}";
        }
        return "{\"success\":\"true\",\"msg\":\"registryFail\"}";
    }
}
