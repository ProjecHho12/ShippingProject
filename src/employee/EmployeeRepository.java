package employee;


import customer.Gender;

import loop.Repository;
import parcel.Parcel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository, Serializable {

    public List<Employee> employeeList;

    String targetPath = "/Users/jieun/Desktop/teamProject/javaProject/Shipping/src/employee/employees.sav";

    public EmployeeRepository() {

        this.employeeList = new ArrayList<>();


        File file = new File(targetPath);
        if (!file.exists()) return;

        // 세이브 파일 로딩하기
        try (FileInputStream fis = new FileInputStream(targetPath)) {

            // 객체를 로딩할 보조 스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Employee> employeeList = (List<Employee>) ois.readObject();

            System.out.println("employeeList = " + employeeList);

        } catch (Exception e) {
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

            try (FileOutputStream fos = new FileOutputStream(targetPath)) {

                // 객체를 통째로 저장할 수 있는 보조 스트림
                // serialize: 직렬화 - 데이터를 일렬로 늘여뜨려 놓는 것
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                employeeList.add(newEmployee);
                oos.writeObject(employeeList);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }




    public void printEmployee() {
        System.out.println("employeeList = " + employeeList);
    }


    public Employee login(String email, String password) {

        Employee matechedEmployee = employeeList.stream().filter(e -> e.getEmployeeEmail().equals(email)).collect(Collectors.toList()).get(0);

        if (matechedEmployee != null) {
            if (matechedEmployee.getEmployeePW().equals(password)) {

                return matechedEmployee;
            }
        }
        return null;


    }

    /**
     * 비밀 번호로 본인 확인
     * @param employee - 사용자
     * @param password - 사용자가 입력할 비밀번호 값
     * @return 일치하면 true
     */
    public boolean identificationByPw (Employee employee, String password){
        return employee.getEmployeePW().equals(password);
    }

    /**
     * 비밀번호 수정
     * @param employee - 수정할 직원 정보
     * @param oldPassword - 이전 비밀번호
     * @param newPassword - 새 비밀번호
     */
    public void modifyPw (Employee employee, String oldPassword, String newPassword){
        if(identificationByPw(employee,oldPassword)){
            employee.setEmployeePW(newPassword);
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


    public void incomeParcel() {
    }

    public void outcomeParcel() {
    }


    //////////// 업무 일지 /////////////

    // 택배 아이디를 입고했습니다
    // 택배 아이디를 출고했습니다
    public void addJournal(Employee employee,Parcel parcel){
        String status = "";
        if (parcel.getStatus().equals("입고")) status = "입고";
        if (parcel.getStatus().equals("출고")) status = "출고";
        String memo = String.format( "운송장 번호"+ "택배를 "+ status + "했습니다. 직원: "+ employee.getEmployeeName());


    }

}
