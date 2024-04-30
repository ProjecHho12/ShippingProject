package customer;

import loop.Controller;
import loop.Repository;

public class CustomerControllerImpl implements Controller {

    private final Repository cr;
    CustomerRepository ccr = new CustomerRepository();

    public CustomerControllerImpl(Repository customerRepository) {
        this.cr = customerRepository;
    }

    @Override
    public int register(String name, String email, String password, String gender, String address,
                        int age) {
        if (!ccr.getCustomers().stream()
                .anyMatch(customer -> customer.getEmail().equals(email))) {
            ccr.addNewCustomer(new Customer(name, email, password, gender, address, age));
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public LoginStatus login(String email, String password) {
        if (cr.checkId(email)) {
            if (password.equals("0"))
                return LoginStatus.PASSSFAIL;
            if (cr.checkPassword(email, password)) {
                return LoginStatus.SUCCESS;
            } else {
                return LoginStatus.PASSSFAIL;
            }
        }
        return LoginStatus.IDFAIL;
    }
}
