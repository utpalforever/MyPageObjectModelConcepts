package freeCrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freeCrm.base.BaseClassTest;

public class HomePage extends BaseClassTest {

	// Page Factory

	@FindBy(xpath = "//span[text()='Calendar']")
	WebElement calendarLink;

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//span[text()='Companies']")
	WebElement companiesLink;

	@FindBy(xpath = "//span[text()='Utpal Shivam']")
	WebElement userNameText;

	// Initialization of Objects or Page Factory
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);

	}
	// Actions

	public String validateHomePageTitle() {
		
		return driver.getTitle();

	}
	
   public boolean validatecalendarLink() {
		
		return calendarLink.isDisplayed();
	}
   
   public boolean validatecontactsLink() {
		
		return contactsLink.isDisplayed();
	}
   
   public boolean validatecompaniesLink() {
		
		return companiesLink.isDisplayed();
	}
   
   public boolean validateuserNameText() {
		
		return userNameText.isDisplayed();
	}
   
   public CalenderPage clickOnCalendarLink() throws IOException {
	   
	   calendarLink.click();
	   
	   return new CalenderPage();
	   
	   
   }
   
	
	public ContactsPage clickOnContactsLink() throws IOException {
	 
	  contactsLink.click();
	 
	  return new ContactsPage();
			  
	 
	  }
	 

	
	

}