package loop;

import customer.Customer;

public interface Controller {

    int register(String name, String email, String password, String gender, String address,
                 int age);

    Customer login(String email, String password);

    boolean isValidEmail(String email);

    String isValidGender(String gender);
}
