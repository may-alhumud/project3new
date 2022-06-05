package com.example.bookmanagement.Advice;

import com.example.bookmanagement.DTO.API;
import com.example.bookmanagement.exception.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class ControllerAdviseHandler {
    Logger logger= LoggerFactory.getLogger(ControllerAdviseHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<API> handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
        String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
        logger.info(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }



    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        logger.info(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message,400));
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleException(Exception exception){
       // System.out.println(exception.getMessage());
        StringWriter stringWriter=new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        logger.error(stringWriter.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new API("SERVER ERROR pleas try again later !",500));
    }
}
