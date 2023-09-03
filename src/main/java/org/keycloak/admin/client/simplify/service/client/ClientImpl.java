package org.keycloak.admin.client.simplify.service.client;

import jakarta.validation.constraints.NotNull;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RealmsResource;
import org.keycloak.admin.client.simplify.service.realm.RealmImpl;
import org.keycloak.representations.idm.ClientRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientImpl implements Client{
    private static final Logger logger = LoggerFactory.getLogger(ClientImpl.class);

    private final Keycloak keycloak;

    public ClientImpl(@NotNull Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public void createNewClient(@NotNull RealmResource realmResource,@NotNull ClientRepresentation clientRepresentation) {
        realmResource.clients().create(clientRepresentation);
    }
}
