package com.banking.account.controller.handler;

import com.banking.account.model.dto.ExceptionDto;
import com.banking.account.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.banking.account.model.constant.ExceptionConstants.*;
import static com.banking.account.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionDto handle(Exception exception) {
        log.error("Exception: " + exception);
        return ExceptionDto.builder()
                .code(UNEXPECTED_EXCEPTION_CODE)
                .message(UNEXPECTED_EXCEPTION_MESSAGE)
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ExceptionDto handle(NotFoundException exception) {
        log.error("NotFoundException: " + exception);
        return ExceptionDto.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .build();
    }
}
