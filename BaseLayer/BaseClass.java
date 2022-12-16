package BaseLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src/main/java//configLayer//config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void iniliazation() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//AllDriver//chromedriver.exe");

		// WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

	}
}
