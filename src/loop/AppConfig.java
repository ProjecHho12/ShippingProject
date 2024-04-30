package loop;

import customer.CustomerControllerImpl;
import customer.CustomerRepository;
import employee.EmployeeRepository;

public class AppConfig {
	public View view() {
		return new MainViewImpl(customerController(), employeeController());
	}

	private EmployeeController employeeController() {
		return new EmployeeController(employeeRepository());
	}
	private CustomerControllerImpl customerController() {
		return new CustomerControllerImpl(customerRepository());
	}
	private CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
	private EmployeeRepository employeeRepository() {
		return new EmployeeRepository();
	}
}
