package loop;

import customer.Customer;
import customer.CustomerControllerImpl;
import employee.Employee;
import employee.Job;
import parcel.Parcel;
import parcel.ProductInfo;
import parcel.Recipient;
import parcel.RecipientAddress;
import parcel.Sender;
import parcel.SenderAddress;
import parcel.Tr.TrackingNumber;
import util.SimpleInput;

public class MainViewImpl implements View {

	private final CustomerControllerImpl customerController;
	private final EmployeeController employeeController;

	public MainViewImpl(CustomerControllerImpl customerController,
		EmployeeController employeeController) {
		this.customerController = customerController;
		this.employeeController = employeeController;
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
		String menu = SimpleInput.input(("1. 고객 2. 직원 \n번호를 선택해주세요: "));
		String email = SimpleInput.input("이메일: ");
		String password = SimpleInput.input("비밀번호: ");
		if (menu.equals("1")) {
			Customer tar = customerController.login(email, password);
			if (tar != null) {
				selectCustomerMenu(tar);
			} else {
				System.out.println("\n아이디 또는 비밀번호를 확인해주세요");
			}
		} else if (menu.equals("2")) {
			Employee tar = employeeController.login(email, password);
			if (tar != null) {
				selectEmployeeMenu(tar);
			} else {
				System.out.println("\n아이디 또는 비밀번호를 확인해주세요");
			}
		}
	}

