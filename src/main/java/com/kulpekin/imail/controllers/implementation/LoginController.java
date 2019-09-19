package com.kulpekin.imail.controllers.implementation;

import com.kulpekin.imail.controllers.interfaces.BaseLoginController;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController implements BaseLoginController {

    @Override
    public String loginInSystem() {
        return "login";
    }
}
