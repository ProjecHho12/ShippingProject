package employee;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        String ROOT_PATH = "./src/employee/";
        try {
            repository.resister("mmm","mmm@mmm.mmm","mmm","f", "mmm", 10,01012341234,Job.INCOMING);
//            repository.resister("mmm",90789098,"mmm","mmm", Job.INCOMING);
            repository.printEmployee();
            repository.login("mmm","mmm");

        } catch (Exception e) {
            e.printStackTrace();
        };

        // 파일 생성하기
        File newFile1 = new File(ROOT_PATH + "employees.txt");
        if (!newFile1.exists()) {
            try {
                newFile1.createNewFile();
                for (Employee em : repository.employeeList.getEmployeeList()){

                }
            } catch (IOException e) {
                System.out.println("파일 생성에 실패했습니다.");
            }
        }

        try (FileWriter fw = new FileWriter(ROOT_PATH +  "employees.txt")){
            // 파일 생성 명령
            for (Employee em:repository.employeeList.getEmployeeList()){
                fw.write(em + "\n");
            }
        } catch(Exception e){}
    }
}
