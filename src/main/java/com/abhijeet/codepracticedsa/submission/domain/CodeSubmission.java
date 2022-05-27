package com.abhijeet.codepracticedsa.submission.domain;

import javax.persistence.Column;

public class CodeSubmission {
    private long codeId;
    private long userId;
    private String lang;
    private String codeBody;
    private String codeLink;
    private String codeTitle;
    private String codeTopic;

    public long getCodeId() {
        return codeId;
    }

    public void setCodeId(long codeId) {
        this.codeId = codeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCodeBody() {
        return codeBody;
    }

    public void setCodeBody(String codeBody) {
        this.codeBody = codeBody;
    }

    public String getCodeLink() {
        return codeLink;
    }

    public void setCodeLink(String codeLink) {
        this.codeLink = codeLink;
    }

    public String getCodeTitle() {
        return codeTitle;
    }

    public void setCodeTitle(String codeTitle) {
        this.codeTitle = codeTitle;
    }

    public String getCodeTopic() {
        return codeTopic;
    }

    public void setCodeTopic(String codeTopic) {
        this.codeTopic = codeTopic;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    private String codeDesc;
}
