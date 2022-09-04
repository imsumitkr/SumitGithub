package projectname.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import projectname.genericLib.BaseClass;
import projectname.genericLib.DataUtility;
public class CreateCustomer extends BaseClass{
	@Test
public  void createCust() throws EncryptedDocumentException, IOException 
{
	Random r=new Random();
	int num=r.nextInt(100000);
	driver.findElement(By.cssSelector(".content.tasks")).click();
	driver.findElement(By.cssSelector(".title.ellipsis")).click();
	driver.findElement(By.className("createNewCustomer")).click();
	driver.findElement(By.className("newNameField")).sendKeys(du.getDataFromExcelsheet("Sheet1",0,0)+num);
	driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
    System.out.println("customer created");

}

}