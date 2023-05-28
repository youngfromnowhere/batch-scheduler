package com.cmjc.batchscheduler.common.exceptions;

import com.cmjc.batchscheduler.common.exceptions.dto.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;
import java.util.Objects;

// lombok
@Slf4j

// springframework web bind
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * 발생한 IllegalArgumentException을 처리하기 위한 메서드
     *
     * @param e 처리 대상 예외
     * @return ExceptionResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ExceptionResponse handleIllegalArgumentException(IllegalArgumentException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ExceptionResponse(status.value(), status.name(), 400, e.getMessage());
    }


    /**
     * 발생한 NoSuchElementException을 처리하기 위한 메서드
     *
     * @param e 처리 대상 예외
     * @return ExceptionResponse
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public ExceptionResponse handleNoSuchElementException(NoSuchElementException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ExceptionResponse(status.value(), status.name(), 404, e.getMessage());
    }

    /**
     * 발생한 CustomException을 처리하기 위한 메서드
     *
     * @param e 처리 대상 예외
     * @return ExceptionResponse
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomException(CustomException e) {
        log.error("[CustomException] ", e.getMessage());
        return ExceptionResponse.toResponseEntity(e.getErrorCode());
    }


}
