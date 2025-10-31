package com.khoipdse.customer.query.handler;

import com.khoipdse.customer.dto.CustomerDto;
import com.khoipdse.customer.query.FindCustomerQuery;
import com.khoipdse.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerQueryHandler {

    private final ICustomerService iCustomerService;

    @QueryHandler
    public CustomerDto findCustomer(FindCustomerQuery findCustomerQuery) {
        return iCustomerService.fetchCustomer(findCustomerQuery.getMobileNumber());
    }

}
