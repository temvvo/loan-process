package com.loanprocess.usecase.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LoanMetricFactoryTest {

    static final String CONSUMER_TYPE = "fail";

    @Autowired
    LoanMetricFactory loanMetricFactory;


    @Test
    void getServiceException() {
        Assertions.assertThrows(RuntimeException.class, () -> LoanMetricFactory.getService(CONSUMER_TYPE));
    }
}