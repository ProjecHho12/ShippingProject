package loop;

public class AppConfig {
	public View view() {
		return new MainViewImpl(customerRepository(), employeeRepository());
	}

	private CustomerRepository customerRepository() {
		return new CustomerRepositoryImpl();
	}

	private EmployeeRepository employeeRepository() {
		return new EmployeeRepositoryImpl();
	}
}
