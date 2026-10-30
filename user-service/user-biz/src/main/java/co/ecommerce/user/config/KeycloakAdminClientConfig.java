package co.ecommerce.user.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminClientConfig {
    public final static String REALM_NAME = "ecommerce";
    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8888")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("ecommerce-admin-client")
                .clientSecret("sNB5h6MuAbTaHpENpkMg7sOlkd9PfRkFoRud5LGjAJUZ8JqPWKEx83AEsFBiFBQyYxCCLiLmrXU8yOUjuYfUmx")
                .realm("ecommerce")
                .build();
    }

}
