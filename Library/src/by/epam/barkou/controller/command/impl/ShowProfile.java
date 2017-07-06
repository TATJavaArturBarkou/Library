package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;


public class ShowProfile extends Command {
	User user;
	public int accessLevel = 1;

	String response = null;

	@Override
	public String execute(String request) throws ControllerException {

		user = Controller.authorized_users.get(0);
		return user.getEmail();

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
