package com.loanprocess.domain.entity;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor

@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
@Setter
public class Loan {
    Integer loanId;
    BigDecimal requestedAmount;
    Integer termMonths;
    BigDecimal annualInterest;
    String type;
    Borrower borrower;
}
