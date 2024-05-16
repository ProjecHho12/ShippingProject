package com.hoho.shipping.loop;

import com.hoho.shipping.customer.CustomerController;
import com.hoho.shipping.customer.CustomerControllerImpl;
import com.hoho.shipping.customer.CustomerRepository;
import com.hoho.shipping.customer.CustomerRepositoryInter;
import com.hoho.shipping.employee.EmployeeControllerImpl;
import com.hoho.shipping.employee.EmployeeRepository;
import com.hoho.shipping.parcel.ParcelRepository;

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
	private CustomerController customerController() {
		return new CustomerControllerImpl(customerRepository());
	}
	private CustomerRepositoryInter customerRepository() {
		return new CustomerRepository();
	}
	private EmployeeRepository employeeRepository() {
		return new EmployeeRepository();
	}
	private ParcelRepository parcelRepository() {
		return ParcelRepository.getInstance();
	}

}
