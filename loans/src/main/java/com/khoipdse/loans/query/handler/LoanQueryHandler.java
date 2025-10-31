package com.khoipdse.loans.query.handler;

import com.khoipdse.loans.dto.LoansDto;
import com.khoipdse.loans.query.FindLoanQuery;
import com.khoipdse.loans.service.ILoansService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanQueryHandler {

    private final ILoansService iLoansService;

    @QueryHandler
    public LoansDto findLoan(FindLoanQuery query) {
        LoansDto loan = iLoansService.fetchLoan(query.getMobileNumber());
        return loan;
    }

}
