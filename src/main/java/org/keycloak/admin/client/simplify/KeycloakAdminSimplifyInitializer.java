package org.keycloak.admin.client.simplify;

import jakarta.validation.constraints.NotNull;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.simplify.service.realm.Realm;
import org.keycloak.admin.client.simplify.service.realm.RealmImpl;


public class KeycloakAdminSimplifyInitializer {

    private Realm realm;

    public KeycloakAdminSimplifyInitializer(@NotNull Keycloak keycloak) {
        this.realm = new RealmImpl(keycloak);
    }

    public Realm getRealm() {
        return realm;
    }

    public void setRealm(Realm realm) {
        this.realm = realm;
    }
}
