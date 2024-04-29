package employee;

import customer.Gender;
import loop.Repository;
import parcel.Parcel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository {

    public List<Employee> employeeList;

    String targetPath = "/Users/jieun/Desktop/teamProject/javaProject/Shipping/src/employee/employees.txt";

    public EmployeeRepository() {

        this.employeeList = new ArrayList<>();


        File file = new File(targetPath);
        if (!file.exists()) return;

        try (FileReader fr = new FileReader(targetPath)) {
            BufferedReader br = new BufferedReader(fr);


            while (true) {
                String s = br.readLine();


                if (s == null) break;

                String[] split = s.split(",");
                System.out.println(Arrays.toString(split));

                Job job = null;
                if (split[7].equals(Job.OUTCOMING.name())) job = Job.OUTCOMING;
                else if (split[7].equals(Job.INCOMING.name())) job = Job.INCOMING;
                // 읽어들인 회원정보로 회원 객체 생성
                Employee employee = new Employee(
                        split[0],
                        split[1],
                        split[2],
                        split[3],
                        split[4],
                        Integer.parseInt(split[5]),
                        Integer.parseInt(split[6]),
                        job
                );

                this.employeeList.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 입력받은 정보와 일치하는 직원이 있는지 없는지
     *
     * @param target 새로 입력받은 직원 정보
     * @return 입력받은 정보를 가진 직원이 있으면 true
     */
    public boolean isContains(Employee target) {
        return employeeList.contains(target);
    }

    /**
     * 입력 받은 정보로 새 직원 생성
     *
     * @param name          새 직원 이름
     * @param email
     * @param password
     * @param gender
     * @param address
     * @param age
     * @param employeePhone
     * @param job
     */
    public void resister(String name, String email, String password, String gender, String address, int age, int employeePhone, Job job) {
        Employee newEmployee = new Employee(name, email, password, gender, address, age, employeePhone, job);
        if (!isContains(newEmployee)) {
            employeeList.add(newEmployee);


            try (FileWriter fw = new FileWriter(targetPath, true)) {

                String column = String.format(newEmployee.getEmployeeName() + ',' + newEmployee.getEmployeeEmail() + ',' + newEmployee.getEmployeePW() + ',' + newEmployee.getEmployeeGender() + ',' + newEmployee.getEmployeeAddress() + ',' + newEmployee.getAge() + ',' + newEmployee.getEmployeePhone() + ',' + newEmployee.getJob());
                fw.write(column + "\n");

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


    public void printEmployee() {

    }


    public Employee login(String email, String password) {
//        System.out.println(employeeList.getEmployeeList());
        Employee matechedEmployee = employeeList.stream().filter(e -> e.getEmployeeEmail().equals(email)).collect(Collectors.toList()).get(0);

        if (matechedEmployee != null) {
            if (matechedEmployee.getEmployeePW() == password) {

                return matechedEmployee;
            }
        }
        return null;


    }

    List<Parcel> parcelList = new ArrayList<>();

    public void readParcel() {
        int i = 0;
        for (Parcel parcel : parcelList) {
            i++;
            System.out.println(i + ". " + parcel);
        }
    }

    public void incomeParcel() {

    }

    public void outcomeParcel() {

    }


}
