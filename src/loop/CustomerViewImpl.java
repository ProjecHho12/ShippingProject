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
        String email = SimpleInput.input("이메일: ");
        String password = SimpleInput.input("비밀번호: ");
        String gender = SimpleInput.input("성별(M/F): ");
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
                    ParcelView.startInputParcel();
                    break;
                case "2":
                    selectParcelByCustomer();
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
                "# 9. 프로그램종료\n" +
                "========================");
        return SimpleInput.input(">> ");
    }
    private void selectParcelByCustomer() {
    }
}
