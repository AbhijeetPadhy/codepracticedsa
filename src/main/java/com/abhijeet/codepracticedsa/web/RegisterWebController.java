package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.data.repository.UsersRepository;
import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RegisterWebController {
    private final UserService userService;
    private final UsersRepository usersRepository;

    @Autowired
    public RegisterWebController(UserService userService, UsersRepository usersRepository) {
        this.userService = userService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        if(LoginState.isIsAuthenticated()){
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            return "dashboard";
        }
        model.addAttribute("userRegisterInput", new UserRegisterInput());
        model.addAttribute("alertType", "info");
        model.addAttribute("alertMessage", "Fill in the details to register for this site!");
        return "register";
    }

    @PostMapping("/register")
    public String loginSubmit(@ModelAttribute UserRegisterInput userRegisterInput, Model model) {
        List<UserEntry> listOfUsers = this.userService.getUserList();
        boolean isNewUser = true;
        UserEntry user = null;
        for(int i=0;i<listOfUsers.size();i++){
            user = listOfUsers.get(i);
            if(user.isSameUser(userRegisterInput.getEmail())){
                isNewUser = false;
                break;
            }
        }
        String pass = userRegisterInput.getPassword();
        String cnfPass = userRegisterInput.getConfirmPassword();
        if(isNewUser && pass.equals(cnfPass)){
            userService.addUser(userRegisterInput);
            model.addAttribute("userLoginInput", new UserLoginInput());
            model.addAttribute("alertType", "success");
            model.addAttribute("alertMessage", "Successfully Registered! Please Log In.");
            return "login";
        }
        model.addAttribute("userRegisterInput", new UserRegisterInput());
        model.addAttribute("alertType", "danger");
        model.addAttribute("alertMessage", "Could not add user. Please try again!");
        return "register";
    }
}
