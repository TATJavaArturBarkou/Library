package by.epam.barkou.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.barkou.controller.command.impl.AddBook;
import by.epam.barkou.controller.command.impl.Register;
import by.epam.barkou.controller.command.impl.SignIn;
import by.epam.barkou.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repositiry = new HashMap<CommandName, Command>();

	public CommandProvider() {
		repositiry.put(CommandName.SIGN_IN, new SignIn());
		repositiry.put(CommandName.REGISTRATION, new Register());
		repositiry.put(CommandName.ADD_BOOK, new AddBook());
		repositiry.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repositiry.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repositiry.get(CommandName.WRONG_REQUEST);
		}

		return command;
	}
}
