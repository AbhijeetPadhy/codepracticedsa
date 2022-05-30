package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.UserService;
import com.abhijeet.codepracticedsa.web.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        model.addAttribute("firstName", userPrincipal.getUser().getFirstName());
        model.addAttribute("lastName", userPrincipal.getUser().getLastName());
        List<UserEntry> listOfUsers = this.userService.getUserList();
        model.addAttribute("listOfUsers", listOfUsers);
        return "users";
    }
}
