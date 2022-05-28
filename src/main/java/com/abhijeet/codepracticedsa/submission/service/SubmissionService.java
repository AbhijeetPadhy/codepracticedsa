package com.abhijeet.codepracticedsa.submission.service;

import com.abhijeet.codepracticedsa.data.entity.Code;
import com.abhijeet.codepracticedsa.data.repository.CodeRepository;
import com.abhijeet.codepracticedsa.data.repository.UsersRepository;
import com.abhijeet.codepracticedsa.submission.domain.CodeSubmission;
import com.abhijeet.codepracticedsa.web.CodeSubmitInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubmissionService {
    private final CodeRepository codeRepository;
    private final UsersRepository usersRepository;

    public SubmissionService(CodeRepository codeRepository, UsersRepository usersRepository) {
        this.codeRepository = codeRepository;
        this.usersRepository = usersRepository;
    }

    public List<CodeSubmission> getCodeSubmissions(String userString){
        long userId = Long.parseLong(userString);
        Iterable<Code> codes = this.codeRepository.findAll();
        List<CodeSubmission> codeSubmissions = new ArrayList<>();
        codes.forEach(code -> {
            if(code.getUserId() == userId) {
                CodeSubmission codeSubmission = new CodeSubmission();
                codeSubmission.setCodeId(code.getCodeId());
                codeSubmission.setUserId(code.getUserId());
                codeSubmission.setLang(code.getLang());
                codeSubmission.setCodeTitle(code.getCodeTitle());
                codeSubmission.setCodeTopic(code.getCodeTopic());
                codeSubmission.setCodeLink(code.getCodeLink());
                codeSubmission.setCodeDesc(code.getCodeDesc());
                codeSubmission.setCodeBody(code.getCodeBody());
                codeSubmissions.add(codeSubmission);
            }
        });
        return codeSubmissions;
    }

    public CodeSubmission getCodeSubmissionByCodeId(String codeIdString){
        long codeId = Long.parseLong(codeIdString);
        Iterable<Code> codes = this.codeRepository.findAll();
        CodeSubmission codeSubmission = null;
        for(Code code : codes){
            if(code.getCodeId() == codeId) {
                codeSubmission = new CodeSubmission();
                codeSubmission.setCodeId(code.getCodeId());
                codeSubmission.setUserId(code.getUserId());
                codeSubmission.setLang(code.getLang());
                codeSubmission.setCodeTitle(code.getCodeTitle());
                codeSubmission.setCodeTopic(code.getCodeTopic());
                codeSubmission.setCodeLink(code.getCodeLink());
                codeSubmission.setCodeDesc(code.getCodeDesc());
                codeSubmission.setCodeBody(code.getCodeBody());
            }
        }
        return codeSubmission;
    }
    public void addCode(CodeSubmitInput codeSubmitInput){
        Code code = new Code();
        code.setUserId(codeSubmitInput.getUserId());
        code.setLang(codeSubmitInput.getLang());
        code.setCodeTopic(codeSubmitInput.getCodeTopic());
        code.setCodeTitle(codeSubmitInput.getCodeTitle());
        code.setCodeLink(codeSubmitInput.getCodeLink());
        code.setCodeDesc(codeSubmitInput.getCodeDesc());
        code.setCodeBody(codeSubmitInput.getCodeBody());
        codeRepository.save(code);
    }
}
