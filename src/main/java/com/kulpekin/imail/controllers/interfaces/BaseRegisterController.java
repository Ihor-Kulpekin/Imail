package com.kulpekin.imail.controllers.interfaces;


import com.kulpekin.imail.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller(value = "/imail")
public interface BaseRegisterController {

    @GetMapping("/register")
    ModelAndView register();

    @PostMapping("/register")
    ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap);

}
