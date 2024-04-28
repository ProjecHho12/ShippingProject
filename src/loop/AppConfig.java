package loop;

import customer.CustomerRepository;

public class AppConfig {
	public View view() {
		return new MainViewImpl(customerController(), employeeController());
	}

	private Controller employeeController() {
		return new EmployeeController(employeeRepository());
	}
	private Controller customerController() {
		return new CustomerController(customerRepository());
	}
	private Repository customerRepository() {
		return new CustomerRepositoryImpl();
	}
	private Repository employeeRepository() {
		return new EmployeeRepositoryImpl();
	}
}
