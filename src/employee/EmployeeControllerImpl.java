package employee;

import loop.Controller;
import loop.Repository;

import java.util.stream.Collectors;

public class EmployeeControllerImpl{

     private final EmployeeRepository repository;

    public EmployeeControllerImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    //
//
    public void register(String name, String email, String password, String gender, String address, int age, int employeePhone, Job job) {
        Employee newEmployee = new Employee(name, email, password, gender, address, age, employeePhone, job);
        if (!repository.isContains(newEmployee)){
            repository.resister(newEmployee);
        }
    }

    public Employee login(String email, String password){
        Employee matechedEmployee = repository.employeeList.stream().filter(e -> e.getEmployeeEmail().equals(email)).collect(Collectors.toList()).get(0);

        if (matechedEmployee != null) {
            return repository.login(matechedEmployee ,password);
        }
        return null;
    }

    public void modifyPw(Employee employee, String oldPassword, String newPassword) {
        if (repository.identificationByPw(employee, oldPassword)) {
            employee.setEmployeePW(newPassword);
        }
    }
}
