package customer;

import customer.Customer;

import java.util.List;

/**
 * packageName    : loop fileName       : CustomerRepository author         : hoho date           :
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
