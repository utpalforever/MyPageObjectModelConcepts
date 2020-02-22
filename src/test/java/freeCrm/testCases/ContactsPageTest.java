package freeCrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freeCrm.base.BaseClassTest;
import freeCrm.pages.CalenderPage;
import freeCrm.pages.ContactsPage;
import freeCrm.pages.HomePage;
import freeCrm.pages.LoginPage;
import freeCrm.utility.ExcelSheetUtility;
import freeCrm.utility.TestUtilClass;

public class ContactsPageTest extends BaseClassTest {

	CalenderPage calendarPage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtilClass testUtilClass;
	ContactsPage contactspage;

	public ContactsPageTest() throws IOException {
		super();
	}

	//push
	@BeforeMethod
	public void setUp() throws IOException {
		init();
		testUtilClass = new TestUtilClass();
		calendarPage = new CalenderPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();

	}

	@Test(priority = 1)

	public void validateContactsPageLabelTest() {
		boolean contactsLabel = contactspage.validateContactsPageLabel();
		Assert.assertTrue(contactsLabel, "Contacts label is not matching");

	}

	@Test(priority = 2)
	public void checkboxContactsByNameTest() {
		contactspage.checkboxContactsByName("testvg auto");

	}

	@Test(priority = 3)
	public void createNewContactTest() throws InterruptedException  {

		contactspage.createNewContact("raja", "rani", "sheela", "chhatri palace");
	}

	@DataProvider
	public Object[][] getDataCreateContacts() {
		Object[][] data = ExcelSheetUtility.getTestData("createContacts");
		return data;

	}

	@Test(priority = 4, dataProvider = "getDataCreateContacts")
	public void createNewContactDataProviderTest(String fName, String mName, String lName, String add)
			throws InterruptedException {

		contactspage.createNewContact(fName, mName, lName, add);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
