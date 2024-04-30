package customer;

import loop.Controller;
import loop.Repository;

public class CustomerControllerImpl implements Controller {

	private final Repository cr;

	public CustomerControllerImpl(Repository customerRepository) {
		this.cr = customerRepository;
	}
	@Override
	public int register(String name, String email, String password, String gender, String address,
		String age) {
		return 0;
	}

	@Override
	public LoginStatus login(String email, String password) {
		if (cr.checkId(email)) {
//			String inputPassword = SimpleInput.input("- 비밀번호: ");
//                back();
			if (password.equals("0"))
				return LoginStatus.PASSSFAIL;
			if (cr.checkPassword(email, password)) {
				return LoginStatus.SUCCESS;
			} else {
				return LoginStatus.PASSSFAIL;
			}
		}
		return LoginStatus.IDFAIL;
	}
}
