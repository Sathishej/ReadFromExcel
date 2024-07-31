package GoogleLoginAccount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class createAccount {
	public static void main(String[] args) {
		String Url="https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com"
				+ "%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-"
				+ "1241331482%3A1722311049648081&ddm=0";
		String nextButton="//span[text()='Next']";
		
		WebDriver  driver= new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//span[text()='Create account']")).click();
		driver.findElement(By.xpath("//span[text()='For my personal use']")).click();
		driver.findElement(By.name("firstName")).sendKeys("sharp");
		driver.findElement(By.xpath(nextButton)).click();
		WebElement month=driver.findElement(By.xpath("//select[@aria-labelledby='month-label']"));
		Select selectMonth= new Select(month);
		selectMonth.selectByVisibleText("March");
		driver.findElement(By.xpath("//input[@name='day']")).sendKeys("5");
		driver.findElement(By.xpath("//input[@name='year']")).sendKeys("1998");
		WebElement Gender= driver.findElement(By.xpath("//select[@aria-labelledby='gender-label']"));
		Select selectGender= new Select(Gender);
		selectGender.selectByVisibleText("Male");
		driver.findElement(By.xpath(nextButton)).click();
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("sharpmind9703");
		driver.findElement(By.xpath(nextButton)).click();
		driver.findElement(By.xpath("/input[@name='Passwd']")).sendKeys("SharpMind@2268");
		driver.findElement(By.xpath("//input[@name='PasswdAgain']")).sendKeys("SharpMind@2268");
		driver.findElement(By.xpath(nextButton)).click();
		driver.findElement(By.xpath("//span[text()='Phone number']")).sendKeys("9092654591");
		driver.findElement(By.xpath(nextButton)).click();
		driver.findElement(By.xpath(nextButton)).click();
		driver.findElement(By.xpath("//span[text()='I agree']")).click();




	}

}
