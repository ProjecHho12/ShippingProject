package loop;

import customer.CustomerControllerImpl;
import customer.CustomerRepository;
import employee.EmployeeControllerImpl;
import employee.EmployeeRepository;
import parcel.ParcelRepository;

public class AppConfig {
	public MainViewImpl view() {
		return new MainViewImpl(customerView(), employeeView());
	}

	private EmployeeVewImpl employeeView() {
		return new EmployeeVewImpl(employeeController());
	}

	private CustomerViewImpl customerView() {
		return new CustomerViewImpl(customerController(), parcelRepository());
	}

	private EmployeeControllerImpl employeeController() {
		return new EmployeeControllerImpl(employeeRepository());
	}
	private CustomerControllerImpl customerController() {
		return new CustomerControllerImpl(customerRepository());
	}
	private ParcelControllerImpl parcelController() {
		return new ParcelControllerImpl(parcelRepository());
	}
	private CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
	private EmployeeRepository employeeRepository() {
		return new EmployeeRepository();
	}
	private ParcelRepository parcelRepository() {
		return ParcelRepository.getInstance();
	}

}
