package com.loanprocess.handler.dto;

import com.loanprocess.domain.entity.Borrower;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class LoanSubmited {
    Integer loanId;
    BigDecimal requestedAmount;
    Integer termMonths;
    Integer termYears;
    BigDecimal annualInterest;
    String type;
    Borrower borrower;
}
