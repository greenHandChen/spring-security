package com.ceh.spring.securitydb.controller;

import com.ceh.spring.securitydb.dto.UserDTO;
import com.ceh.spring.securitydb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by enHui.Chen on 2018/3/22 0022.
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO getUser(UserDTO userDTO,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null){
            session = request.getSession();
        }

        session.setAttribute("test","test测试！！");
        System.out.println(session.getAttribute("test"));
        return userService.getUserByUserNameAndPassword(userDTO);
    }
}
