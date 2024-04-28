package loop;

import util.SimpleInput;

public class MainViewImpl implements View{
	private CustomerRepository customerRepository;
	private EmployeeRepository employeeRepository;
	public MainViewImpl(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
		this.customerRepository = customerRepository;
		this.employeeRepository = employeeRepository;
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
//				register();
				break;
			case "2":
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

	private void registerEmployee() {
		System.out.println("***** 택배 *****\n" +
			"# 1. 로그인\n" +
			"# 2. 회원 등록\n" +
			"# 3. 직원 등록\n" +
			"# 9. 프로그램종료\n" +
			"========================");
		String name = SimpleInput.input("이름: ");

		int result = regiter(name, pass, ...);

	}

	private String mainMenu() {
		System.out.println("***** 택배 *****\n" +
			"# 1. 로그인\n" +
			"# 2. 회원 등록\n" +
			"# 3. 직원 등록\n" +
			"# 9. 프로그램종료\n" +
			"========================");
		return SimpleInput.input(">> ");
	}

}
