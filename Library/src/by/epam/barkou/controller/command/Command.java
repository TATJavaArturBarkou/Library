package by.epam.barkou.controller.command;

import by.epam.barkou.controller.exception.ControllerException;

public abstract class Command {

	int accessLevel;

	public abstract int getAccessLevel();

	public abstract void setAccessLevel(int accessLevel);

	public abstract String execute(String request) throws ControllerException;
}
