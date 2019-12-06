package freeCrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freeCrm.base.BaseClassTest;

public class LoginPage extends BaseClassTest{
	
	
	
	
	//Page Factory/Object Repository
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
    WebElement loginBtn;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//a[@class='brand-name']")
	WebElement crmLogo;
	
	@FindBy(linkText="Sign Up")
	WebElement signupBtn;
	
	
	
	//Initializing the object
	
    public LoginPage() throws IOException{
		
		PageFactory.initElements(driver, this);
		
		//Actions
		
	}
	public String validateLoginPageTitle() {
		
		return driver.getTitle();   
	}
	
    public boolean validateCRMlogo() {
		
		return crmLogo.isDisplayed();
	}
    
    public boolean validateSignupLink() {
		
		return crmLogo.isDisplayed();
	}
	
    public HomePage login(String un, String pwd) throws IOException {
		
    	loginBtn.click();
    	email.sendKeys(un);
    	password.sendKeys(pwd);
    	
        return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
