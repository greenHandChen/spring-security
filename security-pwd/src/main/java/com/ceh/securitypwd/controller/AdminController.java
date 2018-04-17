package com.ceh.securitypwd.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by enHui.Chen on 2018/3/21 0021.
 */
@Configuration
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String adminHello(@AuthenticationPrincipal Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "admin/hello";
    }
}
