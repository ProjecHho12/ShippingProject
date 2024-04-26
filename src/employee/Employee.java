package employee;

/**
 * packageName    : employee fileName       : Employee author         : hoho date           :
 * 4/25/24 description    :
 */
public class Employee {
    private String employeeName;
    private String employeeId;
    private Job job;

    public Employee(String employeeName, String employeeId, Job job) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.job = job;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Job getJob() {
        return job;
    }
}
