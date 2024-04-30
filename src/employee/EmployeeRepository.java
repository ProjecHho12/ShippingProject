package employee;


import loop.Repository;
import parcel.Parcel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository {

    EmployeeList employeeList;


    public EmployeeRepository() {
        this.employeeList = new EmployeeList();
    }

    /**
     * 입력받은 정보와 일치하는 직원이 있는지 없는지
     *
     * @param target 새로 입력받은 직원 정보
     * @return 입력받은 정보를 가진 직원이 있으면 true
     */
    public boolean isContains(Employee target) {
        return employeeList.employeeList.contains(target);
    }

    /**
     * 입력 받은 정보로 새 직원 생성
     * @param name 새 직원 이름
     * @param email
     * @param password
     * @param gender
     * @param address
     * @param age
     * @param employeePhone
     * @param job
     */
    public void resister(String name, String email, String password,String gender, String address, int age, int employeePhone, Job job) {
        Employee newEmployee = new Employee(name, email, password, gender, address, age, employeePhone,  job);

        if (!isContains(newEmployee)) {
            employeeList.addEmployee(newEmployee);
        }
    }


    public void printEmployee() {
        int i = 0;
        for (Employee em : employeeList.getEmployeeList()) {
            i++;
            System.out.println(i + ". " + em);
        }
    }


    List<Parcel> parcelList = new ArrayList<>();

    public void readParcel() {
        int i = 0;
        for (Parcel parcel : parcelList) {
            i++;
            System.out.println(i + ". " + parcel);
        }
    }

    public Employee login (String email, String password){
        Employee matechedEmployee = employeeList.getEmployeeList().stream().filter(e->e.getEmployeeEmail().equals(email)).collect(Collectors.toList()).get(0);

       if (matechedEmployee != null){
           if (matechedEmployee.getEmployeePW().equals(password)){

               return matechedEmployee;
           }
       }
       return null;


    }

    public void incomeParcel(){

    }
    public void outcomeParcel(){

    }




}
