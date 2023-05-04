package core.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class UrpResponse extends ResponseEntity {

	 public UrpResponse(Object dto, MultiValueMap headers, HttpStatus status) {         
	        super(dto, headers, status);
	    }
	    
	     public UrpResponse(HttpStatus status) {         
	        super(status);
	    }
}
