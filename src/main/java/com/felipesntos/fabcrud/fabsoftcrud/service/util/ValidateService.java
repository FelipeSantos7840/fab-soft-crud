package com.felipesntos.fabcrud.fabsoftcrud.service.util;

import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class ValidateService {

    public static <T> T validateOptional(Optional<T> opt){
        if(opt.isPresent()){
            return opt.get();
        }
        throw new InvalidParameterException("Entity not found exception!");
    }
}
