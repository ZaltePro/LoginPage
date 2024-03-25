package PageObject.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilitys.AbstractComponent;

public class PageObj_Settings_UserPage extends AbstractComponent  {
	
	WebDriver driver;
	
	public PageObj_Settings_UserPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@alt='setting']")
	WebElement settingBtn;
	
	@FindBy(xpath = "//h1[@class='page-title-text']")
	WebElement userPageTitle;
	
	@FindBy(xpath = "//button[@nztype='primary']")
	WebElement addUserBtn;
	
	@FindBy(xpath = "//div[@class='d-flex']/button[1]")
	WebElement addUserPageBtn;
	
	@FindBy(xpath = "//div[@class='d-flex drawer-title']")
	WebElement addUserPageHeaderText;
	
	@FindBy(xpath = "//form//div[1]/div[1]//div[@role='alert']")
	WebElement getNameValidationMessage;
	
	@FindBy(xpath = "//form//div[1]/div[2]//div[@role='alert']")
	WebElement getEmailValidationMessage;
	
	@FindBy(xpath = "//form//div[1]/div[3]//div[@role='alert']")
	WebElement getRoleValidationMessage;
	
	@FindBy(xpath = "//form//div[1]/div[4]//div[@role='alert']")
	WebElement getPhoneNumberValidationMessage;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement addUserNameField;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement addUserEmailField;
	
	@FindBy(xpath = "//nz-select[@name='role']/nz-select-top-control")
	WebElement addUserRolesDropDownFieldClickAction;
	
	@FindBy(xpath = "//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item[@title='Finance Lead']")
	WebElement selectRolesDropDownValue;
	
	@FindBy(xpath = "//input[@name='phoneNumber']")
	WebElement addUserPhoneNumberField;
	
	@FindBy(xpath = "//table[@tablelayout='fixed']//tbody//tr[2]//td[1]")
	WebElement getFirstUserNameFromAddUserPage;
	
	@FindBy(xpath = "//table[@tablelayout='fixed']//tbody//tr[2]//td[7]/img[@alt='delete']")
	WebElement deleteFirstCreatedUser;
	
	@FindBy(xpath = "//h4[@class='confirm-modal-title center Font-Medium ng-star-inserted']")
	WebElement getPopUpMessage;
	
	@FindBy(xpath = "//p[@class='confirm-modal-sub-title center Font-Regular ng-star-inserted']")
	WebElement getPopUpMessageDescription;
	
	@FindBy(xpath = "//div[@class='center border-none d-flex ng-star-inserted']//button/span[contains(text(),'Delete')]")
	WebElement deleteBtnForDeletePopup;
	
	@FindBy(xpath = "//table[@tablelayout='fixed']//tbody//tr[2]//td[6]//button[@type='button']")
	WebElement statusToogleBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search here...']")
	WebElement searchBar;
	
	
	public void AddUser(String name, String email, String role, String phoneNumber) throws InterruptedException
	{
		ClickSettingButton();
		
		Assert.assertEquals("Users", userPageTitle.getText().trim());
		
		addUserBtn.click();
		
		addUserPageBtn.click();
		
		FieldValidationAssert();
		
		addUserNameField.sendKeys(name);
		addUserEmailField.sendKeys(email);
		
		addUserRolesDropDownFieldClickAction.click();
		Thread.sleep(1000);
		selectRolesDropDownValue.click();
		
	//	Select select = new Select(addUserRolesDropDownField);
//		select.selectByVisibleText(role);
		
		//div[@class='cdk-virtual-scroll-content-wrapper']/nz-option-item[@title='Finance Lead']
		
		addUserPhoneNumberField.sendKeys(phoneNumber);
		
		addUserPageBtn.click();
	}
	
	
	public void AssertsUserInTheListPage(String expectedName)
	{
		Assert.assertEquals(getFirstUserNameFromAddUserPage.getText().trim(), expectedName);
	}
	
	public void DeleteUser(String headingMessage, String headingDescription, String deletedUserName) throws InterruptedException
	{
		deleteFirstCreatedUser.click();
		
		Assert.assertEquals(getPopUpMessage.getText().trim(), headingMessage);
		
		Assert.assertEquals(getPopUpMessageDescription.getText().trim(), headingDescription);
		
		deleteBtnForDeletePopup.click();
		Thread.sleep(5000);
		Assert.assertNotSame(getFirstUserNameFromAddUserPage.getText().trim(), deletedUserName, "User is not able to deleting properly");
		
	}
	
	public void UserPage_StatusBar() throws InterruptedException
	{
		statusToogleBtn.click();
		Thread.sleep(5000);
	}
	
	public void UserPage_SearchAndFilter(String userName) throws InterruptedException
	{
		searchBar.sendKeys(userName);
		Thread.sleep(5000);
	//	waitForElementToAppear(By.xpath("//table[@tablelayout='fixed']//tbody//tr[2]//td[1]"));
		Assert.assertEquals(getFirstUserNameFromAddUserPage.getText().trim(), userName);
	}
	
	
	
	public void ClickSettingButton()
	{
		settingBtn.click();
	}
	
	public void FieldValidationAssert()
	{
		//Header Text
		Assert.assertEquals("Add User", addUserPageHeaderText.getText().trim());
		
		//Name Field Validation
		Assert.assertEquals("Please enter name", getNameValidationMessage.getText().trim());
		
		//Email Field Validation
		Assert.assertEquals("Please enter email address", getEmailValidationMessage.getText().trim());
		
		//Role Field Validation
		Assert.assertEquals("Please select role", getRoleValidationMessage.getText().trim());
		
		//Phone Number Field Validation
		Assert.assertEquals("Please enter phone number", getPhoneNumberValidationMessage.getText().trim());
	}
	
	
	
	
	

}
