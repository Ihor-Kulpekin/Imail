package com.kulpekin.imail.controllers.implementation;

import com.kulpekin.imail.controllers.interfaces.BaseUserController;
import com.kulpekin.imail.models.SMS;
import com.kulpekin.imail.models.User;
import com.kulpekin.imail.service.interfaces.SMSServiceInterface;
import com.kulpekin.imail.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController implements BaseUserController {

    private final SMSServiceInterface smsServiceInterface;

    private final UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(SMSServiceInterface smsServiceInterface, UserServiceInterface userServiceInterface) {
        this.smsServiceInterface = smsServiceInterface;
        this.userServiceInterface = userServiceInterface;
    }

    @Override
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userServiceInterface.findUserByEmail(auth.getName());
        List<SMS> listMessage = smsServiceInterface.findSMSByTos(user.getEmail());
        modelAndView.addObject("listMessage",listMessage);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
