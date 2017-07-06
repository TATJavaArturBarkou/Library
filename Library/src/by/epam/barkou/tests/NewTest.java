package by.epam.barkou.tests;


import org.testng.annotations.Test;

import by.epam.barkou.controller.Controller;

import org.testng.annotations.DataProvider;

public class NewTest {


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
    	
      new Object[] { "add_book&Alice in Wonderland", "" },
      
      new Object[] { "update_book&1&Alice&1", "" },
      new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
      new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },
      new Object[] { "get_all_available_books&", "" },
      new Object[] { "show_profile&", "" },
      new Object[] { "update_profile&barkou@mail.ru&password", "User is updated successfully" },

    };
  }
  
  @Test(dataProvider = "dp")
  public void ControllerTest(String request, String response) {
	  Controller controller = new Controller();
	  controller.executeTask(request);
	  
  }
}
