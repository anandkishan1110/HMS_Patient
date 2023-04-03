package JaiHind;

import org.testng.annotations.Test;

public class ParameterTest {
  @Test
  public void test()
  {
	 String URL = System.getProperty("url");
	 String ENV = System.getProperty("Env");
	 String Browser = System.getProperty("browser");
	 String PASSWORD=System.getProperty("password");
	 String USERNAME=System.getProperty("username");
	 System.out.println(URL);
	 System.out.println(ENV);
	 System.out.println(Browser);
	 System.out.println(PASSWORD);
	 System.out.println(USERNAME);
  }
}
