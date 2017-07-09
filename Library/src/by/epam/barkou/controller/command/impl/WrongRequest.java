package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.command.Command;

public class WrongRequest extends Command {

	private final int ACCESS_LEVEL = 0;

	@Override
	public String execute(String request) {
		return null;
	}

	@Override
	public int getAccessLevel() {
		return this.ACCESS_LEVEL;
	}

}
