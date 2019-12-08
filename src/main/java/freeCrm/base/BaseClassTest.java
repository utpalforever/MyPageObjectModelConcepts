package freeCrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import freeCrm.utility.TestUtilClass;

public class BaseClassTest {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClassTest() throws IOException  {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"E:\\Prep\\POM_Approach\\src\\main\\java\\freeCrm\\propertiesFile\\configurations.properties");
		prop.load(ip);
	}

	public static void init() {

		String browser = prop.getProperty("driver");

		if (browser.equals("chrome")) {

			// chrome
			System.setProperty("webdriver.chrome.driver",
					"E:\\Shiv@1008\\SeleniumBackEnd\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equals("FF")) {

			// firefox
			System.setProperty("webdriver.gecko.driver",
					"E:\\Shiv@1008\\SeleniumBackEnd\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		   
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtilClass.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilClass.implicitlyWait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
