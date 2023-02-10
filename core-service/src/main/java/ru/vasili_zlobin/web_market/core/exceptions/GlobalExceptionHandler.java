package ru.vasili_zlobin.web_market.core.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.vasili_zlobin.web_market.api.exceptions.AppError;
import ru.vasili_zlobin.web_market.api.exceptions.ErrorFieldsValidate;
import ru.vasili_zlobin.web_market.api.exceptions.ResourceNotFoundException;
import ru.vasili_zlobin.web_market.api.exceptions.ValidateException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorFieldsValidate> catchProductFieldsValidate(ValidateException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(new ErrorFieldsValidate(e.getErrorMessages()), HttpStatus.BAD_REQUEST);
    }
}
