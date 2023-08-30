package org.keycloak.admin.client.simplify.service.realm;

import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.simplify.reprensetation.EmailRepresentation;
import org.keycloak.admin.client.simplify.reprensetation.RealmLoginSettingRepresentation;
import org.keycloak.admin.client.simplify.reprensetation.RealmThemesSettingRepresentation;
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

    void setRealmLoginSetting(RealmResource realmResource, RealmLoginSettingRepresentation realmLoginSettingRepresentation);

    void setSmtpServer(RealmResource realmResource, EmailRepresentation emailRepresentation);

    void setRealmThemesSetting(RealmResource realmResource, RealmThemesSettingRepresentation realmThemesSettingRepresentation);

    void clearRealmCache(RealmResource realmResource);

    void clearUserCache(RealmResource realmResource);

    void clearKeysCache(RealmResource realmResource);




}
