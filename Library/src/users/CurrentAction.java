package users;

public enum CurrentAction {

	FIRST_ENTER() {

		public void showAvailableActions() {

			System.out.println(AVAILABLE_OPTIONS_MESSAGE);

			for (int counterForOutput = 1; counterForOutput < CurrentAction.values().length; counterForOutput++) {
				System.out.println(counterForOutput + ". " + CurrentAction.values()[counterForOutput]);
			}

		}

		@Override
		public void perform() {
			// TODO Auto-generated method stub

		}
	},

	SIGNIN() {
		@Override
		public void perform() {
			System.out.println("SIGNIN");
		}

		@Override
		public void showAvailableActions() {
			System.out.println(ASK_LOGIN_MESSAGE);

			

		}
	},
	SIGNUP() {
		@Override
		public void perform() {
			System.out.println("SIGNUP");

		}

		@Override
		public void showAvailableActions() {
			System.out.println(AVAILABLE_OPTIONS_MESSAGE);

		}
	},
	EXIT() {
		@Override
		public void perform() {
			System.out.println("EXIT");

		}

		@Override
		public void showAvailableActions() {
			System.out.println(AVAILABLE_OPTIONS_MESSAGE);

		}

	};

	final String AVAILABLE_OPTIONS_MESSAGE = "Available options are:";
	final String ASK_LOGIN_MESSAGE = "Enter login:";
	public abstract void perform();

	public abstract void showAvailableActions();

};