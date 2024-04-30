package loop;

import customer.LoginStatus;

public class CustomerController implements Controller {
    private Repository customerRepository;
    public CustomerController(Repository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public int register(String name, String email, String password, String gender, String address, int age) {
        return 0;
    }

    @Override
    public LoginStatus login(String email, String password) {
        return LoginStatus.PASSSFAIL;
    }
}
