package scanner;

import java.util.Scanner;

import common.IConsoleIOActions;


public class SingleWordInput {
	protected Scanner scanner = ScannerContainer.getScanner();
	protected String command = "";
	IConsoleIOActions iConsoleIOActions;

	public void askForCommand(IConsoleIOActions object) {
		
		iConsoleIOActions = object;
		
		while(!object.checkInputAndChangeAction(command)){
			
			
		System.out.println("Enter a number of a required operation:");
		command = scanner.next();
			
		}
		
	
		
	}
}
