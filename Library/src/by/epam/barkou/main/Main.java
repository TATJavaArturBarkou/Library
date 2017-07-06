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

		
		 request = "update_profile&barkou@mail.ru&password";
		 controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));

	}
	
}
