package com.loanprocess.config;


import com.loanprocess.usecase.LoanSubmission;
import com.loanprocess.usecase.port.LoanPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {


    @Bean
    public LoanPort loanPort() {
        return LoanSubmission.builder().build();
    }
}
