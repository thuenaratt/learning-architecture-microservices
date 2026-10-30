package co.ecommerce.user.exception;

import co.ecommerce.restapi.exception.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class KeycloakException extends GlobalException {
    public KeycloakException(HttpStatus status, String message) {
        super(status, message);
    }
}
