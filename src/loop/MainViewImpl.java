package loop;

import util.SimpleInput;

public class MainViewImpl implements View {

	private final EmployeeVewImpl employeeView;
	private final CustomerViewImpl customerView;

	public MainViewImpl(CustomerViewImpl customerView,
						EmployeeVewImpl employeeView) {
		this.employeeView = employeeView;
		this.customerView = customerView;
	}

	@Override
	public void run() {
		while (true) {
			if (selectMenu() == 0) {
				break;
			}
		}
	}

	private int selectMenu() {
		switch (mainMenu()) {
			case "1":
				login();
				break;
			case "2":
				customerView.registerCustomer();
				break;
			case "3":
				employeeView.registerEmployee();
				break;
			case "9":
				System.out.println("프로그램을 종료합니다.");
				return 0;
			default:
				System.out.println("입력한 메뉴 번호를 확인해주세요.!");
				break;
		}
		return 1;
	}

	private String mainMenu() {
		System.out.println("\n***** 택배 서비스에 오신 것을 환영합니다 *****\n" +
			"# 1. 로그인\n" +
			"# 2. 회원 등록\n" +
			"# 3. 직원 등록\n" +
			"# 9. 프로그램종료\n" +
			"========================");
		return SimpleInput.input(">> ");
	}

	private void login() {
		System.out.println("\n***** 로그인 *****");
		String menu = SimpleInput.input(("1. 고객 2. 직원 \n번호를 선택해주세요: "));
		String email = SimpleInput.input("이메일: ");
		String password = SimpleInput.input("비밀번호: ");
		if (menu.equals("1")) {
			customerView.customerLogin(email, password);
		} else if (menu.equals("2")) {
			employeeView.employeeLogin(email, password);
		}
	}
}
