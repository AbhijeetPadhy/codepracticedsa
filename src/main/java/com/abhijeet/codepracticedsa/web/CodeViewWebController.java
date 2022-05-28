package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.CodeSubmission;
import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/code")
public class CodeViewWebController {
    private final SubmissionService submissionService;

    @Autowired
    public CodeViewWebController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping(value="/{codeString}")
    public String displayCode(@PathVariable(value = "codeString")String codeString, Model model){
        if(LoginState.isIsAuthenticated()){
            CodeSubmission codeSubmission = submissionService.getCodeSubmissionByCodeId(codeString);
            UserEntry userEntry = LoginState.getUserEntry();
            model.addAttribute("userEntry", userEntry);
            model.addAttribute("codeSubmission", codeSubmission);
            return "code";
        }
        model.addAttribute("userLoginInput", new UserLoginInput());
        model.addAttribute("alertType", "warning");
        model.addAttribute("alertMessage", "Cannot access Code Section! Please Log In.");
        return "login";
    }
}
