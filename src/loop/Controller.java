package loop;

import customer.LoginStatus;

public interface Controller {

    int register(String name, String email, String password, String gender, String address,
                 int age);

    LoginStatus login(String email, String password);
}
