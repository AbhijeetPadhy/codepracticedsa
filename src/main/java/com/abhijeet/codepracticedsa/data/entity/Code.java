package com.abhijeet.codepracticedsa.data.entity;

import javax.persistence.*;

@Entity
@Table(name="CODE")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_ID", nullable = false)
    private long codeId;

    @Column(name="USER_ID")
    private long userId;

    @Column(name = "LANG")
    private String lang;

    @Column(name = "CODEBODY")
    private String codeBody;

    @Column(name = "CODELINK")
    private String codeLink;

    @Column(name = "CODETITLE")
    private String codeTitle;

    @Column(name = "CODETOPIC")
    private String codeTopic;

    @Column(name = "CODEDESC")
    private String codeDesc;

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

    public long getCodeId() {
        return codeId;
    }

    public void setCodeId(long codeId) {
        this.codeId = codeId;
    }
}
