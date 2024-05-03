package customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.stream.Collectors;

public class CustomerControllerImpl implements CustomerController {

    private final CustomerRepositoryInter cr;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public CustomerControllerImpl(CustomerRepositoryInter customerRepository) {
        this.cr = customerRepository;
    }

    @Override
    public int register(String name, String email, String password, String gender, String address,
                        int age) {
        if(cr.getCustomers() == null) {
            cr.addNewCustomer(new Customer(name, email, password, gender, address, age));
            cr.saveCustomers();
        }
        if (!cr.getCustomers().stream()
                .anyMatch(customer -> customer.getEmail().equals(email))) {
            cr.addNewCustomer(new Customer(name, email, password, gender, address, age));
            cr.saveCustomers();
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

    @Override
    public boolean isValidEmail(String email) {

        if (cr.getCustomers() == null) {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        if (!cr.getCustomers().stream()
                .anyMatch(customer -> customer.getEmail().equals(email))) {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }



@Override
public Gender isValidGender(String gender) {
    if (gender.equals("M")) {
        return Gender.MALE;
    } else if (gender.equals("F")) {
        return Gender.FEMALE;
    }
    return null;
}

@Override
public boolean modiPassword(String checkPassword, Customer tar) {
    return (tar.getPassword().equals(checkPassword));
}

@Override
public Customer newPasswordByCustomer(String newPassword, Customer tar) {
    tar.setPassword(newPassword);
    cr.saveCustomers();
    return tar;
}

@Override
public void newAddrByCustomer(String newAddress, Customer tar) {
    tar.setAddress(newAddress);
    cr.saveCustomers();
}

}
