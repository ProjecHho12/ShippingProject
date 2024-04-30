package customer;

import java.util.ArrayList;
import java.util.List;
import loop.Repository;

public class CustomerRepository implements Repository {

    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addNewCustomer(Customer newCustomer) {
        customers.add(newCustomer);
    }

    public boolean checkId(String id) {
        boolean idExists = customers.stream()
                .anyMatch(customer -> customer.getCustomerId().equals(id));
        if (!idExists) {
            return false;
        }
        return idExists;
    }

    public boolean checkPassword(String id, String password) {
        return customers.stream()
                .filter(customer -> customer.getCustomerId().equals(id))
                .anyMatch(customer -> customer.getPassword().equals(password));
    }

}
