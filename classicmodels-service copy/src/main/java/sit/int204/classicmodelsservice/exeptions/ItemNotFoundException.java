package sit.int204.classicmodelsservice.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ItemNotFoundException extends RuntimeException{
    public  ItemNotFoundException(String message){
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace(){
        return  this;
    }

}
