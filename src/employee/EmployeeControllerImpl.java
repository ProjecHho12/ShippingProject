package employee;

import loop.Controller;
import loop.EmployeeRepositoryImpl;
import loop.Repository;

import javax.swing.*;
import java.util.stream.Collectors;

public class EmployeeControllerImpl {
    private final EmployeeRepository er;
    public EmployeeControllerImpl(EmployeeRepository employeeRepository) {
        er = employeeRepository;
    }

    //
//
    public int register(String name, String email, String password, String gender, String address, int age, int employeePhone, Job job) {
        Employee newEmployee = new Employee(name, email, password, gender, address, age, employeePhone, job);
        if (!this.er.isContains(newEmployee)){
            this.er.resister(newEmployee);
            return 0;
        }
        return 1;
    }

    public Employee login(String email, String password){

        if (er.employeeList.size()>0){
            Employee matechedEmployee = er.employeeList
                    .stream()
                    .filter(e -> e.getEmployeeEmail()
                            .equals(email))
                    .collect(Collectors.toList()).get(0);

            if (matechedEmployee != null) {
                return er.login(matechedEmployee ,password);
            }
        }
        return null;
    }

    public void modifyPw(Employee employee, String oldPassword, String newPassword) {
        if (er.identificationByPw(employee, oldPassword)) {
            employee.setEmployeePW(newPassword);
        }
    }
}
