package by.epam.barkou.controller.command;

import by.epam.barkou.controller.exception.ControllerException;

public abstract class Command {

	private final int ACCESS_LEVEL = 0;
	protected final String SPLITTER = "&";
	public abstract int getAccessLevel();

	public abstract String execute(String request) throws ControllerException;
}
