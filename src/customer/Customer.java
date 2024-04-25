package customer;

import java.time.LocalDate;

/**
 * packageName    : customer fileName       : Customer author         : hoho date           :
 * 4/25/24 description    :
 */
public class Customer {

    private int id; //식별번호
    private int age;
    private String customerName;
    private String email;
    private String customerId;
    private String password;
    private String adress;
    private String gender;
    private LocalDate regDate; // 회원가입일자

    // 사용자가 제공하는 데이터: 이메일, 패스워드, 이름, 성별, 나이
    public Customer(String memberName, String email, String customerId, String password, String adress, String gender, int age) {
        this.id = 1;
        this.regDate = LocalDate.now(); // 현재 시간을 읽어서 처리
        this.email = email;
        this.customerId = customerId;
        this.password = password;
        this.adress = adress;
        this.customerName = memberName;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getPassword() {
        return password;
    }

    public String getAdress() {
        return adress;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getRegDate() {
        return regDate;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", age=" + age +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", customerId='" + customerId + '\'' +
                ", password='" + password + '\'' +
                ", adress='" + adress + '\'' +
                ", gender='" + gender + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}


