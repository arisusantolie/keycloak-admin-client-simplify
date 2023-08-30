package org.keycloak.admin.client.simplify.reprensetation.realm;

import org.keycloak.admin.client.simplify.enums.realm.SslRequiredEnum;

public class RealmLoginSettingRepresentation {
    private Boolean registrationAllowed;
    private Boolean editUsernameAllowed;
    private Boolean resetPasswordAllowed;
    private Boolean rememberMe;
    private Boolean verifyEmail;
    private Boolean loginWithEmailAllowed;
    private String sslRequired;

    public RealmLoginSettingRepresentation(Boolean registrationAllowed, Boolean editUsernameAllowed, Boolean resetPasswordAllowed, Boolean rememberMe, Boolean verifyEmail, Boolean loginWithEmailAllowed, SslRequiredEnum sslRequired) {
        this.registrationAllowed = registrationAllowed;
        this.editUsernameAllowed = editUsernameAllowed;
        this.resetPasswordAllowed = resetPasswordAllowed;
        this.rememberMe = rememberMe;
        this.verifyEmail = verifyEmail;
        this.loginWithEmailAllowed = loginWithEmailAllowed;
        this.sslRequired = sslRequired.toString();
    }

    public RealmLoginSettingRepresentation() {
    }

    public Boolean getRegistrationAllowed() {
        return registrationAllowed;
    }

    public void setRegistrationAllowed(Boolean registrationAllowed) {
        this.registrationAllowed = registrationAllowed;
    }

    public Boolean getEditUsernameAllowed() {
        return editUsernameAllowed;
    }

    public void setEditUsernameAllowed(Boolean editUsernameAllowed) {
        this.editUsernameAllowed = editUsernameAllowed;
    }

    public Boolean getResetPasswordAllowed() {
        return resetPasswordAllowed;
    }

    public void setResetPasswordAllowed(Boolean resetPasswordAllowed) {
        this.resetPasswordAllowed = resetPasswordAllowed;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public Boolean getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(Boolean verifyEmail) {
        this.verifyEmail = verifyEmail;
    }

    public Boolean getLoginWithEmailAllowed() {
        return loginWithEmailAllowed;
    }

    public void setLoginWithEmailAllowed(Boolean loginWithEmailAllowed) {
        this.loginWithEmailAllowed = loginWithEmailAllowed;
    }

    public String getSslRequired() {
        return sslRequired;
    }

    public void setSslRequired(SslRequiredEnum sslRequired) {
        this.sslRequired = sslRequired.toString();
    }
}
