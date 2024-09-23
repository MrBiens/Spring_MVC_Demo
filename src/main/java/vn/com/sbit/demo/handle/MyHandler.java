package vn.com.sbit.demo.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionAll(Exception ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
        //        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
