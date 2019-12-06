package freeCrm.utility;

import java.io.IOException;

import freeCrm.base.BaseClassTest;

public class TestUtilClass extends BaseClassTest{
	
	public TestUtilClass() throws IOException {
		
	}

	public static int pageLoadTimeout=30;
	public static int implicitlyWait=40;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
