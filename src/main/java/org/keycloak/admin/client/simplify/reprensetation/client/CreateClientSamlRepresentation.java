package org.keycloak.admin.client.simplify.reprensetation.client;

import jakarta.validation.constraints.NotNull;

public class CreateClientSamlRepresentation {
    @NotNull
    private String clientId;
    private String clientSamlEndpoint; //optional

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSamlEndpoint() {
        return clientSamlEndpoint;
    }

    public void setClientSamlEndpoint(String clientSamlEndpoint) {
        this.clientSamlEndpoint = clientSamlEndpoint;
    }
}
