package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.CodeSubmission;
import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/submissions")
public class CodeSubmissionWebController {
    private final SubmissionService submissionService;

    @Autowired
    public CodeSubmissionWebController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping
    public String getSubmissions(Model model){
        if(LoginState.isIsAuthenticated()) {
            UserEntry userEntry = LoginState.getUserEntry();
            String userIdStr = ""+userEntry.getUserId();
            List<CodeSubmission> codeSubmissions = this.submissionService.getCodeSubmissions(userIdStr);
            model.addAttribute("codeSubmissions", codeSubmissions);
            model.addAttribute("userEntry", userEntry);
            return "submissions";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        return "login";
    }

    @GetMapping(value = "/{userString}")
    public String getSubmissions(@PathVariable(value = "userString")String userString, Model model){
        if(LoginState.isIsAuthenticated()) {
            List<CodeSubmission> codeSubmissions = this.submissionService.getCodeSubmissions(userString);
            model.addAttribute("codeSubmissions", codeSubmissions);
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            return "submissions";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        return "login";
    }
}
