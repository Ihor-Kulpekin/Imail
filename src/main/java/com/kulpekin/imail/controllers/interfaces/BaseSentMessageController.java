package com.kulpekin.imail.controllers.interfaces;

import com.kulpekin.imail.models.SMS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller(value = "imail")
public interface BaseSentMessageController {

    @GetMapping(value = "/sentMessagePage")
    ModelAndView showPageSentMessage();

    @PostMapping(value = "/sentMessage")
    ModelAndView sentMessage(@Valid SMS sms, BindingResult bindingResult, ModelMap modelMap);

}
