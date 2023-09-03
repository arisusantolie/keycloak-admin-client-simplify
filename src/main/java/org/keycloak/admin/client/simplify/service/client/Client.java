package org.keycloak.admin.client.simplify.service.client;

import jakarta.validation.constraints.NotNull;
import org.keycloak.admin.client.resource.ClientResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.simplify.reprensetation.client.CreateClientOidcRepresentation;
import org.keycloak.admin.client.simplify.reprensetation.client.CreateClientSamlRepresentation;
import org.keycloak.representations.idm.ClientRepresentation;

import java.util.Optional;

public interface Client {

    public void createNewClient(RealmResource realmResource, ClientRepresentation clientRepresentation);
    public void createNewClientOIDC(RealmResource realmResource, CreateClientOidcRepresentation createClientOidcRepresentation);
    public void createNewClientSAML(RealmResource realmResource, CreateClientSamlRepresentation createClientSamlRepresentation);

    public ClientResource findClientByClientIdToClientResource(RealmResource realmResource,String clientId);
    public Optional<ClientResource> findClientByClientIdToOptionalClientResource(RealmResource realmResource,String clientId);
    public Optional<ClientRepresentation> findClientByClientIdToRepresentation(RealmResource realmResource,String clientId);

}
