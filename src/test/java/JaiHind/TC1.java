package JaiHind;

import org.testng.annotations.Test;

public class TC1 {
	@Test(groups = "smoke")
	public void methodData1()
	{
		System.out.println("method1");
	}
	@Test(groups = "regression")
	public void methodData2()
	{
		System.out.println("method2");
	}
	@Test(groups = {"smoke","regression"})
	public void methodData3()
	{
		System.out.println("method3");
	}



}
