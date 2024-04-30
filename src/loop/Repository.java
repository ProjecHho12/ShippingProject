package loop;

import customer.Customer;

/**
 * packageName    : loop fileName       : CustomerRepository author         : hoho date           :
 * 4/26/24 description    :
 */
public interface Repository {

    boolean checkId(String email);

    boolean checkPassword(String email, String password);

}
