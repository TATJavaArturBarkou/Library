package users;

import common.IConsoleIOActions;
import scanner.SingleWordInput;

public class Guest implements IConsoleIOActions {

	CurrentAction currentAction = CurrentAction.FIRST_ENTER;

	public boolean checkAndPerformInputedCommand(String command) {

		try {
			currentAction = CurrentAction.valueOf(command);

			currentAction.showAvailableActions();

		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;

	}

	@Override
	public void inputData() {
		currentAction.showAvailableActions();
		SingleWordInput swi = new SingleWordInput();
		swi.askForCommand(this);

	}

}
