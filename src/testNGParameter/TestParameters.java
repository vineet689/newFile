package testNGParameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameters {
	
	@Parameters({ "browser"})
	@Test
	public void testCaseOne(String browser){
		System.out.println("browser passed as : " +browser);
		
	}
	@Parameters({ "username", "password" })
	@Test
	public void testCaseTwo(String username, String password){
		System.out.println("Parameter for username passed as : " +username);
		System.out.println("Parameter for password passed as : " +password);
	}

}
