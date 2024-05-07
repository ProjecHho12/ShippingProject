package loop;

import employee.Employee;
import employee.EmployeeControllerImpl;
import employee.Job;

import java.util.ArrayList;
import java.util.List;
import parcel.ParcelView;
import parcel.parcelElement.Parcel;
import util.SimpleInput;

public class EmployeeVewImpl {
    private final EmployeeControllerImpl employeeController;

    public EmployeeVewImpl(EmployeeControllerImpl employeeController) {
        this.employeeController = employeeController;
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
        switch (employeeController.register(name, email, password, gender, address, age, phone, job)) {
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
        List<Parcel> list = employeeController.selectIncomingParcel();
        System.out.printf("현재 접수된 택배 목록입니다. (총%d개)\n", list.size());
        if (list.isEmpty()) return ;
		for (int i = 0; i < list.size(); i++) {
			Parcel parcel = list.get(i);
            System.out.println(i + 1 + ". ==============================");
            System.out.println(parcel);
            System.out.println("========================================");
		}
        while (true) {
            int input = -1;
            try {
                input = Integer.parseInt(SimpleInput.input("출고 상태로 변경할 택배를 선택해주세요\n>> "));
                employeeController.setOutcoming(list.get(input - 1).getTrackingNumber());
            } catch (NumberFormatException e) {
                System.out.println("\n숫자를 입력해주세요\n");
                continue ;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n범위내 값을 입력해주세요\n");
                continue ;
            }
            break;
        }
    }

    private void selectAllParcelByEmployee() {
        ArrayList<Parcel> list = employeeController.selectAllParcel();
        System.out.printf("현재 접수된 택배 목록입니다. (총%d개)\n", list.size());
        if (list.size() == 0) return ;
		for (int i = 0; i < list.size(); i++) {
			Parcel parcel = list.get(i);
            System.out.println(i + 1 + ". ==============================");
            System.out.println(parcel);
            System.out.println("========================================");
		}
    }
}
