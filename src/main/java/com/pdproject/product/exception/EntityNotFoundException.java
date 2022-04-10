package com.pdproject.product.exception;

import com.pdproject.product.commons.exception.BaseRuntimeException;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BaseRuntimeException {

    public EntityNotFoundException(long id) {
        super("Entity with ID: "+id+" not found",HttpStatus.NOT_FOUND);
    }

}
