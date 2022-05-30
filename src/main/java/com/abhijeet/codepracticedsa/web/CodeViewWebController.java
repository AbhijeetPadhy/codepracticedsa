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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        model.addAttribute("firstName", userPrincipal.getUser().getFirstName());
        model.addAttribute("lastName", userPrincipal.getUser().getLastName());

        CodeSubmission codeSubmission = submissionService.getCodeSubmissionByCodeId(codeString);
        model.addAttribute("codeSubmission", codeSubmission);
        return "code";
    }
}
