package com.ceh.spring.securitynodb.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@AuthenticationPrincipal Principal principal, HttpServletRequest request) {
        request.setAttribute("username", principal.getName());
        return "admin/hello";
    }
}
