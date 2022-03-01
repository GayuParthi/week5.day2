package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClassParameterization {
	@BeforeClass
	public void passData() {
		excelPath = "C:\\Gayathri\\LearnSelenium\\dataproviderdetails.xlsx";
	}

	@Parameters({ "username", "password" })
	@Test(dataProvider = "Call")
	public void deleteLead(String username, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		WebElement leadId = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		String leadId1 = leadId.getText();
		System.out.println(leadId1);
		Thread.sleep(2000);
		leadId.click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(leadId1);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		if (driver.findElement(By.className("x-paging-info")).isDisplayed()) {
			System.out.println("No Records to Display");
		} else {
			System.out.println("Records to Display");
		}

	}
}