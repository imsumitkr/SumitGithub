package projectname.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	 public WebDriver driver;
	 public DataUtility du= new DataUtility();
	 @Parameters("browser")
	 @BeforeClass(alwaysRun=true)
	 public void launchBrowser(String browser)
	 {
		  if(browser.equals("chrome"))
		  {
		    System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		  }
		  else if(browser.equals("edge"))
		  {
			  System.setProperty("webdriver.edge.driver","C:\\selenium\\edgedriver_win64\\edgedriver.exe");
				driver=new EdgeDriver();
		  }
			
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	 }
	 
	  @BeforeMethod(alwaysRun=true)
	  public void loginApp() throws IOException 
	  {
		    driver.get(du.getDatafromproperties("url"));
			driver.findElement(By.name("username")).sendKeys(du.getDatafromproperties("username"));
			driver.findElement(By.name("pwd")).sendKeys(du.getDatafromproperties("password"));
			driver.findElement(By.id("loginButton")).click();
	  }
	  
	  @AfterMethod
	  public void logoutApp()
	  {
		   driver.findElement(By.id("logoutLink")).click();
	  }

	  @AfterClass
	  public void close()
	  {
		   driver.close();
	  }

}
