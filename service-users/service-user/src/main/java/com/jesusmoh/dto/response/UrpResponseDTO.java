package com.jesusmoh.dto.response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class UrpResponseDTO extends ResponseEntity{
    
    public UrpResponseDTO(Object dto, MultiValueMap headers, HttpStatus status) {         
        super(dto, headers, status);
    }
    
     public UrpResponseDTO(HttpStatus status) {         
        super(status);
    }
    
     
}
