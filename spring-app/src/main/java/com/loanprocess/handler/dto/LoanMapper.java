package com.loanprocess.handler.dto;

import com.loanprocess.domain.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LoanMapper {
    @Mapping( target = "termMonths", expression = "java(loanSubmited.getTermYears() != null? loanSubmited.getTermYears()*12:loanSubmited.getTermMonths())")
    Loan from(LoanSubmited loanSubmited);

    Loan[] entityToLoans(LoanSubmited[] loanSubmitedList);
}
