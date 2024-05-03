package loop;

import customer.Customer;
import customer.CustomerControllerImpl;
import parcel.*;
import util.SimpleInput;

import java.util.ArrayList;
import java.util.List;

public class CustomerViewImpl {
    private final CustomerControllerImpl customerController;
    private final ParcelControllerImpl parcelController;
    private final ParcelView parcelView;
    public CustomerViewImpl(CustomerControllerImpl customerController, ParcelControllerImpl parcelController) {
        this.customerController = customerController;
        this.parcelController = parcelController;
        this.parcelView = new ParcelView();
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
                    parcelView.startInputParcel(tar);
                    break;
                case "2":
                    selectParcelByCustomer(tar);
                    break;
                case "3":
                    selectMyPageByCustomer(tar);
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

    private void selectMyPageByCustomer(Customer tar) {
        System.out.println("\n***** " + tar.getCustomerName() + "님의 마이 페이지 *****\n" +
                "이름: " + tar.getCustomerName() +
                "\n이메일: " + tar.getEmail() +
                "\n주소: " + tar.getAddress() +
                "\n성별: " + tar.getGender() +
                "\n나이: " + tar.getAge() +
                "\n가입일자: " + tar.getRegDate() +
                "\n운송장: " + tar.getTrackingNumbers() +
                "\n========================\n" +
                "# 1. 개인 정보 수정\n" +
                "# 8. 뒤로 가기\n" +
                "# 9. 프로그램종료\n" +
                "========================");
        String menuNum = SimpleInput.input(">> ");
        selectModiInfo(menuNum, tar);
    }

    private void selectModiInfo(String menuNum, Customer tar) {
        switch (menuNum) {
            case "1":
                modiInfoCustomer(tar);
                return;
            case "8":
                return;
            case "9":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            default:
                System.out.println("입력한 메뉴 번호를 확인해주세요.!");
                break;
        }
    }

    private void modiInfoCustomer(Customer tar) {
        System.out.println("\n***** " + tar.getCustomerName() + "님의 마이 페이지 *****\n" +
                "# 1. 비밀번호 변경\n" +
                "# 2. 주소 변경\n" +
                "# 8. 뒤로 가기\n" +
                "# 9. 프로그램종료\n" +
                "========================");
        String menuNum = SimpleInput.input(">> ");
        selectModiPwOrAddr(menuNum, tar);
    }

    private void selectModiPwOrAddr(String menuNum, Customer tar) {
        switch (menuNum) {
            case "1":
                modiPwCustomer(tar);
                return;
            case "2":
                modiAddrCustomer(tar);
                return;
            case "8":
                return;
            case "9":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            default:
                System.out.println("입력한 메뉴 번호를 확인해주세요.!");
                break;
        }
    }

    private void modiPwCustomer(Customer tar) {
        // 비밀번호 변경
        // 맞지 않을 때 루프 추가
        System.out.println("\n***** " + tar.getCustomerName() + "님의 마이 페이지 *****\n");
        while (true) {
            String checkPassword = SimpleInput.input("현재 비밀번호: ");
            if (customerController.modiPassword(checkPassword, tar)) {
                String newPassword = SimpleInput.input("변경하실 비밀번호: ");
                customerController.newPasswordByCustomer(newPassword, tar);
                System.out.println(tar.getCustomerName() + "님의 비밀번호가 변경되었습니다.");
                break;
            } else {
                System.out.println("비밀번호가 맞지 않습니다.");
            }
        }
    }

    private void modiAddrCustomer(Customer tar) {
        // 주소 변경
        System.out.println("\n***** " + tar.getCustomerName() + "님의 마이 페이지 *****\n"
                + "현재 주소: " + tar.getAddress()
                + "\n========================\n");
        String newAddress = SimpleInput.input("변경하실 주소: ");
        customerController.newAddrByCustomer(newAddress, tar);
        System.out.println(tar.getCustomerName() + "님의 주소가 변경되었습니다.");
    }

    private void selectParcelByCustomer(Customer tar) {
        // 고객에게 저장된 운송장 번호와 택배리스트에 있는 택배의 운송장 번호가 일치하면 해당 택배정보를 가져와라
        List<Parcel> parcelList = getParcelByCustomer(tar);
        System.out.println("\n***** " + tar.getCustomerName() + "님의 마이 페이지 *****\n"
                + "======== 배송 리스트 ========");
        for (Parcel parcel : parcelList) {
            System.out.println(parcel);
        }
        System.out.println("\n===========================\n");
    }

    private List<Parcel> getParcelByCustomer(Customer tar) {
        // 고객에게 저장된 운송장 번호와 택배리스트에 있는 택배의 운송장 번호가 일치하면 해당 택배정보를 가져와라
        Parcel[] customerParcelList = ParcelView.getRepository().getParcelArray(); // 택배리스트
        List<String> trackingNumbers = tar.getTrackingNumbers(); // 고객의 운송장번호 리스트
        List<Parcel> foundParcelList = new ArrayList<>();

        for (Parcel parcel : customerParcelList) {
            String trackingNumber = parcel.getTrackingNumber(); // 택배의 운송장번호
            for (String number : trackingNumbers) {
                if (trackingNumber.equals(number)) {
                    foundParcelList.add(parcel);
                }
            }
        }
        return foundParcelList;
    }

}





