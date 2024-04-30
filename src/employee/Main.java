package employee;

import java.io.*;
import java.text.Format;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        try {
            repository.resister("mmm", "mmm@mmm.mmm", "mmm", "f", "mmm", 10, 01012341234, Job.INCOMING);
            repository.resister("fff", "fff@fff.fff", "fff", "f", "mmm", 10, 01012341234, Job.INCOMING);
//            repository.resister("zz", "zz@fff.fff", "zz", "f", "mmm", 10, 01012341234, Job.OUTCOMING);
//            repository.printEmployee();
//           Employee matechedEmployee = repository.login("mmm", "mmm");
//            System.out.println("matechedEmployee = " + matechedEmployee);

            System.out.println(repository.employeeList);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
