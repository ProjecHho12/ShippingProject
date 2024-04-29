package loop;

public class EmployeeController implements Controller {
    private Repository employeeRepository;
    public EmployeeController(Repository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
