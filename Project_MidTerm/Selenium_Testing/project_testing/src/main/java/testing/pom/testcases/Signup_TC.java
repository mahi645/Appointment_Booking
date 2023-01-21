package testing.pom.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testing.pom.pages.LoginPage;
import testing.pom.pages.SignupPage;

public class Signup_TC {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\diver\\chrome\\chromedriver.exe");
		WebDriver obj=new ChromeDriver();
		obj.get("http://localhost:3000/signup");
		
		SignupPage signup=new SignupPage(obj);
		signup.enterName("Ahalya singh");
		signup.enterUserName("ahalya");
		
		signup.enterPassword("anu123");
		signup.enterEmail("ahalya@gmail.com");
		signup.clickSignup();
		
		Thread.sleep(3000);
		System.out.println("Dashboard is being displayed");
		
		

	}

}
