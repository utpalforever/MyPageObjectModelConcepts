package freeCrm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freeCrm.base.BaseClassTest;

public class ContactsPage extends BaseClassTest {

	//Page Factory/Object Repository
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
