package customer;

import loop.Controller;
import loop.CustomerRepositoryInter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.stream.Collectors;

public class CustomerControllerImpl implements Controller {

    private final CustomerRepositoryInter cr;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

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

    @Override
    public boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String isValidGender(String gender){
        if (gender.equals("M")) {
            gender = String.valueOf(Gender.MALE);
            return gender;
        } else if(gender.equals("F")) {
            gender = String.valueOf(Gender.FEMALE);
            return gender;
        }
        return null;
    }

}
