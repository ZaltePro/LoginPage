package PageObject.Settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Common.Base;
import Utilitys.AbstractComponent;

public class PageObj_Settings_RolesPage extends AbstractComponent {

	
	WebDriver driver;
	
	public PageObj_Settings_RolesPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='page-title-text']")
	WebElement rolePageTitle;
	
	@FindBy(xpath = "//button[@nztype='primary']")
	WebElement addRoleBtn;
	
	@FindBy(xpath = "//div[@class='d-flex drawer-title']")
	WebElement addRolesPageHeaderText;
	
	@FindBy(xpath = "//form//div[1]/div[1]//div[@role='alert']")
	WebElement roleNameValidationText;
	
	@FindBy(xpath = "//form//div[2]/div[1]//div[@role='alert']")
	WebElement roleDescriptionValidationText;
	
	@FindBy(xpath = "//div[@class='ant-drawer-footer ng-star-inserted']//button[1]")
	WebElement addRolesBtn;
	
	@FindBy(xpath = "//input[@name='roleName']")
	WebElement enterRoleName;
	
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement enterDescription;
	
	@FindBy(xpath = "//table[@tablelayout='fixed']//tbody//tr[2]//td[1]")
	WebElement getFirstRoleNameFromRolePage;
	
	@FindBy(xpath = "//input[@placeholder='Search here...']")
	WebElement searchBar;
	
	@FindBy(xpath = "//table[@tablelayout='fixed']//tbody//tr[2]//td[4]//img[@alt='edit']")
	WebElement updateFirstRoleFromSearch;
	
	
	public void AddRoles() throws InterruptedException
	{
		ClickSettingButton();
		
		addRoleBtn.click();
		
		addRolesBtn.click();
		
		Roles_FieldValidationAssert();
		
		enterRoleName.sendKeys("");
		
		enterDescription.sendKeys("");
		
		addRolesBtn.click();
		
		//Search roles which created
		searchBar.sendKeys(Base.roleName);
		Thread.sleep(5000);
		
		Assert.assertEquals(getFirstRoleNameFromRolePage.getText().trim(), Base.roleName);
		
	}
	
	public void Update_Roles() throws InterruptedException
	{
		ClickSettingButton();
		
		searchBar.sendKeys(Base.roleName);
		Thread.sleep(5000);
		
		updateFirstRoleFromSearch.click();
		
		//Header Text
		Assert.assertEquals(" Edit Role", addRolesPageHeaderText.getText().trim());
		
		addRolesBtn.click();
		
	}
	
	public void RolesListPage()
	{
		ClickSettingButton();
		
		Assert.assertEquals("Roles", rolePageTitle.getText().trim());
		
		String expectedRolesNameList ="Finance Lead,Finance Reviewer,Finance Preparer,Report Viewer,Admin";
		
		List<WebElement> xpath = driver.findElements(By.xpath("//table[@tablelayout='fixed']//tbody//tr[@_ngcontent-wnj-c213]"));
		xpath.size();
		
		for(int i=1;i<=xpath.size();i++)
		{	
			int count_TableNumber =i+1;
			String rolesNameList = driver.findElement(By.xpath("//table[@tablelayout='fixed']//tbody//tr["+count_TableNumber+"]//td[1]")).getText().trim();
			
			String[] rolesCheck = expectedRolesNameList.split(",");
			
			for (String word : rolesCheck) 
			{
				Assert.assertEquals(rolesNameList, word);
	        }
			
		}
	}
	
//	public void Roles_Status()
	{
		
	}
	
//	public void Roles_Delete()
	{
		
	}

//	public void Mandatory_Roles()
	{
		
	}

	public void Roles_FieldValidationAssert()
	{
		//Header Text
		Assert.assertEquals("Add New Role", addRolesPageHeaderText.getText().trim());
		
		//Role Name Validation message
		Assert.assertEquals("Please enter role name", roleNameValidationText.getText().trim());
		
		//Role Description Validation message
		Assert.assertEquals("Please enter role name", roleDescriptionValidationText.getText().trim());
		
		
	}
}
