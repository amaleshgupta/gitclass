package Restaurant_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class resourcenotfounfexception extends RuntimeException {
	
	    public resourcenotfounfexception(String message) {
	        super(message);
	    }
	}


