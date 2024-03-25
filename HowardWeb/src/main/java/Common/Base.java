package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import PageObject.PageObj_LoginPage;
import Utilitys.AbstractComponent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	public PageObj_LoginPage LoginObj;
	
	public static final String userName = "zaltehimanshu2007@gmail.com";
	public static final String password = "Satva1213#";
	
	public static final String addUserName = "AutomationUser";
	public static final String addEmail = "Admin22@gmail.com";
	public static final String addRole = "Finance Lead";
	public static final String addPhoneNumber = "9595959595";
	
	public static final String deletePopupHeadingMessage = "Are You Sure?";
	public static final String deletePopupHeadingDescription = "Once this is deleted, it cannot be recovered.";
	
	
	//Roles Data
	public static final String roleName = "Automation Admin";
	public static final String roleDescription = "Automation Admin";
	
	
	
	public WebDriver initializeDriver(boolean headlessMode)
	{
		ChromeOptions option = new ChromeOptions();
		
		option.setAcceptInsecureCerts(true);
		
		WebDriverManager.chromedriver().setup();
		
		 // Set other desired Chrome options here
	    option.setAcceptInsecureCerts(true);

	    if (headlessMode) {
	        option.setHeadless(true);
	    }
		
		driver = new ChromeDriver(option);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	public void DataBaseConnection() throws SQLException
	{
		String connection = "jdbc:sqlserver://db.satva.solutions:59763;database=Howard_Staging;user=sa;password=Fishy1213#;integratedSecurity=false;";
		Connection con = DriverManager.getConnection(connection);
		
		Statement st = con.createStatement();
		String sqlStr = "SELECT * FROM [dbo].[Group]";
		ResultSet rs = st.executeQuery(sqlStr);
		while (rs.next()) {
			System.out.println(rs.getString("GroupName"));
		}
		
		
	}
	
	@BeforeMethod
	public PageObj_LoginPage launchApplication()
	{
		driver = initializeDriver(false);
		
		LoginObj = new PageObj_LoginPage(driver);
		LoginObj.goTO();
		return LoginObj;
		
	}
	
	@AfterMethod
	public void tearDown()//ITestResult result
	{
//		if(ITestResult.FAILURE==result.getStatus())
//		{
//			AbstractComponent.captureSreenshot(driver, result.getName());
//		}
		
		driver.quit();
	}

}
