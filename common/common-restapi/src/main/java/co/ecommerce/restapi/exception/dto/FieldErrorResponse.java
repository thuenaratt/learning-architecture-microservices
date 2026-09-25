package co.ecommerce.restapi.exception.dto;

public record FieldErrorResponse(
        String field,
        String code,
        String reason
){

}
