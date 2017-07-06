package by.epam.barkou.main;

import by.epam.barkou.controller.Controller;

public class Main {

	public static void main(String[] args) {

	/*	String request = "sign_up&barkou@mail.ru&password";
		Controller controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));*/
		
		String request = "sign_in&barkou@mail.ru2&password2";
		Controller controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));

		
		 request = "set_user_banned&1&1";
		 controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));

	}
	
}
