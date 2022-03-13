package com.banking.account.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionDto {

    private final String code;
    private final String message;
}
