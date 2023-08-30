package org.keycloak.admin.client.simplify.reprensetation.realm;

public class RealmTokenSettingRepresentation {

    /* All value for internet in Seconds */

    private String defaultSignatureAlgorithm; //Default Signature Algorithm
    private Boolean revokeRefreshToken; //Revoke Refresh Token
    private Integer refreshTokenMaxReuse; // Refresh Token Max Reuse
    private Integer ssoSessionIdleTimeout; //SSO Session Idle
    private Integer ssoSessionMaxLifespan; //SSO Session Max
    private Integer ssoSessionIdleTimeoutRememberMe; //SSO Session Idle Remember Me
    private Integer ssoSessionMaxLifespanRememberMe; //SSO Session Max Remember Me
    private Integer offlineSessionIdleTimeout; //Offline Session Idle
    private Boolean offlineSessionMaxLifespanEnabled; //Offline Session Max Limited
    private Integer offlineSessionMaxLifespan; //Offline Session Max
    private Integer clientOfflineSessionIdleTimeout; //Client Offline Session Idle
    private Integer clientOfflineSessionMaxLifespan; //Client Offline Session Max
    private Integer clientSessionIdleTimeout; //Client Session Idle
    private Integer clientSessionMaxLifespan; //Client Session Max
    private Integer accessTokenLifespan; //Access Token Lifespan
    private Integer accessTokenLifespanForImplicitFlow; //Access Token Lifespan For Implicit Flow
    private Integer accessCodeLifespan; //Client login timeout
    private Integer accessCodeLifespanLogin; // Login timeout
    private Integer accessCodeLifespanUserAction; //Login action timeout
    private Integer actionTokenGeneratedByUserLifespan; //User-Initiated Action Lifespan
    private Integer actionTokenGeneratedByAdminLifespan; //Default Admin-Initiated Action Lifespan

    public RealmTokenSettingRepresentation(String defaultSignatureAlgorithm, Boolean revokeRefreshToken, Integer refreshTokenMaxReuse, Integer ssoSessionIdleTimeout, Integer ssoSessionMaxLifespan, Integer ssoSessionIdleTimeoutRememberMe, Integer ssoSessionMaxLifespanRememberMe, Integer offlineSessionIdleTimeout, Boolean offlineSessionMaxLifespanEnabled, Integer offlineSessionMaxLifespan, Integer clientOfflineSessionIdleTimeout, Integer clientOfflineSessionMaxLifespan, Integer clientSessionIdleTimeout, Integer clientSessionMaxLifespan, Integer accessTokenLifespan, Integer accessTokenLifespanForImplicitFlow, Integer accessCodeLifespan, Integer accessCodeLifespanLogin, Integer accessCodeLifespanUserAction, Integer actionTokenGeneratedByUserLifespan, Integer actionTokenGeneratedByAdminLifespan) {
        this.defaultSignatureAlgorithm = defaultSignatureAlgorithm;
        this.revokeRefreshToken = revokeRefreshToken;
        this.refreshTokenMaxReuse = refreshTokenMaxReuse;
        this.ssoSessionIdleTimeout = ssoSessionIdleTimeout;
        this.ssoSessionMaxLifespan = ssoSessionMaxLifespan;
        this.ssoSessionIdleTimeoutRememberMe = ssoSessionIdleTimeoutRememberMe;
        this.ssoSessionMaxLifespanRememberMe = ssoSessionMaxLifespanRememberMe;
        this.offlineSessionIdleTimeout = offlineSessionIdleTimeout;
        this.offlineSessionMaxLifespanEnabled = offlineSessionMaxLifespanEnabled;
        this.offlineSessionMaxLifespan = offlineSessionMaxLifespan;
        this.clientOfflineSessionIdleTimeout = clientOfflineSessionIdleTimeout;
        this.clientOfflineSessionMaxLifespan = clientOfflineSessionMaxLifespan;
        this.clientSessionIdleTimeout = clientSessionIdleTimeout;
        this.clientSessionMaxLifespan = clientSessionMaxLifespan;
        this.accessTokenLifespan = accessTokenLifespan;
        this.accessTokenLifespanForImplicitFlow = accessTokenLifespanForImplicitFlow;
        this.accessCodeLifespan = accessCodeLifespan;
        this.accessCodeLifespanLogin = accessCodeLifespanLogin;
        this.accessCodeLifespanUserAction = accessCodeLifespanUserAction;
        this.actionTokenGeneratedByUserLifespan = actionTokenGeneratedByUserLifespan;
        this.actionTokenGeneratedByAdminLifespan = actionTokenGeneratedByAdminLifespan;
    }

    public String getDefaultSignatureAlgorithm() {
        return defaultSignatureAlgorithm;
    }

    public void setDefaultSignatureAlgorithm(String defaultSignatureAlgorithm) {
        this.defaultSignatureAlgorithm = defaultSignatureAlgorithm;
    }

    public Boolean getRevokeRefreshToken() {
        return revokeRefreshToken;
    }

    public void setRevokeRefreshToken(Boolean revokeRefreshToken) {
        this.revokeRefreshToken = revokeRefreshToken;
    }

    public Integer getRefreshTokenMaxReuse() {
        return refreshTokenMaxReuse;
    }

    public void setRefreshTokenMaxReuse(Integer refreshTokenMaxReuse) {
        this.refreshTokenMaxReuse = refreshTokenMaxReuse;
    }

    public Integer getSsoSessionIdleTimeout() {
        return ssoSessionIdleTimeout;
    }

