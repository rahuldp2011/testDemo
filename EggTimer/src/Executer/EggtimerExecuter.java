package Executer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.homePage;

public class EggtimerExecuter extends homePage {
	public static WebDriver driver ;
	public static WebDriverWait w;
	public static int countdown;
	private static String oldval;
	
	@BeforeTest
	public void b4test()
	{
	oldval="0";
	countdown=15;
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");		
	driver = new ChromeDriver();
	w = new WebDriverWait(driver,30);
	
}
	
	
	@Test
	public void test()
	{
		// TODO Auto-generated method stub
		// initiate the test, call the web browser 
		driver.get("http://e.ggtimer.com/");
		driver.manage().window().maximize();
		// Fill the test box with value, this value can be taken from external sources- It will be an enhancement
		driver.findElement(By.cssSelector(timerText)).sendKeys(""+countdown);
		driver.findElement(By.cssSelector(timerbtn)).click();
		WebElement timer= w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(countermin)));
		// Looping with one second iteration till countdown gets over.
		for (int i=0; i<=countdown; i++)
		{			
			if (oldval!=timer.getText())
			{
				oldval=timer.getText();				
			}
			
				Assert.assertEquals(oldval, timer.getText());
			
			if (i==countdown)
			{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					 Reporter.log(e.toString()); 
				}
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
						
		}
		}
		driver.close();
		
	}
	
	
	@AfterTest
	public void aftertest()
	{
		driver.close();
	}
	

} // Only simple code is written due to time constraints. Test cases are written in notepad saparately
