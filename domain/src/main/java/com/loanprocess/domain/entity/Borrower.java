package com.loanprocess.domain.entity;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Getter
public class Borrower {
    String name;
    BigDecimal annualIncome, annualDebt;
    Boolean delinquentDebt;
    Integer creditHistory;
}
