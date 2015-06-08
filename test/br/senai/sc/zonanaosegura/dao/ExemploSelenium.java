package br.senai.sc.zonanaosegura.dao;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExemploSelenium {
	//private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	//	driver = new FirefoxDriver();
		baseUrl = "http://www.somatematica.com.br/";
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testJunitTesteAdicaoSelenium3() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	//	driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			//fail(verificationErrorString);
		}
	}

	//private boolean isElementPresent(By by) {
	//	try {
		//	driver.findElement(by);
	//		return true;
	//	} catch (NoSuchElementException e) {
			//return false;
	//	}
	//}

	//private boolean isAlertPresent() {
		//try {
			//driver.switchTo().alert();
		//	return true;
		//} catch (NoAlertPresentException e) {
		//	return false;
		//}
	//}

	private String closeAlertAndGetItsText() {
		try {
			//Alert alert = driver.switchTo().alert();
			//String alertText = alert.getText();
			if (acceptNextAlert) {
				//alert.accept();
			} else {
				//alert.dismiss();
			}
			//return alertText;
			return "";
		} finally {
			acceptNextAlert = true;
		}
	}
}