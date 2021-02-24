package com.loanprocess.handler;

import com.loanprocess.domain.entity.LoanMetric;
import com.loanprocess.handler.dto.LoanMapper;
import com.loanprocess.handler.dto.LoanSubmited;
import com.loanprocess.usecase.port.LoanPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class LoanSubmissionHandler {

    @Autowired
    private final LoanPort loanPort;
    private final LoanMapper loanMapper;

    public List<LoanMetric> submit(ServerRequest serverRequest) throws ServletException, IOException {
        final LoanSubmited[] loansSubmited = serverRequest.body(LoanSubmited[].class);
        return loanPort.submit(loanMapper.entityToLoans(loansSubmited));
    }
}
