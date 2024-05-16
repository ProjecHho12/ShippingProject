package com.hoho.shipping;

import com.hoho.shipping.loop.AppConfig;
import com.hoho.shipping.loop.MainViewImpl;

/**
 * packageName    : main.loop fileName       : Main author         : hoho date           : 4/25/24
 * description    :
 */
public class Main {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		MainViewImpl mainView = appConfig.view();
		mainView.run();
	}
}
