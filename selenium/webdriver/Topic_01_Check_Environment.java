package webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
	WebDriver driver;
	// Không cần projectPath và osName ở đây nữa nếu dùng đường dẫn tuyệt đối
	// String projectPath = System.getProperty("user.dir");
	// String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		// Đường dẫn tuyệt đối đến thư mục browserDrivers của bạn
		// Dựa trên hình ảnh bạn cung cấp, đường dẫn là D:\FULLSTASK SELENIUM JAVA\browserDrivers
		// Đảm bảo tệp chromedriver.exe nằm trong thư mục này.
		System.setProperty("webdriver.chrome.driver", "D:\\FULLSTASK SELENIUM JAVA\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Url() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	}

	@Test
	public void TC_02_Logo() {
		Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
	}

	@Test
	public void TC_03_Form() {
		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		if (driver != null) { // Đảm bảo driver không null trước khi quit
			driver.quit();
		}
	}
}