package freeCrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import freeCrm.base.BaseClassTest;
import freeCrm.pages.CalenderPage;
import freeCrm.pages.ContactsPage;
import freeCrm.pages.HomePage;
import freeCrm.pages.LoginPage;
import freeCrm.utility.TestUtilClass;

public class HomePageTest extends BaseClassTest {

	CalenderPage calendarPage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtilClass testUtilClass;
	ContactsPage contactspage;
	public HomePageTest() throws IOException {
		super();
		
	}

@BeforeMethod
	//push
	public void setUp() throws IOException {
		init();
		testUtilClass=new TestUtilClass();
		calendarPage=new CalenderPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle=homepage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "HomePage Title not matched");
	}
	
	@Test(priority=2)
	public void userNameTextTest() {
		//testUtilClass.switchToFrame();
		Assert.assertTrue(homepage.validateuserNameText());
		
	}
	
	
	@Test(priority=3)
	public void calendarLinkTest() {
		//testUtilClass.switchToFrame();
		Assert.assertTrue(homepage.validatecompaniesLink());
		
	}
	@Test(priority=4)
	public void clickOncontactsLinkTest() throws IOException {
		//testUtilClass.switchToFrame();
		contactspage=homepage.clickOnContactsLink(); 
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
