package GoogleLoginAccount;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class createAccount {
	public static void main(String[] args) throws Exception {	
		String Url="https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com"
				+ "%3Fhl%3Den-US&ec=GAlA8wE&hl=en&flowName=GlifWebSignIn&flowEntry=AddSession&dsh=S-"
				+ "1241331482%3A1722311049648081&ddm=0";
		String nextButton="//span[text()='Next']";

		WebDriver  driver= new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String filelocation="C:\\Users\\Sathish\\Documents\\createaccount data.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		int countrow = sheet.getLastRowNum();
		int countcolumn= sheet.getRow(1).getLastCellNum();

		for (int i = 1; i <= countrow; i++) {
			XSSFRow celldata = sheet.getRow(i);
			String firstname = null;
			String userName = null;
			String passWd=null;
			String phonenumber = null;
			String confirmPasswd=null;
			String month=null;
			String day=null;
			String year=null;
			String gender=null;

			for (int j = 0; j < countcolumn; j++) {
				XSSFCell cell = celldata.getCell(j);
				firstname=  celldata.getCell(0).getStringCellValue();
				month=  celldata.getCell(1).getStringCellValue();
				day= String.valueOf((long)celldata.getCell(2).getNumericCellValue());
				year= String.valueOf((long)celldata.getCell(3).getNumericCellValue());
				gender= celldata.getCell(4).getStringCellValue();
				userName= celldata.getCell(5).getStringCellValue();
				passWd= celldata.getCell(6).getStringCellValue();
				confirmPasswd= celldata.getCell(7).getStringCellValue();
				phonenumber=  String.valueOf((long)celldata.getCell(8).getNumericCellValue()); 
			}
			driver.findElement(By.xpath("//span[text()='Create account']")).click();
			driver.findElement(By.xpath("//span[text()='For my personal use']")).click();
			driver.findElement(By.name("firstName")).sendKeys(firstname);
			driver.findElement(By.xpath(nextButton)).click();
			WebElement Month1=driver.findElement(By.xpath("//select[@aria-labelledby='month-label']"));
			Select selectMonth= new Select(Month1);
			selectMonth.selectByVisibleText(month);
			driver.findElement(By.xpath("//input[@name='day']")).sendKeys(day);
			driver.findElement(By.xpath("//input[@name='year']")).sendKeys(year);
			WebElement Gender= driver.findElement(By.xpath("//select[@aria-labelledby='gender-label']"));
			Select selectGender= new Select(Gender);
			selectGender.selectByVisibleText("Male");
			driver.findElement(By.xpath(nextButton)).click();
			driver.findElement(By.xpath("//input[@name='Username']")).sendKeys(userName);
			driver.findElement(By.xpath(nextButton)).click();
			driver.findElement(By.xpath("/input[@name='Passwd']")).sendKeys(passWd);
			driver.findElement(By.xpath("//input[@name='PasswdAgain']")).sendKeys(confirmPasswd);
			driver.findElement(By.xpath(nextButton)).click();
			driver.findElement(By.xpath("//span[text()='Phone number']")).sendKeys(phonenumber);
			driver.findElement(By.xpath(nextButton)).click();
			driver.findElement(By.xpath(nextButton)).click();
			driver.findElement(By.xpath("//span[text()='I agree']")).click();
			System.out.println(firstname+"-->"+passWd+"-->"+phonenumber);
			System.out.println();
		}
		System.out.println("rowcount-->"+countrow +"colcount-->"+countcolumn);





	}

}
