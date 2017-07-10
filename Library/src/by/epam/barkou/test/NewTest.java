package by.epam.barkou.test;


import org.testng.annotations.Test;

import by.epam.barkou.controller.Controller;

import org.testng.annotations.DataProvider;

public class NewTest {


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	
      new Object[] { "add_book&Alice in Wonderland", "Book has been added successfully" },
      new Object[] { "update_book&1&Alice&1", "Book has been updated successfully" },
      new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
      new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },
      new Object[] { "get_all_available_books&", "" },
      new Object[] { "show_profile&", "" },
      new Object[] { "update_profile&barkou@mail.ru&password", "User is updated successfully" },
      new Object[] { "add_admin_rights&1", "User rights are updated successfully" },
	new Object[] { "set_user_banned&1&1", "User is updated successfully" },
    };
  }
  
  @Test(dataProvider = "dp")
  public void ControllerTest(String request, String response) {
	  Controller controller = new Controller();
	  controller.executeTask(request);
	  
  }
}
