package loop;

/**
 * packageName    : loop fileName       : Main author         : hoho date           : 4/25/24
 * description    :
 */
public class Main {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		View mainView = appConfig.view();
		mainView.run();
	}
}
