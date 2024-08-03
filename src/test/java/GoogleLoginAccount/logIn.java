package GoogleLoginAccount;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class logIn {
	public static void main(String[] args) throws Exception {
		WebDriver  driver= new ChromeDriver();
		driver.get("https://accounts.google.com/v3/signin"
				+ "/identifier?continue=https%3A%2F%2Fwww.google.com%3Fhl%3Den-US&ec"
				+ "=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh="
				+ "S-1241331482%3A1722311049648081&ddm=0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String filelocation="C:\\Users\\Sathish\\Documents\\Test Data.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		int countrow = sheet.getLastRowNum();
		int countcolumn= sheet.getRow(1).getLastCellNum();
		System.out.println("rowcount-->"+countrow +"colcount-->"+countcolumn);
		for (int i = 1; i <= countrow; i++) {
			XSSFRow celldata = sheet.getRow(i);
			String eMail=  celldata.getCell(0).getStringCellValue();
			String passWord=  celldata.getCell(1).getStringCellValue();
			String phonenumber=  String.valueOf((long)celldata.getCell(2).getNumericCellValue()); 
			driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys(eMail);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys(passWord);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			driver.findElement(By.xpath("//input[@class='VfPpkd-fmcmS-wGMbrd ']")).sendKeys(phonenumber);
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			System.out.println(eMail + "--"+passWord +"--"+phonenumber);
		}
		System.out.println("Done");


	}
}
