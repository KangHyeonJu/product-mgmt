package com.backend.product_mgmt.application;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {
    public <T> void  checkValid(@Valid T validationTarget){

    }
}
