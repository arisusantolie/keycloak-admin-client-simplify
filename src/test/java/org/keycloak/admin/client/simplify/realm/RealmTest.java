package org.keycloak.admin.client.simplify.realm;
import org.keycloak.admin.client.simplify.enums.realm.SslRequiredEnum;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.simplify.reprensetation.realm.RealmLoginSettingRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;

@Testcontainers()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RealmTest extends BaseContainer {

    private static final String REALM = "realm-testing";

    @Test
    @Order(1)
    public void testCreateNewRealm() {

        //create realm first
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setDisplayName(REALM);
        realmRepresentation.setRealm(REALM);
        keycloakAdminSimplifyInitializer.getRealm().createNewRealm(realmRepresentation);

        //checking realm
        assertEquals(REALM, keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToOptionalResource(REALM).get().toRepresentation().getRealm());

    }

    @Test
    @Order(2)
    public void testFindRealmByNameToResource(){
        assertEquals(REALM, keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToResource(REALM).toRepresentation().getRealm());
    }

    @Test
    @Order(3)
    public void testFindRealmByNameToOptionalResource(){
        Optional<RealmResource> realmResource=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToOptionalResource(REALM);
        assertTrue(realmResource.isPresent());
        assertEquals(REALM,realmResource.get().toRepresentation().getRealm());
    }

    @Test
    @Order(4)
    public void testFindRealmByNameToRepresentation(){
        Optional<RealmRepresentation> realmRepresentation=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToRepresentation(REALM);
        assertTrue(realmRepresentation.isPresent());
        assertEquals(REALM,realmRepresentation.get().getRealm());
    }

    @Test
    @Order(5)
    public void testFindAll(){
        List<RealmRepresentation> realmRepresentations=keycloakAdminSimplifyInitializer.getRealm().findAll();
        assertTrue(!realmRepresentations.isEmpty());

        //expected total realm is 2 before in the first place we create a new Realm, so the realm must be a master & realm we created.
        assertEquals(2,realmRepresentations.size());
    }

    @Test
    @Order(6)
    public void testUpdateRealm(){
        Optional<RealmRepresentation> realmRepresentation=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToRepresentation(REALM);
        assertTrue(!realmRepresentation.isEmpty());
        realmRepresentation.get().setDisplayName(REALM.concat("-display-name"));
        keycloakAdminSimplifyInitializer.getRealm().updateRealm(realmRepresentation.get());
        Optional<RealmRepresentation> realmRepresentationAfterUpdate=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToRepresentation(REALM);
        assertTrue(!realmRepresentationAfterUpdate.isEmpty());
        assertEquals(REALM.concat("-display-name"),realmRepresentationAfterUpdate.get().getDisplayName());

        //set to default again
        realmRepresentationAfterUpdate.get().setDisplayName(REALM);
        keycloakAdminSimplifyInitializer.getRealm().updateRealm(realmRepresentationAfterUpdate.get());
    }

    @Test
    @Order(7)
    public void testRemoveRealmByName(){
        //first lets create a dummy realm for testing
        RealmRepresentation realmRepresentationDummy=new RealmRepresentation();
        realmRepresentationDummy.setRealm(REALM+"-dummy");
        realmRepresentationDummy.setDisplayName(REALM+"-dummy");
        keycloakAdminSimplifyInitializer.getRealm().createNewRealm(realmRepresentationDummy);

        Optional<RealmRepresentation> realmRepresentation=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToRepresentation(REALM+"-dummy");
        //check if we create a realm successfully
        assertTrue(realmRepresentation.isPresent());

        //lets remove the realm by realm name
        keycloakAdminSimplifyInitializer.getRealm().removeRealm(realmRepresentation.get().getRealm());

        Optional<RealmRepresentation> realmRepresentationAfterRemove=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToRepresentation(REALM+"-dummy");
        assertTrue(realmRepresentationAfterRemove.isEmpty());
    }

    @Test
    @Order(8)
    public void testRemoveRealmByRealmResource(){
        //first lets create a dummy realm for testing
        RealmRepresentation realmRepresentationDummy=new RealmRepresentation();
        realmRepresentationDummy.setRealm(REALM+"-dummy");
        realmRepresentationDummy.setDisplayName(REALM+"-dummy");
        keycloakAdminSimplifyInitializer.getRealm().createNewRealm(realmRepresentationDummy);

        Optional<RealmResource> realmResource=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToOptionalResource(REALM+"-dummy");
        //check if we create a realm successfully
        assertTrue(realmResource.isPresent());

        //lets remove the realm by realm name
        keycloakAdminSimplifyInitializer.getRealm().removeRealm(realmResource.get());

        Optional<RealmResource> realmResourceAfterRemove=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToOptionalResource(REALM+"-dummy");
        assertTrue(realmResourceAfterRemove.isEmpty());
    }

    @Test
    @Order(9)
    public void testSetRealmLoginSetting(){
        RealmLoginSettingRepresentation realmLoginSettingRepresentation=new RealmLoginSettingRepresentation();
        realmLoginSettingRepresentation.setRegistrationAllowed(true);
        realmLoginSettingRepresentation.setEditUsernameAllowed(true);
        realmLoginSettingRepresentation.setResetPasswordAllowed(true);
        realmLoginSettingRepresentation.setRememberMe(true);
        realmLoginSettingRepresentation.setVerifyEmail(true);
        realmLoginSettingRepresentation.setLoginWithEmailAllowed(true);
        realmLoginSettingRepresentation.setSslRequired(SslRequiredEnum.external);

        Optional<RealmResource> realmResource=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToOptionalResource(REALM);
        assertTrue(realmResource.isPresent());
        keycloakAdminSimplifyInitializer.getRealm().setRealmLoginSetting(realmResource.get(),realmLoginSettingRepresentation);

        Optional<RealmRepresentation> realmRepresentationAfterUpdateLoginSetting=keycloakAdminSimplifyInitializer.getRealm().findRealmByNameToRepresentation(REALM);
        assertTrue(realmRepresentationAfterUpdateLoginSetting.isPresent());

        assertTrue(realmRepresentationAfterUpdateLoginSetting.get().isRegistrationAllowed());
        assertTrue(realmRepresentationAfterUpdateLoginSetting.get().isEditUsernameAllowed());
        assertTrue(realmRepresentationAfterUpdateLoginSetting.get().isResetPasswordAllowed());
        assertTrue(realmRepresentationAfterUpdateLoginSetting.get().isRememberMe());
        assertTrue(realmRepresentationAfterUpdateLoginSetting.get().isVerifyEmail());
        assertTrue(realmRepresentationAfterUpdateLoginSetting.get().isLoginWithEmailAllowed());
        assertEquals(SslRequiredEnum.external.toString(), realmRepresentationAfterUpdateLoginSetting.get().getSslRequired());

    }

}
