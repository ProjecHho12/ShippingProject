package customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

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
        // 포문 돌려서 찾기
        return false;
    }

    public void checkPassword(String password) {

    }
}
