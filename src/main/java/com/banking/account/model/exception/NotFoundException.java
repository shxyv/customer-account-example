package com.banking.account.model.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String code;

    public NotFoundException(final String code, String message) {
        super(message);
        this.code = code;
    }

}
