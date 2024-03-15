package com.bank.sbi.exception;

import jakarta.persistence.RollbackException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.InsufficientResourcesException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class SbiExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ProblemDetail handleNoSuchElementException(NoSuchElementException e) {
        return ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(500), e.getMessage());
    }

    @ExceptionHandler(InsufficientResourcesException.class)
    public ProblemDetail handleInsufficientResourcesException(InsufficientResourcesException e) {
        return ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(500), e.getMessage());
    }

    @ExceptionHandler(RollbackException.class)
    public ProblemDetail handleRollbackException(RollbackException e) {
        return ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(400), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handel(RuntimeException e) {
        ProblemDetail problemDetails = ProblemDetail.forStatus(HttpStatusCode.valueOf(400));
        problemDetails.setTitle("NOT__FOUND");
        problemDetails.setDetail(e.getMessage());
        return problemDetails;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handel(Exception e) {
        return ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(400), e.getMessage());
    }
}
