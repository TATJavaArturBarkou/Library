package main;

import users.Guest;

public class Main {

	public static void main(String[] args) {

		Guest guest = new Guest();
		guest.showAvailableActions();
		// sign in or sign up
		guest.inputData();

		guest.performAction();

/*		guest.showAvailableActions();

		guest.performAction();*/

	}

}
