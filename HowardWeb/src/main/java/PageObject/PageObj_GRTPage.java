package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilitys.AbstractComponent;

public class PageObj_GRTPage extends AbstractComponent {
	
	WebDriver driver;
	
	Actions mouse;
	
	public PageObj_GRTPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		this.mouse = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	String selectGroup = "Group A"; // concate later to 39 line
	
	@FindBy(xpath = "//a[@href='/rivulet/grt']")
	WebElement btn_Grt_MenuBar;
	
	@FindBy(css = ".ant-btn.medium-btn.ant-btn-primary")
	WebElement btn_CreateGRT;
	
	@FindBy(css = "input[type='text']")
	WebElement textField_NameOfTheTemplate;
	
	@FindBy(css = ".ant-select-selection-search-input.ng-pristine.ng-valid.ng-touched")
	WebElement dropdownButton_Group;
	
	@FindBy(css = "nz-option-item[title='Group A']")
	WebElement select_Group_DropDown;
	
	@FindBy(xpath = "//nz-radio-group[@formcontrolname='reportSetupOptionsType']//label[@nzvalue='2']//input[@class='ant-radio-input']")
	WebElement redioBtn_ChooseTemplate;
	
	@FindBy(xpath = "//span[normalize-space()='SAAS']")
	WebElement select_SaasTemp;
	
	@FindBy(css = "button:nth-child(2)")
	WebElement create_setupBtn;
	
	@FindBy(xpath = "//div[@id='cdk-drop-list-51']/div[1]/div[2]/span")
	WebElement profitAndLossFirstAccountName;
	
	@FindBy(xpath = "//div[@class='ant-modal-footer ng-tns-c91-19 ng-star-inserted']//button[@class='ant-btn medium-btn small-btn width-100 mr-1 ant-btn-primary']")
	WebElement saveandMapAccountBtn;
	
	@FindBy(xpath = "//div[@class='xero-account-list ng-star-inserted']//div[1]/div[1]//p")
	WebElement accountMapping;
	
	@FindBy(css = ".ant-btn.medium-btn.small-btn.width-100.mr-1.ant-btn-primary")
	WebElement updateBtn_Mapping;
	
	
	
	public PageObj_GRTPage CreateProfitAndLossReport() throws InterruptedException
	{
		btn_Grt_MenuBar.click();
		
		btn_CreateGRT.click();
		
		textField_NameOfTheTemplate.sendKeys("Profit_Loss");
		
		driver.findElement(By.cssSelector("[nzplaceholder='Select Group']")).click();
		
		elementToBeClickable(By.xpath("//div[normalize-space()='Group A']"));
		
		driver.findElement(By.xpath("//div[normalize-space()='Group A']")).click();
        
		
		redioBtn_ChooseTemplate.click();
		
		select_SaasTemp.click();
		
		create_setupBtn.click();
		return null;
	}
	
	
	public void ProfitAndLossReportTemplate()
	{
		mouse.doubleClick(profitAndLossFirstAccountName).build().perform();
		
		//Working
		
	}
	
	
	public void ClickSaveMapButton()
	{
		saveandMapAccountBtn.click();
		
	}
	
	public void GroupAccountMapping()
	{
		mouse.dragAndDrop(accountMapping, driver.findElement(By.xpath("//div[@id='cdk-drop-list-37']")));
		
		updateBtn_Mapping.click();
		
	}

}
