package com.felipesntos.fabcrud.fabsoftcrud.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message){
        super(message);
    }
}
