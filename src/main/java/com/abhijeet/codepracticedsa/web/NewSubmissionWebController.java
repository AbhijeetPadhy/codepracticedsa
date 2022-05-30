package com.abhijeet.codepracticedsa.web;

import com.abhijeet.codepracticedsa.submission.domain.UserEntry;
import com.abhijeet.codepracticedsa.submission.service.SubmissionService;
import com.abhijeet.codepracticedsa.web.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        model.addAttribute("firstName", userPrincipal.getUser().getFirstName());
        model.addAttribute("lastName", userPrincipal.getUser().getLastName());

        model.addAttribute("codeSubmitInput", new CodeSubmitInput());

        model.addAttribute("alertType", "info");
        model.addAttribute("alertMessage", "Fill in the details to submit your code!");

        return "submitcode";
    }

    @PostMapping("/submitcode")
    public String codeSubmit(@ModelAttribute CodeSubmitInput codeSubmitInput, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        model.addAttribute("firstName", userPrincipal.getUser().getFirstName());
        model.addAttribute("lastName", userPrincipal.getUser().getLastName());

        long userId = userPrincipal.getUser().getUserId();
        codeSubmitInput.setUserId(userId);
        submissionService.addCode(codeSubmitInput);
        model.addAttribute("codeSubmitInput", new CodeSubmitInput());
        model.addAttribute("alertType", "success");
        model.addAttribute("alertMessage", "Code Submitted! Check out My Submissions or submit more codes!");
        return "submitcode";
    }
}
