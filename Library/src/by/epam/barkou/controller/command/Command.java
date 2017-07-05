package by.epam.barkou.controller.command;

import by.epam.barkou.controller.exception.ControllerException;

public abstract class Command {
	public int accessLevel;

	public abstract String execute(String request)throws ControllerException;
}
