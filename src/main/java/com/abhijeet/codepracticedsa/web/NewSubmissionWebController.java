package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewSubmissionWebController {
    private final SubmissionService submissionService;

    @Autowired
    public NewSubmissionWebController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("/submitcode")
    public String submitForm(Model model){
        if(LoginState.isIsAuthenticated()){
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            model.addAttribute("codeSubmitInput", new CodeSubmitInput());
            model.addAttribute("alertType", "info");
            model.addAttribute("alertMessage", "Fill in the details to submit your code!");
            return "submitcode";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        model.addAttribute("alertType", "warning");
        model.addAttribute("alertMessage", "Cannot access Code Section! Please Log In.");
        return "login";
    }

    @PostMapping("/submitcode")
    public String codeSubmit(@ModelAttribute CodeSubmitInput codeSubmitInput, Model model){
        if(LoginState.isIsAuthenticated()){
            long userId = LoginState.getUserEntry().getUserId();
            codeSubmitInput.setUserId(userId);
            submissionService.addCode(codeSubmitInput);
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            model.addAttribute("codeSubmitInput", new CodeSubmitInput());
            model.addAttribute("alertType", "success");
            model.addAttribute("alertMessage", "Code Submitted! Check out My Submissions or submit more codes!");
            return "submitcode";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        model.addAttribute("alertType", "warning");
        model.addAttribute("alertMessage", "Cannot access Code Section! Please Log In.");
        return "login";
    }
}
