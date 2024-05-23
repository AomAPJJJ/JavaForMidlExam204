package sit.int221.servicetasksj3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //404
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
    @Override
    public  synchronized Throwable fillInStackTrace(){
        return this;
    }
}
