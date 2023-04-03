package JaiHind;

import org.testng.annotations.Test;

public class BharatBnd {
	@Test(groups  ="smoke")
	public void createCustomer()
	{
		System.out.println("Hindi");
	}
	@Test(groups = "regression")
	public void createCustomer1()
	{
		System.out.println("English");
	}

}
