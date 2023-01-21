package testing.pom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testing.pom.pages.HomePage;
import testing.pom.pages.LoginPage;

public class Login_TC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\diver\\chrome\\chromedriver.exe");
		WebDriver obj=new ChromeDriver();
		obj.get("http://localhost:3000/doctor/login");
		
		LoginPage login=new LoginPage(obj);
		login.enterUsername("anu123");
		login.enterPassword("anu123");
		login.clickLogin();
		
		Thread.sleep(3000);
		System.out.println("Dashboard is being displayed");
		
		
		

	}

}
