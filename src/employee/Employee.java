package employee;

/**
 * packageName    : employee fileName       : Employee author         : hoho date           :
 * 4/25/24 description    :
 */
public class Employee {
    private String employeeName;
    private int employeePhone;
    private String employeeID;
    private String employeePW;
    private Job job;


    public Employee(String employeeName, int employeePhone, String employeeID, String employeePW, Job job) {
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeID = employeeID;
        this.employeePW = employeePW;
        this.job = job;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeePhone() {
        return employeePhone;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeePW() {
        return employeePW;
    }

    public Job getJob() {
        return job;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeePhone(int employeePhone) {
        this.employeePhone = employeePhone;
    }

    public void setEmployeePW(String employeePW) {
        this.employeePW = employeePW;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", employeePW='" + employeePW + '\'' +
                ", job=" + job +
                '}';
    }
}
