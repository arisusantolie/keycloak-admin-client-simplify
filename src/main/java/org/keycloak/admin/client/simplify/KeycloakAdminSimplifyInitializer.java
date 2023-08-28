package org.keycloak.admin.client.simplify;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.simplify.service.realm.Realm;
import org.keycloak.admin.client.simplify.service.realm.RealmImpl;

import javax.validation.constraints.NotNull;

public class KeycloakAdminSimplifyInitializer {

    private Keycloak keycloak;

    private Realm realm;

    public KeycloakAdminSimplifyInitializer(@NotNull Keycloak keycloak) {
        this.keycloak = keycloak;
        this.realm = new RealmImpl(keycloak);
    }

    public Keycloak getKeycloak() {
        return keycloak;
    }

    public void setKeycloak(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }
}
