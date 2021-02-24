package com.loanprocess.routes;

import com.loanprocess.handler.ErrorHandler;
import com.loanprocess.handler.LoanSubmissionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.accept;

@Configuration
public class LoanSubmissionRoute {
        @Bean
        public RouterFunction<ServerResponse> route(LoanSubmissionHandler handler, ErrorHandler errorHandler) {
            return RouterFunctions.route()
                    .POST("/submit",accept(MediaType.APPLICATION_JSON),req -> ServerResponse.ok().body(handler.submit(req)))
                    .build();
        }
}
