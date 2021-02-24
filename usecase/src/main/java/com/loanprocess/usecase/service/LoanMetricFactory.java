package com.loanprocess.usecase.service;

import com.loanprocess.usecase.calculation.ILoanMetricCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanMetricFactory {
    private static final Map<LoanMetricType, ILoanMetricCalculator> myServiceCache = new HashMap<>();



    @Autowired
    private LoanMetricFactory(List<ILoanMetricCalculator> services) {

        for(ILoanMetricCalculator service : services) {
            myServiceCache.put(service.getLoanMetricType(),service);
        }
    }

    public static ILoanMetricCalculator getService(String type) {
        ILoanMetricCalculator service = myServiceCache.get(LoanMetricType.valueOf(type));
        if(service == null) throw new RuntimeException("Unknown service type: " + type);
        return service;
    }

}
