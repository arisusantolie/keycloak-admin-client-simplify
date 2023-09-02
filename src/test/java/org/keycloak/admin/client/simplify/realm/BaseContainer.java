package org.keycloak.admin.client.simplify.realm;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.simplify.KeycloakAdminSimplifyInitializer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseContainer {

    static final String ADMIN_USER = "admin";


    static final String ADMIN_PW = "admin";


    protected KeycloakAdminSimplifyInitializer keycloakAdminSimplifyInitializer;


    @Container
    public static GenericContainer<?> keycloakContainer = new GenericContainer<>(System.getProperty("docker.image.keycloak"))
            .withExposedPorts(8080) // Expose Keycloak's HTTP port
            .withEnv("KEYCLOAK_ADMIN", ADMIN_USER)
            .withEnv("KEYCLOAK_ADMIN_PASSWORD", ADMIN_PW)
            .withCommand("start-dev")
            .waitingFor(Wait.forHttp("/").forPort(8080).forStatusCode(200));

    @BeforeEach
    public void setUp() {

        String host="http://" + keycloakContainer.getHost() + ":" + keycloakContainer.getMappedPort(8080);

        Keycloak keycloak= KeycloakBuilder.builder().serverUrl(host + "/").realm("master").username(ADMIN_USER).password(ADMIN_PW)
                .clientId("admin-cli")
                .resteasyClient(((ResteasyClientBuilder) ResteasyClientBuilder.newBuilder()).connectionPoolSize(20).build()).build();

        keycloakAdminSimplifyInitializer=new KeycloakAdminSimplifyInitializer(keycloak);
    }
}
