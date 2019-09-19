package com.kulpekin.imail.controllers.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
@Controller(value = "imail")
public interface BaseLogoutController {

    @GetMapping(value = "/logout")
    String logout(HttpServletRequest request, HttpServletResponse response);

}
