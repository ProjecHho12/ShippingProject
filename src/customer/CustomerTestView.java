package customer;

import util.SimpleInput;


public class CustomerTestView {

    SimpleInput si = new SimpleInput();
    static CustomerTestController ct = new CustomerTestController();
    CustomerRepository cr = new CustomerRepository();

    String showProgramMenu() {
        System.out.println("\n##### 배송 시스템 #####");
        System.out.println("* 1. 로그인");
        System.out.println("* 2. 회원가입");
        System.out.println("* 3. 배송 조회");
        System.out.println("* 4. 마이페이지");
        System.out.println("* 9. 프로그램 종료");
        System.out.println("=============================");

        String menuNumber = si.input("- 메뉴 번호: ");

        return menuNumber;
    }

    public void inputNewCustomer() {

        String name = SimpleInput.input("- 이름: ");
        String email = null;
        email = SimpleInput.input("- 이메일: ");
        String id = SimpleInput.input("- 아이디: ");
        String password = SimpleInput.input("- 패스워드: ");
        String address = SimpleInput.input("- 주소: ");
        String gender = SimpleInput.input("- 성별(M/F): ").toUpperCase();
        if (gender.equals("M")) {
            gender = String.valueOf(Gender.MALE);
        } else if (gender.equals("F")) {
            gender = String.valueOf(Gender.FEMALE);
        }
        int age = 0;
        while (true) {
            try {
                age = Integer.parseInt(SimpleInput.input("- 나이: "));
                break;
            } catch (Exception e) {
                System.out.println("나이는 숫자로 입력해주세요");
            }
        }

        Customer newCustomer = new Customer(name,email,id,password,address,gender,age);

        System.out.println(newCustomer.toString());

        cr.addNewCustomer(newCustomer);
    }

    public void logIn() {
        while (true) {
            String inputId = SimpleInput.input("- 아이디: ");
            if(cr.checkId(inputId)){
                break;
            };
        }
        String inputPassword = SimpleInput.input("- 비밀번호: ");
        cr.checkPassword(inputPassword);
    }

    public void myPage() {

    }

}
