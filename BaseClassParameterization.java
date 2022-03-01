package week5.day2;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassParameterization {
	public  String excelPath;
	public static ChromeDriver driver;
	@Parameters ({"url"})
	@BeforeMethod
	public void preCondition(String url){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

}
	@DataProvider(name="Call")
	public String[][] sendData() throws IOException {
		return ReadExcel.readData(excelPath);
}
	
	@AfterMethod 
	public void postCondition() 
	{
		driver.close();
	}

}
