package loop;

import employee.Employee;
import employee.EmployeeRepository;
import employee.Job;

public class EmployeeController {
    private EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int register(String name, String email, String password, String gender, String address, int age, int phone, Job job) {
        return 0;
    }
    public Employee login(String email, String password) {
        return null;
    }
}
