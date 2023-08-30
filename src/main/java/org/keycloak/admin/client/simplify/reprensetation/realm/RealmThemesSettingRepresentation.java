package org.keycloak.admin.client.simplify.reprensetation.realm;

public class RealmThemesSettingRepresentation {
    private String loginTheme;
    private String accountTheme;
    private String adminTheme;
    private String emailTheme;
    private Boolean internationalizationEnabled;

    public RealmThemesSettingRepresentation() {
    }

    public RealmThemesSettingRepresentation(String loginTheme, String accountTheme, String adminTheme, String emailTheme, Boolean internationalizationEnabled) {
        this.loginTheme = loginTheme;
        this.accountTheme = accountTheme;
        this.adminTheme = adminTheme;
        this.emailTheme = emailTheme;
        this.internationalizationEnabled = internationalizationEnabled;
    }

    public String getLoginTheme() {
        return loginTheme;
    }

    public void setLoginTheme(String loginTheme) {
        this.loginTheme = loginTheme;
    }

    public String getAccountTheme() {
        return accountTheme;
    }

    public void setAccountTheme(String accountTheme) {
        this.accountTheme = accountTheme;
    }

    public String getAdminTheme() {
        return adminTheme;
    }

    public void setAdminTheme(String adminTheme) {
        this.adminTheme = adminTheme;
    }

    public String getEmailTheme() {
        return emailTheme;
    }

    public void setEmailTheme(String emailTheme) {
        this.emailTheme = emailTheme;
    }

    public Boolean getInternationalizationEnabled() {
        return internationalizationEnabled;
    }

    public void setInternationalizationEnabled(Boolean internationalizationEnabled) {
        this.internationalizationEnabled = internationalizationEnabled;
    }
}
