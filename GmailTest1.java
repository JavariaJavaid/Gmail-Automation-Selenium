package gmailPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.*;

import org.openqa.selenium.support.ui.FluentWait;


public class GmailTest1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\haier\\eclipse\\java-2018-12\\geckodriver.exe");
		//WebDriver  driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\haier\\eclipse\\java-2018-12\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		//wait
		WebDriverWait wait = new WebDriverWait(driver,200);
		
		//URL
		String URL="https://www.gmail.com/";
		
		driver.get(URL);
		
		driver.findElement(By.id("identifierId")).sendKeys("Test@gmail.com");//Create new gmail account Replace Test@gmail.com
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("password")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("password")).sendKeys("TestPassword");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//To
		WebElement To =driver.findElement(By.xpath("//textarea[@aria-label='To']"));
		To.sendKeys("javariatest@gmail.com");
		
		Thread.sleep(5000);
		
		
		//Subject
		WebElement Subject = driver.findElement(By.xpath("//input[@aria-label='Subject']"));
		Subject.sendKeys("Test2Subject");
		Thread.sleep(5000);
		String ESubject = driver.findElement(By.xpath("//input[@value='Test2Subject']")).getAttribute("value").toString();
		System.out.println("Expected Subject "+ ESubject);
	
		Thread.sleep(5000);
		
		//Body
		WebElement Body = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		Body.sendKeys("BodyText");
		String EBody = Body.getText();
		System.out.println("Expected Body "+ EBody);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Three Dot Click
driver.findElement(By.xpath("//div[@data-tooltip='More options']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Label']")).click();
		driver.findElement(By.xpath("(//div[text()='Social'])[2]")).click();
		
		
		//Send Email
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		
		
		Thread.sleep(30000);
		//Social Tab click
		
		driver.findElement(By.xpath("//div[@aria-label='Social']")).click();
		Thread.sleep(30000);
		
		WebElement Started = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Test2Subject'])[2]/../../../../../..//td[3]//span")));
		Started.click();
		//started with text
		driver.findElement(By.xpath("(//span[text()='Test2Subject'])[2]")).click();
		
		Thread.sleep(500);
		//Actual Subject with text
		WebElement ActualSubject = driver.findElement(By.xpath("//h2[text()='Test2Subject']"));
		String ASubject = ActualSubject.getText();
		
		
		//Actual Body with CssSelector
		String ABody = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]")).getText();
		
		
		
		if(ASubject.contentEquals(ESubject))
		{
			System.out.println("Subject match");
		}
		else
		{
			System.out.println("Subject not matched and test failed");
		}
		
		
		if(ABody.contentEquals(EBody))
		{
			System.out.println("Body match");
		}
		else
		{
			System.out.println("Body not matched and test failed");
		}
		
		
	
		
		driver.close();
	}

}
