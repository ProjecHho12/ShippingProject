package employee;

/**
 * packageName    : employee fileName       : Employee author         : hoho date           :
 * 4/25/24 description    :
 */
public class Employee {
    private String employeeName;
    private String employeeEmail;
    private String employeePW;
    private String employeeGender;
    private String employeeAddress;
    private int age;
    private int employeePhone;
    private Job job;


    public Employee(String employeeName, String employeeEmail, String employeePW, String employeeGender, String employeeAddress, int age, int employeePhone, Job job) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePW = employeePW;
        this.employeeGender = employeeGender;
        this.employeeAddress = employeeAddress;
        this.age = age;
        this.employeePhone = employeePhone;
        this.job = job;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeePW() {
        return employeePW;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public int getAge() {
        return age;
    }

    public int getEmployeePhone() {
        return employeePhone;
    }

    public Job getJob() {
        return job;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public void setEmployeePW(String employeePW) {
        this.employeePW = employeePW;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmployeePhone(int employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePW='" + employeePW + '\'' +
                ", employeeGender='" + employeeGender + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", age=" + age +
                ", employeePhone=" + employeePhone +
                ", job=" + job +
                '}';
    }
}
