package by.epam.barkou.controller;

import java.util.ArrayList;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.command.CommandProvider;

public class Controller {

	private final char paramDelimert = '&';
	private final CommandProvider provider = new CommandProvider();
	public static ArrayList<User> authorized_users;
	
	public String executeTask(String request) {

		String command;
		command = request.substring(0, request.indexOf(paramDelimert));

		String response = null;

		Command executionCommand = provider.getCommand(command);

		//if (executionCommand.accessLevel == 0) {
			response = executionCommand.execute(request);

		//}
// еще один иф. Если в листе authorized_users есть юзер то проверяем что его роль больше или равна аксес левелу если нету юзера или левел меньше даем ошибку. 
		return response;

	}
}