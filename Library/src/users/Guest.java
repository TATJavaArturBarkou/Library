package users;

import common.IConsoleIOActions;


public class Guest implements IConsoleIOActions{

	CurrentAction currentAction;
	String inputData;
	
	public enum CurrentAction{
		SIGNIN, SIGNUP, START;
	};
	
	public void setCurrentAction(CurrentAction action) {
		currentAction = action;
	}
	
	@Override
	public void showAvailableActions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String changeAction() {
		
		//make switch
		if(inputData.equals("SIGNIN")){
			this.setCurrentAction(CurrentAction.SIGNIN);
		}
		
		
		return null;
	}

	@Override
	public void performAction(String command) {
		

		
	}

	@Override
	public void inputData() {


		
	}

	@Override
	public boolean checkData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkInputIsValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
