package loop;

public class CustomerController implements Controller {
    private Repository customerRepository;
    public CustomerController(Repository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public int register(String name, String email, String password, String gender, String address, String age) {
        return 0;
    }

    @Override
    public int login(String email, String password) {
        return 0;
    }
}
