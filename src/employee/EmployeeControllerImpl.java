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


    public void register(String name, String email, String password, String gender, String address, int age, int employeePhone, Job job) {
        Employee newEmployee = new Employee(name, email, password, gender, address, age, employeePhone, job);
        if (!er.isContains(newEmployee)){
            er.resister(newEmployee);
        }
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
