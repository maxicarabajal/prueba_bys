package com.prueba.bys.infrastructure.exceptions.dto;

import org.springframework.http.HttpStatus;

public record ErrorMessageDTO ( HttpStatus status,String message){
}
