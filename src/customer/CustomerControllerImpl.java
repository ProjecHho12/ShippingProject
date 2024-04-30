package customer;

import loop.Controller;
import loop.CustomerRepositoryInter;
import loop.Repository;

import java.util.stream.Collectors;

public class CustomerControllerImpl implements Controller {

    private final CustomerRepositoryInter cr;

    public CustomerControllerImpl(CustomerRepositoryInter customerRepository) {
        this.cr = customerRepository;
    }

    @Override
    public int register(String name, String email, String password, String gender, String address,
                        int age) {
        if (!cr.getCustomers().stream()
                .anyMatch(customer -> customer.getEmail().equals(email))) {
            cr.addNewCustomer(new Customer(name, email, password, gender, address, age));
            cr.saveCustomers();
            cr.loadCustomers();
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
                return cr.getCustomers().stream()
                        .filter(customer -> customer.getEmail().equals(email))
                        .collect(Collectors.toList()).get(0);
            } else {
                return null;
            }
        }
        return null;
    }
}
