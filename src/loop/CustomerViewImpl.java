package loop;

import customer.Customer;
import customer.CustomerControllerImpl;
import parcel.*;
import util.SimpleInput;

public class CustomerViewImpl {
    private final CustomerControllerImpl customerController;
    private final ParcelControllerImpl parcelController;

    public CustomerViewImpl(CustomerControllerImpl customerController, ParcelControllerImpl parcelController) {
        this.customerController = customerController;
        this.parcelController = parcelController;
    }

    void registerCustomer() {
        System.out.println("\n***** 고객 등록 하기 *****");
        String name = SimpleInput.input("이름: ");
        String email;
        while (true) {
            email = SimpleInput.input("이메일: ");
            if (customerController.isValidEmail(email)) {
                break;
            } else {
                System.out.println("중복되거나 유효하지 않은 이메일 형식입니다. 다시 입력해주세요.");
            }
        }
        String password = SimpleInput.input("비밀번호: ");
        String gender;
        while (true) {
            gender = SimpleInput.input("성별(M/F): ").toUpperCase();
            if (customerController.isValidGender(gender) != null) {
                gender = String.valueOf(customerController.isValidGender(gender));
                break;
            } else {
                System.out.println("성별을 (M/F) 둘 중 하나로 입력해주세요.");
            }
        }
        String address = SimpleInput.input("주소: ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(SimpleInput.input("나이: "));
                break;
            } catch (Exception e) {
                System.out.println("나이는 숫자로만 입력해주세요");
            }
        }
        switch (customerController.register(name, email, password, gender, address, age)) {
            case 1:
                break;
            default:
                System.out.println("\n등록에 성공했습니다.\n");
        }
    }

    void customerLogin(String email, String password) {
        Customer tar = customerController.login(email, password);
        if (tar != null) {
            selectCustomerMenu(tar);
        } else {
            System.out.println("\n아이디 또는 비밀번호를 확인해주세요");
        }
    }

    private void selectCustomerMenu(Customer tar) {
        while (true) {
            switch (customerMenu()) {
                case "1":
                    ParcelView.pacelrun();
                    break;
                case "2":
                    selectParcelByCustomer();
                    break;
                case "3":
                    selectMypageByCustomer(tar);
                    break;
                case "9":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("입력한 메뉴 번호를 확인해주세요.!");
                    break;
            }
        }
    }

    private String customerMenu() {
        System.out.println("\n***** 환영합니다! 어떤 메뉴를 선택하시겠습니까? *****\n" +
                "# 1. 택배 보내기\n" +
                "# 2. 택배 조회\n" +
                "# 3. 마이 페이지\n" +
                "# 9. 프로그램종료\n" +
                "========================");
        return SimpleInput.input(">> ");
    }

    private void selectMypageByCustomer(Customer tar) {
        System.out.println("\n***** " + tar.getCustomerName() + "님의 마이 페이지 *****\n" +
                "1.이름: " + tar.getCustomerName() +
                "\n2.이메일: " + tar.getEmail() +
                "\n3.주소: " + tar.getAddress() +
                "\n4.성별: " + tar.getGender() +
                "\n5.나이: " + tar.getAge() +
                "\n6.가입일자: " + tar.getRegDate() +
                "\n========================\n" +
                "# 1. 개인 정보 수정\n" +
                "# 2. 뒤로 가기\n" +
                "# 9. 프로그램종료\n" +
                "========================");
        String menuNum = SimpleInput.input(">> ");
        selectModiInfo(menuNum);
    }

    private void selectModiInfo(String menuNum) {

        while (true) {
            switch (menuNum) {
                case "1":
                    modiInfoCustomer();
                    break;
                case "2":
                    return;
                case "9":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("입력한 메뉴 번호를 확인해주세요.!");
                    break;
            }
        }

    }

    private void modiInfoCustomer() {
    }

    private void selectParcelByCustomer() {
    }
}
