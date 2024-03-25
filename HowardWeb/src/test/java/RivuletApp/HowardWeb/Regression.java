package RivuletApp.HowardWeb;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Common.Base;
import PageObject.PageObj_GRTPage;
import PageObject.PageObj_LoginPage;
import PageObject.PageObj_ProfilePage;
import PageObject.Settings.PageObj_Settings_RolesPage;
import PageObject.Settings.PageObj_Settings_UserPage;

public class Regression extends Base {

	PageObj_LoginPage logingObj;
	PageObj_GRTPage grtObj;
	PageObj_ProfilePage profileObj;
	PageObj_Settings_UserPage userObj;
	PageObj_Settings_RolesPage roleObj;
	
	
	@Test (priority = 0)
	public void login() throws InterruptedException
	{
		logingObj = new PageObj_LoginPage(driver);

		logingObj.loginApplication(Base.userName, Base.password);
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class='user-picture']")).isDisplayed());
	}
	
	
	@Ignore// (priority = 1)
	public void ProfileUpdate() throws InterruptedException
	{
		login();
		
		profileObj = new PageObj_ProfilePage(driver);
		
		profileObj.UpdateProfile();
		
	}
	
	@Ignore// (priority = 1)
	public void Setting_Users() throws InterruptedException
	{
		login();
		userObj = new PageObj_Settings_UserPage(driver);
		
		userObj.AddUser(Base.addUserName, Base.addEmail, Base.addRole, Base.addPhoneNumber);
		Thread.sleep(5000);
		
		userObj.AssertsUserInTheListPage(Base.addUserName);
		
		for(int i=0;i<2;i++)
		{
			userObj.UserPage_StatusBar();
		}
		userObj.UserPage_SearchAndFilter(addUserName);
		
		userObj.DeleteUser(Base.deletePopupHeadingMessage, Base.deletePopupHeadingDescription, Base.addUserName);
		
		userObj.UserPage_SearchAndFilter(Base.addUserName);
	}
	
	
	@Ignore// (priority = 1)
	public void Setting_Roles() throws InterruptedException
	{
		login();
	//	roleObj.AddRoles();
		
	//	roleObj.Update_Roles();
		
		roleObj.RolesListPage();
		
	}
	
	@Ignore// (priority = 1)
	public void GRT() throws InterruptedException
	{
		login();
		
		grtObj = new PageObj_GRTPage(driver);
		
		grtObj.CreateProfitAndLossReport();
		
		grtObj.ClickSaveMapButton();
		
		grtObj.GroupAccountMapping();
		
	}
}