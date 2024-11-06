package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test
  public class OrangHRM {
	
	public String baseUrl="http://localhost:8080/orangehrm/orangehrm-5.7/web/index.php/auth/login";
    String driverPath="C:\\Users\\aswat\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
	public WebDriver driver;
	
@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching firefox browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver=new FirefoxDriver();
		driver.get(baseUrl);
	}
@BeforeMethod
public void login() {
	//driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin123");
	driver.findElement(By.name("password")).sendKeys("Swetha@123");
    driver.findElement(By.linkText("Login")).click();
}
@Test
public void employeeDetails() {
	
	driver.findElement(By.linkText("PIM")).click();
}
@AfterMethod
public void addEmployee() {
	driver.findElement(By.name("firstName")).sendKeys("Mahasweta");	
	driver.findElement(By.name("middleName")).sendKeys("Sobha");
	driver.findElement(By.name("lastName")).sendKeys("Prakasan");
}
@AfterTest
public void update() {
	driver.findElement(By.linkText("Save")).click();
}

	
	}

