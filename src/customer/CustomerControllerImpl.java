package customer;

import loop.Controller;
import loop.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
    public Customer login(String email, String password) {
        if (cr.checkId(email)) {
            if (password.equals("0"))
                return null;
            if (cr.checkPassword(email, password)) {
                return ccr.getCustomers().stream()
                        .filter(customer -> customer.getEmail().equals(email))
                        .collect(Collectors.toList()).get(0);
            } else {
                return null;
            }
        }
        return null;
    }
}
