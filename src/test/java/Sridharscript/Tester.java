package Sridharscript;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Tester 
{
	@Test
	public void tester()
	{
		Reporter.log("hi",true);
	}
	@Test
	public void tester1()
	{
		Reporter.log("bye",true);
	}
	@Test
	public void tester2()
	{
		Reporter.log("tata",true);
	}
	
}
