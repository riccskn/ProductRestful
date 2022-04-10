package com.pdproject.product.exception;

import com.pdproject.product.commons.exception.BaseRuntimeException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseRuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource with ID: "+id+" not found",HttpStatus.NOT_FOUND);
    }
}
