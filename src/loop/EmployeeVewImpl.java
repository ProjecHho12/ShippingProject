package loop;

import employee.Employee;
import employee.EmployeeControllerImpl;
import employee.Job;
import util.SimpleInput;

public class EmployeeVewImpl {
    private final EmployeeControllerImpl employeeController;
    private final ParcelControllerImpl parcelController;

    public EmployeeVewImpl(EmployeeControllerImpl employeeController, ParcelControllerImpl parcelController) {
        this.employeeController = employeeController;
        this.parcelController = parcelController;
    }

    void registerEmployee() {
        System.out.println("\n***** 직원 등록 하기 *****");
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
        int phone;
        while (true) {
            try {
                phone = Integer.parseInt(SimpleInput.input("휴대폰번호('-' 없이 입력): "));
                break;
            } catch (Exception e) {
                System.out.println("휴대폰번호는 숫자로만 입력해주세요");
            }
        }
        Job job = Job.INCOMING;
        String select = SimpleInput.input("1.출고 2.입고 선택 : ");
        if (select.equals("1")) {
            job = Job.OUTCOMING;
        }
        switch (employeeController.register(name, email, password, gender, address, age, phone,
                job)) {
            case 1:
                System.out.println("\n이미 등록된 이메일입니다.\n");
                break;
            default:
                System.out.println("\n등록에 성공했습니다.\n");
        }
    }

    void employeeLogin(String email, String password) {
        Employee tar = employeeController.login(email, password);
        if (tar != null) {
            selectEmployeeMenu(tar);
        } else {
            System.out.println("\n아이디 또는 비밀번호를 확인해주세요");
        }
    }

    private void selectEmployeeMenu(Employee tar) {
        while (true) {
            switch (employeeMenu()) {
                case "1":
                    selectParcelByEmployee();
                    break;
                case "2":
                    selectAllParcelByEmployee();
                    break;
                case "9":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("입력한 메뉴 번호를 확인해주세요.!");
                    break;
            }
            System.exit(0);
        }
    }

    private String employeeMenu() {
        System.out.println("\n***** 환영합니다! 어떤 메뉴를 선택하시겠습니까? *****\n" +
                "# 1. 입고된 택배 조회\n" +
                "# 2. 전체 택배 조회\n" +
                "# 9. 프로그램종료\n" +
                "========================");
        return SimpleInput.input(">> ");
    }

    private void selectParcelByEmployee() {
    }

    private void selectAllParcelByEmployee() {
    }
}
