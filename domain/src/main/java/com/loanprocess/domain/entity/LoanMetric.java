package com.loanprocess.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class LoanMetric {
    int loanId;
    double monthlyInterestRate;
    double monthlyPayment;
    double riskFactor;
}
