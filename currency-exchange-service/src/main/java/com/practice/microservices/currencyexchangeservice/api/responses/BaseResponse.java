package com.practice.microservices.currencyexchangeservice.api.responses;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class BaseResponse {

    private boolean success = true;

}
