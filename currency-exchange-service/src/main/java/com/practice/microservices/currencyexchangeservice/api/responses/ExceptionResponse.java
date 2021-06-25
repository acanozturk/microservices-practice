package com.practice.microservices.currencyexchangeservice.api.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExceptionResponse extends BaseResponse {

    private String errorMessage;
}
