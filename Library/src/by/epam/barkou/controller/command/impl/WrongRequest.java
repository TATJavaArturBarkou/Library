package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.command.Command;

public class WrongRequest extends Command {

	int accessLevel = 0;

	@Override
	public String execute(String request) {
		return null;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

	@Override
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;

	}
}
