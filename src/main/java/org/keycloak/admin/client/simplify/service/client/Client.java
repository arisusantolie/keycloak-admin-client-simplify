package org.keycloak.admin.client.simplify.service.client;

import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.ClientRepresentation;

public interface Client {

    public void createNewClient(RealmResource realmResource, ClientRepresentation clientRepresentation);
}
