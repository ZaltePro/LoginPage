package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilitys.AbstractComponent;

public class PageObj_LoginPage extends AbstractComponent{
	
	WebDriver driver;
	
	public PageObj_LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css = "input[placeholder='Enter your Email Address']")
	WebElement userName;
	
//	@FindBy(css = "input[placeholder='Type your Password']")
//	WebElement passWord;
	//input[@type='password']
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;
	
	@FindBy(css = ".ant-btn.log-in-btn.ant-btn-primary")
	WebElement btn_Login;
	
	By loginButtonWait = By.cssSelector(".ant-btn.log-in-btn.ant-btn-primary");
	
	
	public PageObj_LoginPage loginApplication(String username, String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		waitForElementToAppear(loginButtonWait);
		btn_Login.click();
		return null;
		
	}
	
	
	public void goTO()
	{
		driver.get("http://rivulet-staging.satva.solutions/login");
	}
	
}
