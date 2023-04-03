package Practice;

import org.testng.annotations.Test;

public class ParameterTest {
	@Test
	public void test() {
		String url=System.getProperty("url");
		String env=System.getProperty("Env");
		String browser=System.getProperty("browser");
		String username=System.getProperty("username");
		String passward=System.getProperty("passward");
		System.out.println(url);
		System.out.println(env);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(passward);
		
		
		
		
	}

}
