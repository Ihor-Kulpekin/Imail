package com.kulpekin.imail.controllers.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "imail")
public interface BaseUserController {

    @GetMapping(value = "/home")
    ModelAndView homePage();

}
