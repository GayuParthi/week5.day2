package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClassParameterization {
	@BeforeClass
	public void passData() {
		excelPath ="C:\\Gayathri\\LearnSelenium\\dataproviderdetails.xlsx";
	}
	 @Parameters({"username","password"})
	@Test (dataProvider = "Call")
public void editLead(String username,String password) throws InterruptedException {
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.partialLinkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Find Leads")).click();
	driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Hari");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=11015'])")).click();
	Thread.sleep(2000);
	System.out.println("The page title is  "+driver.getTitle());
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
	driver.findElement(By.id("updateLeadForm_companyName")).clear();
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf Training Centre");
	driver.findElement(By.xpath("(//input[@class='smallSubmit'])")).click();
	//driver.close();
}
}
