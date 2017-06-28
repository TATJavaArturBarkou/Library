package common;

import users.Guest.CurrentAction;

public interface IConsoleIOActions {
	public void inputData();

	public void showAvailableActions();

	public void performAction();

	public void setCurrentAction(CurrentAction action);

	boolean checkInputAndChangeAction(String command);
}
