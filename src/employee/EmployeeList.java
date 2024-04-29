package employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    public List<Employee> employeeList;

    public EmployeeList() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    @Override
    public String toString() {
        return "EmployeeList{" +
                "employeeList=" + employeeList +
                '}';
    }
}