    public void setSsoSessionIdleTimeout(Integer ssoSessionIdleTimeout) {
        this.ssoSessionIdleTimeout = ssoSessionIdleTimeout;
    }

    public Integer getSsoSessionMaxLifespan() {
        return ssoSessionMaxLifespan;
    }

    public void setSsoSessionMaxLifespan(Integer ssoSessionMaxLifespan) {
        this.ssoSessionMaxLifespan = ssoSessionMaxLifespan;
    }

    public Integer getSsoSessionIdleTimeoutRememberMe() {
        return ssoSessionIdleTimeoutRememberMe;
    }

    public void setSsoSessionIdleTimeoutRememberMe(Integer ssoSessionIdleTimeoutRememberMe) {
        this.ssoSessionIdleTimeoutRememberMe = ssoSessionIdleTimeoutRememberMe;
    }

    public Integer getSsoSessionMaxLifespanRememberMe() {
        return ssoSessionMaxLifespanRememberMe;
    }

    public void setSsoSessionMaxLifespanRememberMe(Integer ssoSessionMaxLifespanRememberMe) {
        this.ssoSessionMaxLifespanRememberMe = ssoSessionMaxLifespanRememberMe;
    }

    public Integer getOfflineSessionIdleTimeout() {
        return offlineSessionIdleTimeout;
    }

    public void setOfflineSessionIdleTimeout(Integer offlineSessionIdleTimeout) {
        this.offlineSessionIdleTimeout = offlineSessionIdleTimeout;
    }

    public Boolean getOfflineSessionMaxLifespanEnabled() {
        return offlineSessionMaxLifespanEnabled;
    }

    public void setOfflineSessionMaxLifespanEnabled(Boolean offlineSessionMaxLifespanEnabled) {
        this.offlineSessionMaxLifespanEnabled = offlineSessionMaxLifespanEnabled;
    }

    public Integer getOfflineSessionMaxLifespan() {
        return offlineSessionMaxLifespan;
    }

    public void setOfflineSessionMaxLifespan(Integer offlineSessionMaxLifespan) {
        this.offlineSessionMaxLifespan = offlineSessionMaxLifespan;
    }

    public Integer getClientOfflineSessionIdleTimeout() {
        return clientOfflineSessionIdleTimeout;
    }

    public void setClientOfflineSessionIdleTimeout(Integer clientOfflineSessionIdleTimeout) {
        this.clientOfflineSessionIdleTimeout = clientOfflineSessionIdleTimeout;
    }

    public Integer getClientOfflineSessionMaxLifespan() {
        return clientOfflineSessionMaxLifespan;
    }

    public void setClientOfflineSessionMaxLifespan(Integer clientOfflineSessionMaxLifespan) {
        this.clientOfflineSessionMaxLifespan = clientOfflineSessionMaxLifespan;
    }

    public Integer getClientSessionIdleTimeout() {
        return clientSessionIdleTimeout;
    }

    public void setClientSessionIdleTimeout(Integer clientSessionIdleTimeout) {
        this.clientSessionIdleTimeout = clientSessionIdleTimeout;
    }

    public Integer getClientSessionMaxLifespan() {
        return clientSessionMaxLifespan;
    }

    public void setClientSessionMaxLifespan(Integer clientSessionMaxLifespan) {
        this.clientSessionMaxLifespan = clientSessionMaxLifespan;
    }

    public Integer getAccessTokenLifespan() {
        return accessTokenLifespan;
    }

    public void setAccessTokenLifespan(Integer accessTokenLifespan) {
        this.accessTokenLifespan = accessTokenLifespan;
    }

    public Integer getAccessTokenLifespanForImplicitFlow() {
        return accessTokenLifespanForImplicitFlow;
    }

    public void setAccessTokenLifespanForImplicitFlow(Integer accessTokenLifespanForImplicitFlow) {
        this.accessTokenLifespanForImplicitFlow = accessTokenLifespanForImplicitFlow;
    }

    public Integer getAccessCodeLifespan() {
        return accessCodeLifespan;
    }

    public void setAccessCodeLifespan(Integer accessCodeLifespan) {
        this.accessCodeLifespan = accessCodeLifespan;
    }

    public Integer getAccessCodeLifespanLogin() {
        return accessCodeLifespanLogin;
    }

    public void setAccessCodeLifespanLogin(Integer accessCodeLifespanLogin) {
        this.accessCodeLifespanLogin = accessCodeLifespanLogin;
    }

    public Integer getAccessCodeLifespanUserAction() {
        return accessCodeLifespanUserAction;
    }

    public void setAccessCodeLifespanUserAction(Integer accessCodeLifespanUserAction) {
        this.accessCodeLifespanUserAction = accessCodeLifespanUserAction;
    }

    public Integer getActionTokenGeneratedByUserLifespan() {
        return actionTokenGeneratedByUserLifespan;
    }

    public void setActionTokenGeneratedByUserLifespan(Integer actionTokenGeneratedByUserLifespan) {
        this.actionTokenGeneratedByUserLifespan = actionTokenGeneratedByUserLifespan;
    }

    public Integer getActionTokenGeneratedByAdminLifespan() {
        return actionTokenGeneratedByAdminLifespan;
    }

    public void setActionTokenGeneratedByAdminLifespan(Integer actionTokenGeneratedByAdminLifespan) {
        this.actionTokenGeneratedByAdminLifespan = actionTokenGeneratedByAdminLifespan;
    }
}
