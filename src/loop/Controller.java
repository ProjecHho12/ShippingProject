package loop;

import customer.Customer;

import java.util.List;

public interface Controller {

    int register(String name, String email, String password, String gender, String address,
                 int age);

    Customer login(String email, String password);
}
