package com.microsoft.azure.moments.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "Home";
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }
}
