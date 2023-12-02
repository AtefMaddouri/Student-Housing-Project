package tn.esprit.studenthousing.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,String> HandelException(IllegalArgumentException illegalArgumentException)
    {
        Map map = new HashMap<>();
        map.put("error",illegalArgumentException.getMessage());
        return map;
    }

}




