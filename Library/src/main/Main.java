package main;

import users.Guest;
import users.Guest.CurrentAction;;

public class Main {

	public static void main(String[] args) {

		Guest guest = new Guest();
		guest.showAvailableActions();
		// sign in or sign up
		guest.inputData();

		if (guest.checkInputIsValid()) {
			guest.changeAction();
		}

		guest.showAvailableActions();

		guest.checkData();

		guest.showAvailableActions();

		guest.checkData();
		guest.performAction(null);
	}

}
