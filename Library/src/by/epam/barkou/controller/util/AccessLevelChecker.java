package by.epam.barkou.controller.util;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;

public class AccessLevelChecker {

	public static boolean checkAccessLevel(Command executionCommand) {
		if (executionCommand.getAccessLevel() > 0) {

			return checkAuthorization(executionCommand);

		} else {
			return true;

		}

	}

	public static boolean checkAuthorization(Command executionCommand) {

		if (!Controller.authorized_users.isEmpty()) {
			if (Controller.authorized_users.get(0).getRole() >= executionCommand.getAccessLevel()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	public static boolean checkUserIsYouAre(User user) {
		return Controller.authorized_users.get(0).getEmail().equals(user.getEmail());
	}

}
