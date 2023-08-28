package generic_Utilites;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

	public static WebDriver driver;

	@BeforeTest
	public WebDriver setup() throws Throwable {

		CommonData_Utility clib = new CommonData_Utility();
		String BROWSER = clib.commondata("browser");
		String URL = clib.commondata("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			driver.get(URL);
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(URL);
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			driver.get(URL);
		} else {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			driver.get(URL);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Build-Success!!");
		driver.quit();
	}

}
