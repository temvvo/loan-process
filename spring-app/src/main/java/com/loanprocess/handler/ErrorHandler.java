package com.loanprocess.handler;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.ServerResponse.status;


@Component
public class ErrorHandler {
    public ServerResponse handleError(Exception e, ServerRequest serverRequest) {
        return status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}