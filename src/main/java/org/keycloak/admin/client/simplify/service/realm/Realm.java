package org.keycloak.admin.client.simplify.service.realm;

import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.ServerInfoResource;
import org.keycloak.admin.client.simplify.service.reprensetation.EmailRepresentation;
import org.keycloak.representations.idm.RealmEventsConfigRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;

import java.util.List;
import java.util.Optional;

public interface Realm {

    void createNewRealm(RealmRepresentation realmRepresentation);

    RealmResource findRealmByNameToResource(String name);

    Optional<RealmResource> findRealmByNameToOptionalResource(String name);

    Optional<RealmRepresentation> findRealmByNameToRepresentation(String name);

    List<RealmRepresentation> findAll();

    void updateRealm(RealmRepresentation realmRepresentation);

    void removeRealm(String name);

    void removeRealm(RealmResource realmResource);

    void setLoginUserRegistrationAllowed(RealmResource realmResource,Boolean userRegistration);
    void setLoginEditUsernameAllowed(RealmResource realmResource,Boolean editUsername);
    void setLoginForgotPasswordAllowed(RealmResource realmResource,Boolean forgotPassword);
    void setLoginRememberMeAllowed(RealmResource realmResource,Boolean rememberMe);
    void setLoginVerifyEmailAllowed(RealmResource realmResource,Boolean verifyEmail);
    void setLoginWithEmailAllowed(RealmResource realmResource,Boolean loginWithEmail);
    void setLoginSslRequired(RealmResource realmResource,String sslRequired);

    void setSmtpServer(RealmResource realmResource, EmailRepresentation emailRepresentation);

    void setLoginTheme(RealmResource realmResource,String themeName);
    void setAccountTheme(RealmResource realmResource,String themeName);
    void setAdminConsoleTheme(RealmResource realmResource,String themeName);
    void setEmailTheme(RealmResource realmResource,String themeName);
    void setInternationalizationEnabled(RealmResource realmResource,Boolean isEnabled);




}
