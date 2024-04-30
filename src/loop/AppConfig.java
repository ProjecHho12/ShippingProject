package loop;

import customer.CustomerControllerImpl;
import customer.CustomerRepository;

public class AppConfig {
	public View view() {
		return new MainViewImpl(customerController(), employeeController());
	}

	private Controller employeeController() {
		return new EmployeeController(employeeRepository());
	}
	private CustomerControllerImpl customerController() {
		return new CustomerControllerImpl(customerRepository());
	}
	private CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
	private Repository employeeRepository() {
		return new EmployeeRepositoryImpl();
	}
}
