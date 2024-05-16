package com.hoho.shipping.customer;

import java.util.List;

/**
 * packageName    : main.loop fileName       : CustomerRepository author         : hoho date           :
 * 4/26/24 description    :
 */

public interface CustomerRepositoryInter {

    boolean checkId(String email);

    boolean checkPassword(String email, String password);

    void addNewCustomer(Customer customer);

    List<Customer> getCustomers();

    void saveCustomers();

    List<Customer> loadCustomers();

}
