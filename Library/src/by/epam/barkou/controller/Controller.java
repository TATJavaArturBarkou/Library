package by.epam.barkou.controller;

import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.command.CommandProvider;

public class Controller {

	private final char paramDelimert='&';
	private final CommandProvider provider = new CommandProvider();
	
	public String executeTask(String request){
		
		String command;
		command = request.substring(0,request.indexOf(paramDelimert));
		
		String response=null;

		Command executionCommand = provider.getCommand(command);
		
		response = executionCommand.execute(request);
		
		return response;
		
	}
	
	
}
