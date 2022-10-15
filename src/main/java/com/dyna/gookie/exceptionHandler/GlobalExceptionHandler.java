//package com.dyna.gookie.exceptionHandler;
//
//import com.dyna.gookie.utils.ErrorCode;
//import com.dyna.gookie.utils.Response;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(CustomException.class)
//    public ResponseEntity<Response> handleCustomException(CustomException ex){
//        Response response = new Response(ex.getErrorCode());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Response> handelException(Exception ex){
//        Response response = new Response(ErrorCode.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
