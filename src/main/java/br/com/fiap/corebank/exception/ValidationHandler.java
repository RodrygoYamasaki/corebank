package br.com.fiap.corebank.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationHandler {

    record ValidationError(String field, String message) {
        public ValidationError(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
        public List<ValidationError> handler(MethodArgumentNotValidException ex) {
        return ex.getFieldErrors()
                .stream()
                .map(ValidationError::new)
                .toList();
    }
}