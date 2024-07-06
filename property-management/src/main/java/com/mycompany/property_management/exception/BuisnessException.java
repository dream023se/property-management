package com.mycompany.property_management.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class BuisnessException extends RuntimeException{

    private List<ErrorModal> errors;
    public BuisnessException(List<ErrorModal> errors){
        this.errors=errors;
    }

}
