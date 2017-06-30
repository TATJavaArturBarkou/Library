package by.epam.barkou.main;

import by.epam.barkou.controller.Controller;

public class Main {

	public static void main(String[] args) {

	    String request = "add_book&Alice in Wonderland";
	

		  Controller controller = new Controller();
		  controller.executeTask(request);
		
		
		
	}

}
