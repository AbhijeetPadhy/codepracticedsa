package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardWebController {
    private final UserService userService;

    @Autowired
    public DashboardWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayDashboard(Model model){
        if(LoginState.isIsAuthenticated()){
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            return "dashboard";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        return "login";
    }
}
