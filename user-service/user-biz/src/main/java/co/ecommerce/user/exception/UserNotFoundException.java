package co.ecommerce.user.exception;

import co.ecommerce.restapi.exception.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GlobalException {
    public UserNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
