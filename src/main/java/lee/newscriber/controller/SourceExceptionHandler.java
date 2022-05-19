package lee.newscriber.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
@Slf4j
public class SourceExceptionHandler {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Void> handleItemsNotFound(IOException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
