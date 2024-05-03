import loop.AppConfig;
import loop.MainViewImpl;

/**
 * packageName    : loop fileName       : Main author         : hoho date           : 4/25/24
 * description    :
 */
public class Main {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		MainViewImpl mainView = appConfig.view();
		mainView.run();
	}
}
