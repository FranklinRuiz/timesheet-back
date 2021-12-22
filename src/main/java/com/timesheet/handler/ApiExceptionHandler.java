/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timesheet.handler;


import com.timesheet.dto.ErrorDTO;
import com.timesheet.exception.BussinesRuleException;
import com.timesheet.exception.StandarizedApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.UnknownHostException;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author sotobotero
 * Standard http communication have five levels of response codes
 * 100-level (Informational) — Server acknowledges a request, it mean that request was received and understood, it is transient response , alert client for awaiting response
 * 200-level (Success) — Server completed the request as expected
 * 300-level (Redirection) — Client needs to perform further actions to complete the request
 * 400-level (Client error) — Client sent an invalid request
 * 500-level (Server error) — Server failed to fulfill a valid request due to an error with server
 * <p>
 * The goal of handler exception is provide to customer with appropriate code and
 * additional comprehensible information to help troubleshoot the problem.
 * The message portion of the body should be present as user interface, event if
 * customer send an Accept-Language header (en or french ie) we should translate the title part
 * to customer language if we support internationalization, detail is intended for developer
 * of clients, so the translation is not necessary. If more than one error is need to report , we can
 * response a list of errors.
 */
@RestControllerAdvice//Indicate that this class assit a controller class and can have a body in response
public class ApiExceptionHandler {

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleUnknownHostException(UnknownHostException ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error de conexion", "erorr-1024", ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }

    @ExceptionHandler(BussinesRuleException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBussinesRuleException(BussinesRuleException ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error de validacion", ex.getCode(), ex.getMessage());
        return new ResponseEntity(response, HttpStatus.PARTIAL_CONTENT);
    }

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ErrorDTO processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        ErrorDTO errorDTO = new ErrorDTO(BAD_REQUEST.value(), "@Valid Error");
        for (org.springframework.validation.FieldError fieldError : fieldErrors) {
            errorDTO.addFieldError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errorDTO;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handlenOcONTENTException(Exception ex) {
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error inesperado", "error-1024", ex.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
