package employee;

import parcel.Parcel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

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
     *
     * @param name          새 직원 이름
     * @param employeePhone 새 직원 전화번호
     * @param id            새 직원 아이디
     * @param password      새 직원 비밀번호
     * @param job           직원 업무(입고/출고)
     */
    public void resister(String name, int employeePhone, String id, String password, Job job) {
        Employee newEmployee = new Employee(name, employeePhone, id, password, job);
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



}
