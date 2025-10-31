package com.khoipdse.customer.service;

import com.khoipdse.customer.command.event.CustomerUpdatedEvent;
import com.khoipdse.customer.dto.CustomerDto;
import com.khoipdse.customer.entity.Customer;

public interface ICustomerService {

    /**
     * @param customerEntity - Customer Object
     */
    void createCustomer(Customer customerEntity);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchCustomer(String mobileNumber);

    /**
     * @param customerUpdatedEvent - CustomerUpdatedEvent Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateCustomer(CustomerUpdatedEvent customerUpdatedEvent);

    /**
     * @param customerId - Input Customer ID
     * @return boolean indicating if the delete of Customer details is successful or not
     */
    boolean deleteCustomer(String customerId);
}
