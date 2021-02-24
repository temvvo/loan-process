package com.loanprocess.usecase;

import com.loanprocess.domain.entity.Loan;
import com.loanprocess.domain.entity.LoanMetric;
import com.loanprocess.usecase.port.LoanPort;
import com.loanprocess.usecase.service.LoanMetricFactory;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class LoanSubmission implements LoanPort {
    /**
     * Loan submission creation Use Case
     * <p>
     * - Do calculations
     *
     * @param loans
     * @return LoanMetrics
     */
    public List<LoanMetric> submit(Loan[] loans) {
        List<LoanMetric> metrics = new ArrayList<LoanMetric>();
        Arrays.stream(loans).forEach(loan -> metrics.add(LoanMetricFactory.getService(loan.getType()).getLoanMetric(loan)));
        return metrics;
    }
}
