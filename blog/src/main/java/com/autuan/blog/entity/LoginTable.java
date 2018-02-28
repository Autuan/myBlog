package com.autuan.blog.entity;

public class LoginTable {

    private Integer loginId;

    private String loginName;

    private String loginEmail;

    private String loginPassword;

    private String loginQuestion1;

    private String loginQuestion2;

    private String loginAnswer1;

    private String loginAnswer2;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail == null ? null : loginEmail.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getLoginQuestion1() {
        return loginQuestion1;
    }

    public void setLoginQuestion1(String loginQuestion1) {
        this.loginQuestion1 = loginQuestion1 == null ? null : loginQuestion1.trim();
    }

    public String getLoginQuestion2() {
        return loginQuestion2;
    }

    public void setLoginQuestion2(String loginQuestion2) {
        this.loginQuestion2 = loginQuestion2 == null ? null : loginQuestion2.trim();
    }

    public String getLoginAnswer1() {
        return loginAnswer1;
    }

    public void setLoginAnswer1(String loginAnswer1) {
        this.loginAnswer1 = loginAnswer1 == null ? null : loginAnswer1.trim();
    }

    public String getLoginAnswer2() {
        return loginAnswer2;
    }

    public void setLoginAnswer2(String loginAnswer2) {
        this.loginAnswer2 = loginAnswer2 == null ? null : loginAnswer2.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginId=").append(loginId);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginEmail=").append(loginEmail);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", loginQuestion1=").append(loginQuestion1);
        sb.append(", loginQuestion2=").append(loginQuestion2);
        sb.append(", loginAnswer1=").append(loginAnswer1);
        sb.append(", loginAnswer2=").append(loginAnswer2);
        sb.append("]");
        return sb.toString();
    }
}