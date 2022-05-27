package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginWebController {
    private final UserService userService;
    @Autowired
    public LoginWebController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("userLoginInput", new UserLoginInput());
        return "login";
    }
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute UserLoginInput userLoginInput, Model model){
        List<UserEntry> listOfUsers = this.userService.getUserList();
        boolean authSuccess = false;
        UserEntry user = null;
        for(int i=0;i<listOfUsers.size();i++){
            user = listOfUsers.get(i);
            if(user.isValidUser(userLoginInput.getEmail(), userLoginInput.getPassword())){
                authSuccess = true;
                break;
            }
        }
        if(authSuccess) {
            LoginState.setAuthentication(user);
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            return "dashboard";
        }
        LoginState.unsetAuthentication();
        return "login";
    }
}
