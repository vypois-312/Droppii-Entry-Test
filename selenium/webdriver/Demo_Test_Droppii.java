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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class Demo_Test_Droppii{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://codechallenge.odoo.com");
		driver.findElement(By.id("login")).sendKeys("user@codechallenge.app");
		driver.findElement(By.id("password")).sendKeys("123456");

	}
	
	@Test
	public void TC_01_Successful_Login() {
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
		
		// Verify display of User drop down list from the main Dash board
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='dropdown-toggle  ']")).isDisplayed());
	}
	
	@Test
	public void TC_02_createNewProduct_updateQuantity() {
		
		//create new product
		driver.findElement(By.id("result_app_1")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@title='Products']")).click();
		driver.findElement(By.xpath("//div[@class='o-dropdown--menu dropdown-menu d-block o-popper-position o-popper-position--bs']/a[1]")).click();
		driver.findElement(By.xpath("//button[@title='Create record']")).click();
		
		Random generator = new Random(10);
		String S = generator + "Test";
		driver.findElement(By.xpath("//input[@placeholder='e.g. Cheese Burger']")).sendKeys(S);
		driver.findElement(By.xpath("//button[@title='Save record']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//button[@name='action_update_quantity_on_hand']")).isDisplayed());
		driver.findElement(By.xpath("//button[@name='action_update_quantity_on_hand']")).click();
		driver.findElement(By.xpath("//button[@name='action_update_quantity_on_hand']")).click();
		
		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		driver.findElement(By.xpath("//input[@name='inventory_quantity']")).sendKeys("10");
		driver.findElement(By.xpath("//button[@title='Save record']")).click();
		//Back to Home menu
		driver.findElement(By.xpath("//a[@title='Home menu']")).click();
		
		//Create new manufacturing order
		driver.findElement(By.id("result_app_2")).click();
		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		driver.findElement(By.xpath("//div[@name='product_id']")).click();
		
		WebElement Productname = driver.findElement(By.xpath("//div[@name='product_id']/div[@class='o_field_many2one_selection']/div[@class='o_input_dropdown']/input"));
		Productname.sendKeys(S);	
		
		// Could not catch element on drop down list so can not proceed further step below
//		driver.findElement(By.xpath("//ul[@id='ui-id-1']//a[1]")).click();
//
//		driver.findElement(By.xpath("//div[@class='o_row no-gutters d-flex']/input")).clear();
//		driver.findElement(By.xpath("//div[@class='o_row no-gutters d-flex']/input")).sendKeys("3");
//		driver.findElement(By.xpath("//button[@name='action_confirm']")).click();
//		
//		driver.findElement(By.xpath("//input[@name='qty_producing']")).clear();
//		driver.findElement(By.xpath("//input[@name='qty_producing']")).sendKeys("1");
//		driver.findElement(By.xpath("//div[@name='state']/../div[1]//button[4]")).click();
//		driver.findElement(By.xpath("//footer[@class='modal-footer']/button[1]")).click();
//		//Save the order
//		driver.findElement(By.xpath("//button[@title='Save record']")).click();
//		
//		//Verify done status
//		Assert.assertTrue(driver.findElement(By.xpath("data-value")).isEnabled());
//		//Validate the new Manufacturing Order is created with corrected information.
//		
//		String newManufactureOrder = driver.findElement(By.xpath("//span[@placeholder='Manufacturing Reference']")).getText();
//		driver.findElement(By.xpath("//a[@title='Home menu']")).click();
//		driver.findElement(By.id("result_app_2")).click();
//		Assert.assertEquals(driver.findElement(By.xpath("//table[@class='o_list_table table table-sm table-hover table-striped o_list_table_ungrouped']/tbody/tr[1]/td[@class='o_data_cell o_field_cell o_list_char o_readonly_modifier font-weight-bold']")).getText(), newManufactureOrder);
	}
	

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}