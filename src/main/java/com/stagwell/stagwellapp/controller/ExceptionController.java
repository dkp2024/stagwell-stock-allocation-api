/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  jakarta.servlet.ServletException
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.HttpStatusCode
 *  org.springframework.http.ResponseEntity
 *  org.springframework.web.bind.annotation.ControllerAdvice
 *  org.springframework.web.bind.annotation.ExceptionHandler
 */
package com.stagwell.stagwellapp.controller;

import jakarta.servlet.ServletException;
import java.util.LinkedHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(value={"com.stagwell.stagwellapp"})
public class ExceptionController {
    private static final Logger log = LogManager.getLogger(ExceptionController.class);

    @ExceptionHandler(value={Exception.class, ServletException.class, RuntimeException.class})
    public ResponseEntity<Object> exception(Exception exception) {
        LinkedHashMap<String, String> body = new LinkedHashMap<String, String>();
        body.put("message", exception.getMessage());
        log.error("exception in api call: ", (Throwable)exception);
        return new ResponseEntity(body, (HttpStatusCode)HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
