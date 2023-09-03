package org.keycloak.admin.client.simplify.service.client;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.simplify.reprensetation.client.CreateClientOidcRepresentation;
import org.keycloak.admin.client.simplify.reprensetation.client.CreateClientSamlRepresentation;
import org.keycloak.representations.idm.ClientRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

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

    @Override
    public void createNewClientOIDC(@NotNull RealmResource realmResource,@NotNull CreateClientOidcRepresentation createClientOidcRepresentation) {
        ClientRepresentation clientRepresentation=new ClientRepresentation();
        clientRepresentation.setClientId(createClientOidcRepresentation.getClientId());
        clientRepresentation.setRootUrl(createClientOidcRepresentation.getRootUrl());
        clientRepresentation.setProtocol("openid-connect");
        realmResource.clients().create(clientRepresentation);
    }

    @Override
    public void createNewClientSAML(@NotNull RealmResource realmResource,@NotNull CreateClientSamlRepresentation createClientSamlRepresentation) {
        ClientRepresentation clientRepresentation=new ClientRepresentation();
        clientRepresentation.setClientId(createClientSamlRepresentation.getClientId());
        clientRepresentation.setAdminUrl(createClientSamlRepresentation.getClientSamlEndpoint());
        clientRepresentation.setProtocol("saml");
        realmResource.clients().create(clientRepresentation);
    }

    @Override
    public ClientResource findClientByClientIdToClientResource(@NotNull RealmResource realmResource,@NotNull String clientId) {
        return realmResource.clients().get(clientId);
    }

    @Override
    public Optional<ClientResource> findClientByClientIdToOptionalClientResource(@NotNull RealmResource realmResource,@NotNull String clientId) {
        Optional<ClientRepresentation> clientRepresentation=findClientByClientIdToRepresentation(realmResource,clientId);
        if(clientRepresentation.isPresent()){
            return Optional.of(findClientByClientIdToClientResource(realmResource,clientId));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<ClientRepresentation> findClientByClientIdToRepresentation(@NotNull RealmResource realmResource,@NotNull String clientId) {
        ClientResource clientResource=findClientByClientIdToClientResource(realmResource,clientId);

        try{
            return Optional.ofNullable(clientResource.toRepresentation());
        }catch (NotFoundException ex){
            return Optional.empty();
        }catch (Exception e){
            throw e;
        }
    }
}
