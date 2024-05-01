package customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import loop.CustomerRepositoryInter;
import loop.Repository;

public class CustomerRepository implements CustomerRepositoryInter, Serializable {
    private static final String PATH = "./customer.txt";

    private List<Customer> customers;

    public CustomerRepository() {
        loadCustomers();
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

    public void saveCustomers() {
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            // 객체를 통쨰로 저장할 수 있는 보조 스트림
            // serialize: 직렬화 - 데이터를 일렬로 늘여뜨려 놓는 것
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> loadCustomers() {
        try (FileInputStream fis = new FileInputStream(PATH)) {
            // 객체를 로딩할 보조 스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Customer> customersList = (List<Customer>) ois.readObject();
            System.out.println("customersList = " + customersList);
            this.customers = customersList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkId(String id) {
        boolean idExists = customers.stream()
                .anyMatch(customer -> customer.getEmail().equals(id));
        if (!idExists) {
            return false;
        }
        return idExists;
    }

    public boolean checkPassword(String id, String password) {
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(id))
                .anyMatch(customer -> customer.getPassword().equals(password));
    }

}
