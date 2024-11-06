package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orange {

    public String baseUrl = "http://localhost:8080/orangehrm/orangehrm-5.7/web/index.php/auth/login";
    String driverPath = "C:\\Users\\aswat\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        System.out.println("Launching Firefox browser");
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin123");
        driver.findElement(By.name("password")).sendKeys("Swetha@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))).click();
    }

    @Test
    public void employeeDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 15);

      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM"))).click();

      wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Employee"))).click();

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys("Mahasweta");
        driver.findElement(By.name("middleName")).sendKeys("Sobha");
        driver.findElement(By.name("lastName")).sendKeys("Prakasan");
   }

    @AfterTest
    public void save() {
    	 WebDriverWait wait = new WebDriverWait(driver, 15);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"))).click();
        
    }
}
