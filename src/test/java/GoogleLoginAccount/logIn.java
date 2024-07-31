package GoogleLoginAccount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class logIn {
	public static void main(String[] args) {
		WebDriver  driver= new ChromeDriver();
		driver.get("https://accounts.google.com/v3/signin"
				+ "/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec"
				+ "=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh="
				+ "S-1241331482%3A1722311049648081&ddm=0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("sharpmind9703@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("SharpMind@2268");
		driver.findElement(By.xpath("//span[text()='Next']")).click();

	}
}
