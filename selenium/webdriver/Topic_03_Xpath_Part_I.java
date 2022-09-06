package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_03_Xpath_Part_I {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void Register_01_Empty_Data() {
		
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='field_btn']/button")).click();
		
		// Verify (Actual Data = Expected data)
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	}

	@Test
	public void Register_02_Invalid_Email() {
		
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("John Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("123@345@788");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@345@788");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0987654321");
		driver.findElement(By.xpath("//div[@class='field_btn']/button")).click();
		
		// Verify (Actual Data = Expected data)
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Email nhập lại không đúng");
		
	}
	
	@Test
	public void Register_03_Incorrect_Confirm_Email() {
		
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='field_btn']/button")).click();
		
		// Verify (Actual Data = Expected data)
		//Assert.assertEquals(driver.findElements(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	}
	
	@Test
	public void Register_04_Password_Less_Than_6_Chars() {
		
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='field_btn']/button")).click();
		
		// Verify (Actual Data = Expected data)
		//Assert.assertEquals(driver.findElements(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	}

	@Test
	public void Register_05_Incorrect_Confirm_Password() {
		
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='field_btn']/button")).click();
		
		// Verify (Actual Data = Expected data)
		//Assert.assertEquals(driver.findElements(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	}
	
	@Test
	public void Register_06_Invalid_Phone_Number() {
		
		//Action
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='field_btn']/button")).click();
		
		// Verify (Actual Data = Expected data)
		//Assert.assertEquals(driver.findElements(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
