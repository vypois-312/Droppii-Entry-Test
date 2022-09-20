package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_05_Web_Browser_Element_PI {
	// khai 
	WebDriver driver;
	WebElement element;
	
	//Khai báo + khởi 
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		
		// khởi tạo 
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Browser() {
	// Cac ham tuong tac voi Browser se thong qua bien browser
		
	// đóng tab/window đang  
	driver.close();
	
	// đóng browser
	driver.quit();
	
	
	// Tìm ra 1 element (single)
	WebElement loginButton= driver.findElement(By.cssSelector(""));
	// Tìm ra nhiều element
	List<WebElement> links = driver.findElements(By.cssSelector(""));
	
	driver.get("https://www.facebook.com/");
	// tra ve url tai page dang dung
	String gamePageUrl = driver.getCurrentUrl();
	String gamePageTitle = driver.getTitle();
	
	// source code cua page hien tai
	String gamePageSourceCode = driver.getPageSource();
	
	// Lay ra ID cua tab window dang dung
	driver.getWindowHandle();
	driver.getWindowHandles();
	driver.manage().getCookies();
	driver.manage().logs().getAvailableLogTypes();
	driver.manage().window().fullscreen();
	driver.manage().window().maximize();
	
	
	
	// Ưu tiên làm giao diện sau
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	// chờ cho pageload thành công sau xx 
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	
	// chờ cho script dc inject thành  vào browser/ment sau xx giây
	driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	driver.navigate().to("https://www.facebook.com/");
	
	//Alert/ Frame (Iframe)/ Window (tab)
	driver.switchTo().alert();
	driver.switchTo().frame(0);
	driver.switchTo().window("");
	
	}

	@Test
	public void TC_02_Element() {
	// Cac ham tuong tac voi Element se thong qua cai class webelement (bien nao do)
	
	driver.get("https://www.facebook.com/");
	
	// khai bao bien cung kieu du lieu de tra ve ham findElement
	WebElement emailAddressTextbox = driver.findElement(By.id("email"));
	emailAddressTextbox.clear();
	emailAddressTextbox.sendKeys("vypois@gmail.com");
	
	// Xoa du lieu trong 1 field dang editable ( co the nhap)
	element.clear();
	
	// Nhap du lieu vao field dang editable
	element.sendKeys("");
	element.sendKeys(Keys.ENTER);
	
	// Dung di dung lai nhieu lan it nhat la 2 lan thi moi can khai bao bien
	element.getAttribute("placeholder");
	
	// tra ve thuoc tinh css cua element nay
	// Font, Size, Color
	// tra ve mau nen cua element 
	element.getCssValue("backgroundcolor");
	// tra ve font size cua element
	element.getCssValue("font-size");
	// TestGUI: Point / Rectangle/ Size (visualize testing)
	element.getLocation();
	element.getRect();
	element.getSize();
	
	// Chup hinh va attach vao HTML report
	element.getScreenshotAs(OutputType.FILE);
	
	
	//Tra ve the HTML cua element
	WebElement emailAddressTextbox1 = driver.findElement(By.xpath("//input[@id='email']"));
	emailAddressTextbox1.getTagName();
	
	// tra ve text cua 1 element ( Link/header/ Message loi/ Message success)
	element.getText();
	
	// Tra ve gia tri dung hoac sai cua 1 element co1 hien thi hay ko
	element.isDisplayed();
	
	// Tra ve gia tri dung hoac sai co bi disable hay ko
	element.isEnabled();
	
	// Tra ve gia tri dung hoac sai cua 1 element da duoc chon roi hay chua
	// checkbox/radio/
	element.isSelected();
	
	// dropdown co 1 thu vien rieng de xu ly (select)
	
	//chi lam viec dc voi form (register/login/search)
	// Submit enter o 1 field nao do
	// submit vao 1 field nao 
	element.submit();
	
	
	
	
	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
