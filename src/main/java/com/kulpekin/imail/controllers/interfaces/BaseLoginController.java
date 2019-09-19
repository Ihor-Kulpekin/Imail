package com.kulpekin.imail.controllers.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "imail")
@FunctionalInterface
public interface BaseLoginController {

    @GetMapping(value = "/login")
    String loginInSystem();

}
