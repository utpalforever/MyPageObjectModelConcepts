package freeCrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freeCrm.base.BaseClassTest;

public class ContactsPage extends BaseClassTest {

	//Page Factory/Object Repository
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;

	@FindBy(xpath="//a//button[@class='ui linkedin button']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstNameField;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middleNameField;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastNameField;
	
	@FindBy(xpath="//input[@placeholder='Street Address' and @name='address']")
	WebElement addressField;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	
	//initialization of Page factory
	
	public ContactsPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean validateContactsPageLabel() {
		
		return contactsLabel.isDisplayed();
	}
	
	public void checkboxContactsByName(String name) {
		
		//-----//table[contains(@class,'ui celled sortable')]//tbody//tr//td[text()='test1 auto']
		driver.findElement(By.xpath("//table[contains(@class,'ui celled sortable')]//tbody//tr//td[text()='"+name+"']")).click();;
		
	}
	
	public void createNewContact(String firstName, String middleName, String lastName, String address) throws InterruptedException {
		
		newButton.click();
		firstNameField.sendKeys(firstName);
		middleNameField.sendKeys(middleName);
		lastNameField.sendKeys(lastName);
		addressField.sendKeys(address);
		
		Actions action=new Actions(driver);
		action.moveToElement(saveButton).build().perform();
		Thread.sleep(2000);
		action.moveToElement(saveButton).click().build().perform();
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
