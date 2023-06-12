package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://shop.aemi.vn/menu_category/MUR");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		String Url = driver.getCurrentUrl();
		String Xpath1 =  "//div[@id='product-list']";
		WebElement lisItem = driver.findElement(By.xpath(Xpath1));
//		System.out.println("So phan tu trong trang la" + lisItem.);
		String xuatMang[]= {};
		
//		for (int i=1; i<int(n); i++) {
//			String temp = driver.findElement(By.xpath("//div[@id='product-list']/div[i]")).getText();
//			
//		}
//		Assert.assertEquals(Url, "https://shop.aemi.vn/menu_category/MUR");
		
		
	}

//	@Test
//	public void TC_02_ValidatePageTitle() {
//		// Login Page title
//		String loginPageTitle = driver.getTitle();
//		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
//	}
//
//	@Test
//	public void TC_03_LoginFormDisplayed() {
//		// Login form displayed
//		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
//	}

	private void print(Dimension size) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
