package scanner;

import java.util.Scanner;

import common.IConsoleIOActions;


public class SingleWordInput {
	protected Scanner scanner = ScannerContainer.getScanner();
	protected String command = "";
	IConsoleIOActions iConsoleIOActions;
	
	final String ENTER_NUMBER_MESSAGE = "Type a name of a required operation exactly as specified above e.g. 'EXIT':";

	public void askForCommand(IConsoleIOActions object) {
		
		iConsoleIOActions = object;
		
		while(!object.checkAndPerformInputedCommand(command)){
			
			
		System.out.println(ENTER_NUMBER_MESSAGE);
		command = scanner.next();
			
		}
		
	
		
	}
}
