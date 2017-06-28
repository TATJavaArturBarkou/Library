package users;

import common.IConsoleIOActions;
import scanner.SingleWordInput;

public class Guest implements IConsoleIOActions {

	CurrentAction currentAction;

	public enum CurrentAction {
		SIGNIN, SIGNUP, EXIT;
	};

	@Override
	public void setCurrentAction(CurrentAction action) {
		currentAction = action;
	}

	@Override
	public void showAvailableActions() {

		System.out.println("Available options are:");

		int counterForOutput = 1;
		for (CurrentAction ca : CurrentAction.values()) {

			System.out.println(counterForOutput + ". " + ca.toString());
			counterForOutput++;
		}

	}

	public boolean checkInputAndChangeAction(String command) {

		switch (command) {
		case "1":
			this.setCurrentAction(CurrentAction.SIGNIN);
			System.out.println("I am in SIGNIN case");
			return true;

		case "2":
			this.setCurrentAction(CurrentAction.SIGNUP);
			System.out.println("I am in SIGNUP case");
			return true;

		case "3":
			this.setCurrentAction(CurrentAction.EXIT);
			System.out.println("I am in EXIT case");
			return true;

		}
		return false;

	}

	@Override
	public void performAction() {

	}

	@Override
	public void inputData() {

		SingleWordInput swi = new SingleWordInput();
		swi.askForCommand(this);

	}

}
