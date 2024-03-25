package PageObject;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilitys.AbstractComponent;

public class PageObj_ProfilePage extends AbstractComponent {

	WebDriver driver;
	
	public PageObj_ProfilePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='user-picture']")
	WebElement profileBtn;
	
	@FindBy(xpath = "//div[@class='d-flex drawer-text']")
	WebElement profileHeaderText;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement getUserName;
	
	@FindBy(xpath = "//div//button//span[contains(text(), 'Update')]")
	WebElement updateButton;
	
	@FindBy (xpath = "//div[@class='ant-message']/nz-message//div[2]//span[1]")
	WebElement inforMessage;
	
	@FindBy (xpath = "//span[@class='text-email']")
	WebElement updatedProfileName;
	
	
	public void UpdateProfile() throws InterruptedException
	{
		profileBtn.click();
				
		Assert.assertEquals(profileHeaderText.getText().trim(), "My Profile");
		
		getUserName.clear();
		getUserName.sendKeys("HimanshuR");
		
		updateButton.click();
		
		Thread.sleep(2000);
		
		assertEquals("HimanshuR", updatedProfileName.getText());
		
		
	}
	
	
}
