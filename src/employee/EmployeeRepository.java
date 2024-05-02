package employee;


import customer.Gender;

import loop.Repository;
import parcel.Parcel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository {
    public List<Employee> employeeList;

    String targetPath = "./employees.sav";

    public EmployeeRepository() {
        this.employeeList = new ArrayList<>();
        loadFile();
    }

    private void loadFile() {
        File file = new File(targetPath);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(targetPath)) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.employeeList = (List<Employee>) ois.readObject();
                System.out.println("employeeList = " + employeeList);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("입력된 텍스트가 없음");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void saveFile() {
        try (FileOutputStream fos = new FileOutputStream(targetPath)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.employeeList);
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
     * @param newEmployee
     */

    public void resister(Employee newEmployee) {
        employeeList.add(newEmployee);
        System.out.println("newEmployee = " + newEmployee);
        saveFile();
    }



    public void printEmployee() {
        System.out.println("employeeList = " + employeeList);
    }


    public Employee login(Employee matechedEmployee, String password) {

        if (matechedEmployee.getEmployeePW().equals(password)) return matechedEmployee;

        return null;
    }

    /**
     * 비밀 번호로 본인 확인
     *
     * @param employee - 사용자
     * @param password - 사용자가 입력할 비밀번호 값
     * @return 일치하면 true
     */
    public boolean identificationByPw(Employee employee, String password) {
        return employee.getEmployeePW().equals(password);
    }


//    List<Parcel> parcelList = new ArrayList<>();
//
//    public void readParcel() {
//        int i = 0;
//        for (Parcel parcel : parcelList) {
//            i++;
//            System.out.println(i + ". " + parcel);
//        }
//    }
//
//
//    public void incomeParcel(Parcel parcel) {
//        parcel.
//    }
//
//    public void outcomeParcel() {
//    }


    //////////// 업무 일지 /////////////
    public void addJournal(Employee employee, Parcel parcel) {
        Journal newJournal = new Journal(parcel.getTrackingNumber(), parcel.getStatus(), employee.getEmployeeName());
        employee.addJournal(newJournal);
    }


}