	private void registerCustomer() {
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

	private void registerEmployee() {
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

	private void selectCustomerMenu(Customer tar) {
		while (true) {
			switch (customerMenu()) {
				case "1":
					postParcelByCustomer(tar);
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

	private void postParcelByCustomer(Customer tar) {
		String senderName;
		while (true) {
			senderName = SimpleInput.input(
				"보내는 분 - 보내시는 고객님의 정보를 정확히 입력해 주세요.\n이름을 입력해주세요. (10자 이하)\n>> ");
			if (senderName.length() <= 10) {
				break;
			} else {
				System.out.println("이름은 10자 이하로 적어주세요");
			}
		}
		String local;
		TrackingNumber locals = null;
		TrackingNumber senderAddressStateProvinceRegion;
		while (true) {
			local = SimpleInput.input(
				"주소 - 보내시는 고객님의 주소를 정확히 입력해 주세요.\n광역시/도 를 입력해주세요 ex) 서울, Seoul\n>> ");
			try {
				for (TrackingNumber m : TrackingNumber.values()) {
					if (m.getNames().contains(local.toUpperCase())) {
						locals = m;
					}
				}
				TrackingNumber v1 = TrackingNumber.valueOf(String.valueOf(locals));
				if (v1 == locals) {
					senderAddressStateProvinceRegion = locals;
					break;
				} else {
					System.out.println("정확한 지역명을 입력해주세요!");
				}
			} catch (Exception e) {
				System.out.println("정확한 지역명을 입력해주세요");
			}
		}
		String senderAddressCity = SimpleInput.input("시/군/구 를 입력해주세요.\n>> ");
		String senderAddressStreetAddress = SimpleInput.input("나머지 주소를 입력해주세요.\n>> ");
		String senderAddressZipPostalCode = SimpleInput.input("우편번호를 입력해주세요.\n>> ");
		String senderNumber = SimpleInput.input("연락처를 입력해주세요.\n>> ");


		// 받는 분 정보 입력
		String recipientName;
		while (true) {
			recipientName = SimpleInput.input(
				"받는 분 - 받으시는 고객님의 정보를 정확히 입력해 주세요.\n이름을 입력해주세요. (10자 이하)\n>> ");
			if (recipientName.length() <= 10) {
				break;
			} else {
				System.out.println("이름은 10자 이하로 적어주세요");
			}
		}

		TrackingNumber locals1 = null;
		TrackingNumber recipientAddressStateProvinceRegion;
		while (true) {
			String local1 = SimpleInput.input(
				"주소 - 보내시는 고객님의 주소를 정확히 입력해 주세요.\n광역시/도 를 입력해주세요 ex) 서울, Seoul\n>> ");
			try {
				for (TrackingNumber m : TrackingNumber.values()) {
					if (m.getNames().contains(local1.toUpperCase())) {
						locals1 = m;
					}
				}
				TrackingNumber v2 = TrackingNumber.valueOf(String.valueOf(locals1));

				if (v2 == locals1) {
					recipientAddressStateProvinceRegion = locals1;
					break;
				} else {
					System.out.println("정확한 지역명을 입력해주세요!");
				}
			} catch (Exception e) {
				System.out.println("정확한 지역명을 입력해주세요");
			}
		}
		String RecipientAddressCity = SimpleInput.input("시/군/구 를 입력해주세요.\n>> ");
		String RecipientAddressStreetAddress = SimpleInput.input("나머지 주소를 입력해주세요.\n>> ");
		String RecipientAddressZipPostalCode = SimpleInput.input("우편번호를 입력해주세요.\n>> ");
		;
		String RecipientNumber = SimpleInput.input("연락처를 입력해주세요.\n>> ");

		// 보내는 상품 정보 입력
		String productName = SimpleInput.input("상품 정보 - 상품 정보를 정확히 입력해 주세요.\n상품명 입력해주세요.\n>> ");
		int productValue = Integer.parseInt(SimpleInput.input("상품가격을 입력해주세요\n>> "));
		String productSize = SimpleInput.input("상품 크기를 입력해주세요.");

		System.out.println("입력하신 정보가 맞는지 확인해주세요.");
		System.out.println("보내는 분 -");
		System.out.printf("%s\n%s %s %s %s\n%s\n",
			senderName,
			senderAddressStateProvinceRegion, senderAddressCity, senderAddressStreetAddress,
			senderAddressZipPostalCode,
			senderNumber);

		System.out.println("받는 분 -");
		System.out.printf("%s\n%s %s %s %s\n%s\n",
			recipientName,
			recipientAddressStateProvinceRegion, RecipientAddressCity,
			RecipientAddressStreetAddress, RecipientAddressZipPostalCode,
			RecipientNumber);

		System.out.println("상품 정보 -");
		System.out.printf("%s | %s | %s\n", productName, productValue, productSize);

		String selectExit = SimpleInput.input(
			"입력하신 정보대로 택배를 접수하시겠습니까?\n1. 예 2.아니오 번호를 선택해주세요.\n>> ");

		if (selectExit.toUpperCase().contains("1")) {
			System.out.println("택배가 접수되었습니다.");
			// 보내는 분
			SenderAddress newsenderaddress = new SenderAddress(senderAddressStateProvinceRegion,
				senderAddressCity, senderAddressStreetAddress, senderAddressZipPostalCode);
			Sender newsender = new Sender(senderName, newsenderaddress, senderNumber);

			// 받는 분
			RecipientAddress newrecipientAddress = new RecipientAddress(
				recipientAddressStateProvinceRegion, RecipientAddressCity,
				RecipientAddressStreetAddress, RecipientAddressZipPostalCode);
			Recipient newrecipient = new Recipient(recipientName, newrecipientAddress,
				RecipientNumber);

			// 상품 정보
			ProductInfo newproductinfo = new ProductInfo(productName, productValue, productSize);

			// 운송장번호
			// 보내는 분 지역번호 3자리
			String SenderLocalNumber = locals.getCode();
			// 받는 분 지역번호 3자리
			String RecipientLocalNumber = locals1.getCode();
			// 남은 뒷자리 4자리는 배열에 남은 택배길이
			String lastNumber = String.format("%04d", repository.getParcelArray().length + 1);

			// 최종 운송장 번호
			String Number = SenderLocalNumber.concat(RecipientLocalNumber).concat(lastNumber);
			Parcel newParcel = new Parcel(Number, newsender, newrecipient, newproductinfo, "접수완료",
				1000);
			// 생성된 개체를 배열에 저장
			repository.addParcelInformation(newParcel);
		}
	}

	private void selectParcelByCustomer() {
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
