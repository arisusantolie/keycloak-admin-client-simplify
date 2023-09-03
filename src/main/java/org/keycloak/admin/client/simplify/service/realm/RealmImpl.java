package org.keycloak.admin.client.simplify.service.realm;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.simplify.reprensetation.realm.*;
import org.keycloak.admin.client.simplify.utils.UtilsCopyProperties;
import org.keycloak.representations.idm.RealmRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class RealmImpl implements Realm {

    private static final Logger logger = LoggerFactory.getLogger(RealmImpl.class);

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
    public void setRealmLoginSetting(@NotNull RealmResource realmResource,@NotNull RealmLoginSettingRepresentation realmLoginSettingRepresentation) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        UtilsCopyProperties.copyNonNullProperties(realmLoginSettingRepresentation,realmRepresentation);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setSmtpServer(@NotNull RealmResource realmResource,@NotNull  EmailRepresentation emailRepresentation) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> smtpServer = objectMapper.convertValue(emailRepresentation, new TypeReference<Map<String, String>>() {});
        realmRepresentation.setSmtpServer(smtpServer);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setRealmThemesSetting(@NotNull RealmResource realmResource,@NotNull RealmThemesSettingRepresentation realmThemesSettingRepresentation) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        UtilsCopyProperties.copyNonNullProperties(realmThemesSettingRepresentation,realmRepresentation);
        updateRealm(realmRepresentation);
    }

    @Override
    public void clearRealmCache(@NotNull RealmResource realmResource) {
        realmResource.clearRealmCache();
    }

    @Override
    public void clearUserCache(@NotNull RealmResource realmResource) {
        realmResource.clearUserCache();
    }

    @Override
    public void clearKeysCache(@NotNull RealmResource realmResource) {
        realmResource.clearRealmCache();
    }

    @Override
    public void setRealmTokenSetting(@NotNull RealmResource realmResource,@NotNull RealmTokenSettingRepresentation realmTokenSettingRepresentation) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        UtilsCopyProperties.copyNonNullProperties(realmTokenSettingRepresentation,realmRepresentation);
        updateRealm(realmRepresentation);
    }

    @Override
    public void setRealmSecurityBruteForceSetting(@NotNull RealmResource realmResource,@NotNull RealmSecurityBruteForceSettingRepresentation realmSecurityBruteForceSettingRepresentation) {
        RealmRepresentation realmRepresentation=realmResource.toRepresentation();
        UtilsCopyProperties.copyNonNullProperties(realmSecurityBruteForceSettingRepresentation,realmRepresentation);
        updateRealm(realmRepresentation);
    }
}
