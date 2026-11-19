package co.ecommerce.exception;

import co.ecommerce.order.domain.exception.DomainException;

public class CustomerDomainException extends DomainException {

    public CustomerDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerDomainException(String message) {
        super(message);
    }
}
