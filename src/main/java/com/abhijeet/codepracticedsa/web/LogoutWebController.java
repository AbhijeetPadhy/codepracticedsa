package com.abhijeet.codepracticedsa.web;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutWebController {
    @GetMapping("/logout")
    public String logout(Model model){
        LoginState.unsetAuthentication();
        return "index";
    }
}
