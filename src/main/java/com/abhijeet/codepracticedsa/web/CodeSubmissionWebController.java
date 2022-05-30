package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.CodeSubmission;
import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.SubmissionService;
import com.abhijeet.codepracticedsa.web.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        model.addAttribute("firstName", userPrincipal.getUser().getFirstName());
        model.addAttribute("lastName", userPrincipal.getUser().getLastName());

        String userIdStr = "" + userPrincipal.getUser().getUserId();
        List<CodeSubmission> codeSubmissions = this.submissionService.getCodeSubmissions(userIdStr);
        model.addAttribute("codeSubmissions", codeSubmissions);

        return "submissions";
    }

    @GetMapping(value = "/{userString}")
    public String getSubmissions(@PathVariable(value = "userString")String userString, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        model.addAttribute("firstName", userPrincipal.getUser().getFirstName());
        model.addAttribute("lastName", userPrincipal.getUser().getLastName());

        List<CodeSubmission> codeSubmissions = this.submissionService.getCodeSubmissions(userString);
        model.addAttribute("codeSubmissions", codeSubmissions);

        return "submissions";
    }
}
