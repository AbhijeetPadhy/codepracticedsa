package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserListWebController {
    private final UserService userService;

    @Autowired
    public UserListWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUserList(Model model){
        if(LoginState.isIsAuthenticated()) {
            List<UserEntry> listOfUsers = this.userService.getUserList();
            model.addAttribute("listOfUsers", listOfUsers);
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            return "users";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        model.addAttribute("alertType", "warning");
        model.addAttribute("alertMessage", "Cannot access Users! Please Log In.");
        return "login";
    }
}
