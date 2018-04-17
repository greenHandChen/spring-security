package com.ceh.spring.securityoatuth2.securityoatuth2.security.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enHui.Chen on 2018/4/8.
 */
@RestController
@RequestMapping("/myOauth")
public class Oauth2Controller {
    @RequestMapping(value = "/authentication/{resource}")
    public String authentication(@PathVariable String resource) {
        return "this " + resource + "  is under the authentication";
    }

    @RequestMapping(value = "/unaAthentication/{resource}")
    public String unaAthentication(@PathVariable String resource) {
        return "this " + resource + "  is under the unaAthentication";
    }
}
