package testing.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
	WebDriver driver;
	public SignupPage(WebDriver driver) {
		super();
		this.driver=driver;
	}
	By name=By.xpath("//*[@id=\"outer\"]/div[1]/input");
	By username=By.xpath("//*[@id=\"outer\"]/div[2]/input");
	By password=By.xpath("//*[@id=\"outer\"]/div[3]/input");
	By email=By.xpath("//*[@id=\"outer\"]/div[4]/input");
	By signup=By.xpath("//*[@id=\"login-submit\"]");
	public void enterName(String user) {
		driver.findElement(name).sendKeys(user);
		
	}
	public void enterUserName(String username1) {
		driver.findElement(username).sendKeys(username1);
		
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
		
	}
	public void clickSignup() {
		driver.findElement(signup).click();
	}

}
