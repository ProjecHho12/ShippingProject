package loop;

import customer.Gender;
import util.SimpleInput;

public class MainViewImpl implements View{
	private Controller customerController;
	private Controller employeeController;
	public MainViewImpl(Controller customerController, Controller employeeController) {
		this.customerController = customerController;
		this.employeeController = employeeController;
	}
	@Override
	public void run() {
		while (true) {
			if (selectMenu() == 0)
				break ;
		}
	}
	private int selectMenu() {
		switch (mainMenu()) {
			case "1":
				login();
				break;
			case "2":
				registerCustomer();
				break;
			case "3":
				registerEmployee();
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
		String email = SimpleInput.input("이메일: ");
		String password = SimpleInput.input("비밀번호: ");
		switch (customerController.login(email, password)) {
			case 1:
				break;
			default:
				selectCustomerMenu();
		}
		switch (employeeController.login(email, password)) {
			case 1:
				System.out.println("\n입력한 이메일, 비밀번호를 다시 확인해주세요.\n");
				break;
			default:
				selectEmployeeMenu();
		}
	}
	private void registerCustomer() {
		System.out.println("\n***** 고객 등록 하기 *****");
		String name = SimpleInput.input("이름: ");
		String email = SimpleInput.input("이메일: ");
		String password = SimpleInput.input("비밀번호: ");
		String gender = SimpleInput.input("성별(M/F): ");
		String address = SimpleInput.input("주소: ");
		String age = SimpleInput.input("나이: ");
		switch (customerController.register(name, email, password, gender, address, age)) {
			case 1:
				break;
			default:
				System.out.println("\n등록에 성공했습니다.\n");
		}
	}
	private void registerEmployee() {
		System.out.println("\n***** 직원 등록 하기 *****");
		String name = SimpleInput.input("이름: ");
		String email = SimpleInput.input("이메일: ");
		String password = SimpleInput.input("비밀번호: ");
		String gender = SimpleInput.input("성별(M/F): ");
		String address = SimpleInput.input("주소: ");
		String age = SimpleInput.input("나이: ");
		switch (employeeController.register(name, email, password, gender, address, age)) {
			case 1:
				System.out.println("\n이미 등록된 이메일입니다.\n");
				break;
			default:
				System.out.println("\n등록에 성공했습니다.\n");
		}
	}
	private void selectCustomerMenu() {
		while (true) {
			switch (customerMenu()) {
				case "1":
					postParcelByCustomer();
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
	private void postParcelByCustomer() {
	}
	private void selectParcelByCustomer() {
	}
	private void selectEmployeeMenu() {
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
