package testing.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super();
		this.driver=driver;
	}
	By username=By.xpath("//*[@id=\"outer\"]/div[1]/input");
	By pwd=By.xpath("//*[@id=\"outer\"]/div[2]/input");
	By loginButton=By.xpath("//*[@id=\"login-submit\"]");
	
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
		
	}
	public void enterPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

}
