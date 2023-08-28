package org.keycloak.admin.client.simplify.service.realm;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.ServerInfoResource;
import org.keycloak.representations.idm.RealmRepresentation;
import javax.validation.constraints.NotNull;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;


public class RealmImpl implements Realm {

//    private static final Logger LOG = LoggerFactory.getLogger(RealmImpl.class);

    private final Keycloak keycloak;

    public RealmImpl(@NotNull Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public void createNewRealm(@NotNull RealmRepresentation realmRepresentation) {
        keycloak.realms().create(realmRepresentation);
    }

    @Override
    public RealmResource findRealmByNameToResource(@NotNull String name) {
        return keycloak.realm(name);
    }

    @Override
    public Optional<RealmRepresentation> findRealmByNameToRepresentation(@NotNull String name) {
        RealmResource realmResource=findRealmByNameToResource(name);

        try{
            return Optional.ofNullable(realmResource.toRepresentation());
        }catch (NotFoundException ex){
            return Optional.empty();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<RealmRepresentation> findAll() {
        return keycloak.realms().findAll();
    }

    @Override
    public Optional<RealmResource> findRealmByNameToOptionalResource(@NotNull String name) {
        Optional<RealmRepresentation> realmRepresentation=findRealmByNameToRepresentation(name);
        if(realmRepresentation.isPresent()){
            return Optional.of(findRealmByNameToResource(realmRepresentation.get().getRealm()));
        }else{
            return Optional.empty();
        }

    }

    @Override
    public void updateRealm(@NotNull RealmRepresentation realmRepresentation) {
        keycloak.realm(realmRepresentation.getRealm()).update(realmRepresentation);
    }

    @Override
    public void removeRealm(@NotNull String name) {
        Optional<RealmResource> realmResource=findRealmByNameToOptionalResource(name);
        if(realmResource.isPresent()){
            realmResource.get().remove();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void removeRealm(@NotNull RealmResource realmResource) {
        realmResource.remove();
    }

    @Override
    public void setLoginUserRegistrationAllowed(@NotNull RealmResource realmResource,@NotNull Boolean userRegistration) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setRegistrationAllowed(userRegistration);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setLoginEditUsernameAllowed(@NotNull RealmResource realmResource,@NotNull Boolean editUsername) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setEditUsernameAllowed(editUsername);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setLoginForgotPasswordAllowed(@NotNull RealmResource realmResource,@NotNull Boolean forgotPassword) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setResetPasswordAllowed(forgotPassword);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setLoginRememberMeAllowed(@NotNull RealmResource realmResource,@NotNull Boolean rememberMe) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setRememberMe(rememberMe);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setLoginVerifyEmailAllowed(@NotNull RealmResource realmResource,@NotNull Boolean verifyEmail) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setVerifyEmail(verifyEmail);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setLoginWithEmailAllowed(@NotNull RealmResource realmResource,@NotNull Boolean loginWithEmail) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setLoginWithEmailAllowed(loginWithEmail);
        updateRealm(realmRepresentation);
    }

    /*
    sslRequired value :
                - all (desc : all request)
                - external (desc : external request)
                - none (desc : none)
     */
    @Override
    public void setLoginSslRequired(@NotNull RealmResource realmResource,@NotNull String sslRequired) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        realmRepresentation.setSslRequired(sslRequired);
        updateRealm(realmRepresentation);
    }
}
