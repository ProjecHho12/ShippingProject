package employee;

import loop.Controller;
import loop.Repository;

public class EmployeeControllerlmpl implements Controller {
    private final Repository er;

    public EmployeeControllerlmpl(Repository EmployeeRepository) {
        this.er = EmployeeRepository;
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
