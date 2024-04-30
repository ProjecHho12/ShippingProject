package loop;

import customer.Customer;

import java.util.List;

public class EmployeeController implements Controller{
    private EmployeeRepositoryImpl employeeRepository;
    public EmployeeController(EmployeeRepositoryImpl employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int register(String name, String email, String password, String gender, String address, String age) {
        return 0;
    }


    @Override
    public int register(String name, String email, String password, String gender, String address, int age) {
        return 0;
    }

    @Override
    public Customer login(String email, String password) {
        return null;
    }

//    public int login(String email, String password) {
//        return 0;
//    }
}
