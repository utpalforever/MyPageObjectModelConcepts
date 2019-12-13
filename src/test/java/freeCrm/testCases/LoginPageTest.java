package freeCrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import freeCrm.base.BaseClassTest;
import freeCrm.pages.HomePage;
import freeCrm.pages.LoginPage;

public class LoginPageTest extends BaseClassTest {

	HomePage homepage;
	LoginPage loginpage;
	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	
	public void setUp() throws IOException {
		init();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag=loginpage.validateCRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void signUpLinkTest() {
		boolean flag=loginpage.validateSignupLink();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=4)
	public void loginTest() throws IOException {
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
