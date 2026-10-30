package co.ecommerce.user.service;

import org.keycloak.representations.idm.UserRepresentation;
import java.util.List;

public interface KeycloakUserService {
    void createKeycloakUser(UserRepresentation userRepresentation);

    UserRepresentation getKeycloakUserByUsername(String username);

    void updateKeycloakUser(String id, UserRepresentation userRepresentation);
    UserRepresentation getKeycloakUserById(String id);

    List<UserRepresentation> getKeycloakUsersByRoleName(String roleName);

    void deleteKeycloakUser(String id);



}
