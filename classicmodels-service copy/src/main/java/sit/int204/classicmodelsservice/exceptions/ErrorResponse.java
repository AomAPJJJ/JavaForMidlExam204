package sit.int204.classicmodelsservice.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //cแปลงเป็น json ให้เอาฟิลด์ที่ไม่เป็น null

public class ErrorResponse {
    private final int status; //constructor
    private final String message; //constructor
    private final String instance; //constructor
    private String stackTrace;
    private List<ValidationError> errors;

    @Getter
    @Setter
    @Data
    @RequiredArgsConstructor // มี constructor(final) เปลี่ยนไม่ได้ ต้อง req
    // final ==> required //
    private static class ValidationError { //inner class
        private final String field;
        private final String message;
    }
    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}
