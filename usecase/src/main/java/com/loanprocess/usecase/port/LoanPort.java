package com.loanprocess.usecase.port;

import com.loanprocess.domain.entity.Loan;
import com.loanprocess.domain.entity.LoanMetric;

import java.util.List;

public interface LoanPort {
    public List<LoanMetric> submit(Loan[] loans) ;
}
