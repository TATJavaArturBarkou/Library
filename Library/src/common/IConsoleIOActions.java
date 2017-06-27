package common;

public interface IConsoleIOActions {
	void inputData();
	boolean checkData();
	boolean checkInputIsValid();
	
	void showAvailableActions();
	String changeAction();
	void performAction(String command);
	
}
