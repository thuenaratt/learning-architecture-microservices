package co.ecommerce.user.exception;

import co.ecommerce.restapi.exception.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserHybridDataInconsistencyException extends GlobalException {
    public UserHybridDataInconsistencyException(HttpStatus status, String message) {
        super(status, message);
    }
}
