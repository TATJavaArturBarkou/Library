package by.epam.barkou.controller.command;

public abstract class Command {
	public int accessLevel;

	public abstract String execute(String request);
}
