package customer;

//import util.SimpleInput;
//
//
//public class CustomerTestView {
//
//    SimpleInput si = new SimpleInput();
//    static CustomerTestController cc = new CustomerTestController();
//    CustomerRepository cr = new CustomerRepository();
//
//
//    String showProgramMenu() {
//        System.out.println("\n##### 배송 시스템 #####");
//        System.out.println("* 1. 로그인");
//        System.out.println("* 2. 회원가입");
//        System.out.println("* 3. 배송 조회");
//        System.out.println("* 9. 프로그램 종료");
//        System.out.println("=============================");
//
//        String menuNumber = si.input("- 메뉴 번호: ");
//
//        return menuNumber;
//    }
//
//    String showCustomerMenu() {
//
//        System.out.println("\n##### 고객 메뉴 #####");
//        System.out.println("* 1. 배송 등록하기");
//        System.out.println("* 2. 배송 조회");
//        System.out.println("* 3. 마이페이지");
//        System.out.println("* 9. 프로그램 종료");
//        System.out.println("=============================");
//
//        String CustomerMenuNumber = si.input("- 메뉴 번호: ");
//
//        return CustomerMenuNumber;
//    }
//
//    public void makeNewCustomer() {
//
//        String name = SimpleInput.input("- 이름: ");
//
//        String email = SimpleInput.input("- 이메일: ");
//
//        String id;
//        while (true) {
//            id = SimpleInput.input("- 아이디: ");
//            if (id.equals("0")) break;
////            back();
//            if (id.length() < 4) {
//                System.out.println("아이디는 4글자 이상으로 작성해주세요.");
//            } else {
//                break;
//            }
//        }
//
//        String password = SimpleInput.input("- 패스워드: ");
//
//        String address = SimpleInput.input("- 주소: ");
//
//        String gender;
//        while (true) {
//            gender = SimpleInput.input("- 성별(M/F): ").toUpperCase();
//            if (gender.equals("0")) break;
////            back();
//            if (gender.equals("M")) {
//                gender = String.valueOf(Gender.MALE);
//                break;
//            } else if (gender.equals("F")) {
//                gender = String.valueOf(Gender.FEMALE);
//                break;
//            } else {
//                System.out.println("남성이시면(M),여성이시면(F)를 입력해주세요");
//            }
//        }
//
//        int age = 0;
//        while (true) {
//
//            try {
//                age = Integer.parseInt(SimpleInput.input("- 나이: "));
////                back();
//                if (age == 0) break;
//                break;
//            } catch (Exception e) {
//                System.out.println("나이는 숫자로만 입력해주세요");
//            }
//        }
//        System.out.println("회원 가입 완료!!");
//
//        Customer newCustomer = new Customer(name, email, id, password, address, gender, age);
//
//        cr.addNewCustomer(newCustomer);
//
//    }
//
//    public void logIn() {
//        while (true) {
//            String inputId = SimpleInput.input("- 아이디: ");
//            if (inputId.equals("0")) break;
////            back();
//            if (cr.checkId(inputId)) {
//                String inputPassword = SimpleInput.input("- 비밀번호: ");
////                back();
//                if (inputPassword.equals("0")) break;
//                if (cr.checkPassword(inputId, inputPassword)) {
//                    cc.customerRun();
//                }
//                break;
//            } else {
//                System.out.println("존재하지 않는 아이디입니다.");
//            }
//        }
//    }
//
//    public void back() {
//        System.out.println("\n====================================");
//        System.out.println("뒤로가기 >> 0");
//    }
//
////    public void showCustomers() {
////    }
//}
