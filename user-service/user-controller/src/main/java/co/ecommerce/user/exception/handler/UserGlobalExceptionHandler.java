package co.ecommerce.user.exception.handler;

import co.ecommerce.restapi.exception.dto.RestApiErrorResponse;
import co.ecommerce.restapi.exception.exception.GlobalException;
import co.ecommerce.restapi.exception.exception.GlobalExceptionHandler;
import co.ecommerce.user.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(KeycloakException.class)
    public ResponseEntity<RestApiErrorResponse<?>> handle(
            KeycloakException e
    ) {
        return build(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<RestApiErrorResponse<?>> handle(
            PasswordMismatchException e
    ) {
        return build(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UsernameConflictException.class)
    public ResponseEntity<RestApiErrorResponse<?>> handle(
            UsernameConflictException e
    ) {
        return build(e);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestApiErrorResponse<?>> handle(
            UserNotFoundException e
    ) {
        return build(e);
    }


    @ExceptionHandler(UserHybridDataInconsistencyException.class)
    public ResponseEntity<RestApiErrorResponse<?>> handle(
            UserHybridDataInconsistencyException e
    ) {
        return build(e);
    }


    private ResponseEntity<RestApiErrorResponse<?>> build(GlobalException e) {
        RestApiErrorResponse<?> body = RestApiErrorResponse.builder()
                .code(e.getStatus().getReasonPhrase())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(e.getStatus()).body(body);
    }

}
