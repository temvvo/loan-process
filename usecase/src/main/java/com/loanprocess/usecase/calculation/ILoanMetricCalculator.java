package com.loanprocess.usecase.calculation;

import com.loanprocess.domain.entity.Loan;
import com.loanprocess.domain.entity.LoanMetric;

import java.math.BigDecimal;
import java.math.MathContext;

public interface ILoanMetricCalculator extends IloanMetricType {
    boolean isSupported(Loan loan);

    LoanMetric getLoanMetric(Loan loan);

    default BigDecimal getMonthlyRate(BigDecimal annualRate) {
        return annualRate.divide(BigDecimal.valueOf(12), MathContext.DECIMAL32).divide(BigDecimal.valueOf(100));
    }

   default BigDecimal getMonthlyPayment(BigDecimal loanAmount,BigDecimal monthlyRate, Integer termMonths) {
        if(termMonths != null && termMonths !=0)
            return (loanAmount.multiply(monthlyRate))
                .divide(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(1).add(monthlyRate).
                        pow(termMonths *(-1),MathContext.DECIMAL32)),MathContext.DECIMAL32);
        return BigDecimal.ZERO;
    }

    default BigDecimal getNoDelinquentDebtWeight(boolean delinquentDebt) {
        if(delinquentDebt)
            return BigDecimal.valueOf(0.35);
        return BigDecimal.ZERO;
    }

    default BigDecimal getDebtToIncomeRatioWeight(BigDecimal annualDebt, BigDecimal annualIncome, BigDecimal ratio , BigDecimal weight){
        if(annualDebt != null && annualIncome != null && annualDebt.divide(annualIncome,MathContext.DECIMAL32).compareTo(ratio) < 0)
            return weight;
        return BigDecimal.ZERO;
    }

    default BigDecimal getCeditHistoryWeight(Integer creditHistory){
        if(creditHistory!= null && creditHistory >= 5)
            return BigDecimal.valueOf(0.25);
        return BigDecimal.ZERO;
    }
}
