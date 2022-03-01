package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClassParameterization {
	@BeforeClass
	public void passData() {
		excelPath = "C:\\Gayathri\\LearnSelenium\\dataproviderdetails.xlsx";
	}

	@Parameters({ "username", "password" })
	@Test(dataProvider = "Call")
	public void duplicateLead(String username, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("rrr@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(), 'Find Leads')]")).click();
		Thread.sleep(1000);
		WebElement leadFirstName = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		String capturedLeadName = leadFirstName.getText();
		System.out.println(capturedLeadName);
		leadFirstName.click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if (driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("The title contains the word Duplicate Lead");
		} else {
			System.out.println("The title does not contain the word Duplicate Lead");
		}
		driver.findElement(By.name("submitButton")).click();
		String duplicatedLeadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println(duplicatedLeadName);
		if (capturedLeadName.equals(duplicatedLeadName)) {
			System.out.println("Duplicated lead name is same as Captured name");
		} else {
			System.out.println("Duplicated lead name is not same as Captured name");
		}
		// driver.close();

	}
}
