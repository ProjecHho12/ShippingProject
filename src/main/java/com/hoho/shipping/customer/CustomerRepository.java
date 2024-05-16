package com.hoho.shipping.customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CustomerRepositoryInter {
    private static final String PATH = "./main.customer.sav";

    private List<Customer> customers;

    public CustomerRepository() {
        this.customers = new ArrayList<>();
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
        File file = new File(PATH);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(PATH)) {
                // 객체를 로딩할 보조 스트림
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<Customer> customersList = (List<Customer>) ois.readObject();
//                System.out.println("customersList = " + customersList);
                this.customers = customersList;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
//                System.out.println("customer에 입력된 텍스트가 없음");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
