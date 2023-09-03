package org.keycloak.admin.client.simplify.reprensetation.client;

import jakarta.validation.constraints.NotNull;

public class CreateClientOidcRepresentation {

    @NotNull
    private String clientId;
    private String rootUrl; //optional

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }
}
