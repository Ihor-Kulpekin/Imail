package com.kulpekin.imail.controllers.implementation;

import com.kulpekin.imail.controllers.interfaces.BaseSentMessageController;
import com.kulpekin.imail.models.SMS;
import com.kulpekin.imail.models.User;
import com.kulpekin.imail.service.interfaces.SMSServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SentMessageController implements BaseSentMessageController {

    private final SMSServiceInterface smsServiceInterface;

    @Autowired
    public SentMessageController(SMSServiceInterface smsServiceInterface) {
        this.smsServiceInterface = smsServiceInterface;
    }


    @Override
    public ModelAndView showPageSentMessage() {
        ModelAndView modelAndView = new ModelAndView("sentMessagePage");
        SMS sms = new SMS();
        modelAndView.addObject("sms",sms);
        return modelAndView;
    }

    @Override
    public ModelAndView sentMessage(@Valid SMS sms, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        // Check for the validations
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Error in sending the message");
            modelMap.addAttribute("bindingResult", bindingResult);
        }
        // we will save the user if, no binding errors
        else {
            smsServiceInterface.sentAndSaveSMS(sms);
            modelAndView.addObject("successMessage", "Message is sent successfully!");
        }
        modelAndView.addObject("sms", new SMS());
        modelAndView.setViewName("sentMessagePage");
        return modelAndView;
    }
}
