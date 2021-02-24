package com.loanprocess.usecase.calculation;

import com.loanprocess.domain.entity.Loan;
import com.loanprocess.domain.entity.LoanMetric;
import com.loanprocess.usecase.service.LoanMetricType;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Builder(toBuilder = true)
@Component
public class ConsumerLoanMetricCalculator implements ILoanMetricCalculator{
    private static BigDecimal DEBT_TO_INCOME_RATIO = BigDecimal.valueOf(.43);
    private static BigDecimal DEBT_TO_INCOME_WEIGHT = BigDecimal.valueOf(.3);
    private static BigDecimal CONSUMER_DEBT = BigDecimal.valueOf(.1);

    @Override
    public boolean isSupported(Loan loan) {
        return false;
    }


    @Override
    public LoanMetric getLoanMetric(Loan loan) {
        BigDecimal montlyRate = getMonthlyRate(loan.getAnnualInterest());

        return LoanMetric.builder().loanId(loan.getLoanId())
                .monthlyInterestRate(getMonthlyRate(loan.getAnnualInterest()).doubleValue())
                .monthlyPayment(getMonthlyPayment(loan.getRequestedAmount(),montlyRate,loan.getTermMonths()).doubleValue())
                .riskFactor(this.getRiskFactor(loan)).build();
    }

    @Override
    public LoanMetricType getLoanMetricType() {
        return LoanMetricType.consumer;
    }



    private double getRiskFactor(Loan loan) {
        return BigDecimal.valueOf(1)
                .subtract(getNoDelinquentDebtWeight(loan.getBorrower().getDelinquentDebt())
                .add(getDebtToIncomeRatioWeight(loan.getBorrower().getAnnualDebt(), loan.getBorrower().getAnnualIncome()
                        ,DEBT_TO_INCOME_RATIO,DEBT_TO_INCOME_WEIGHT ))
                .add(getCeditHistoryWeight(loan.getBorrower().getCreditHistory()))
                .add(CONSUMER_DEBT)).doubleValue();
    }
}
