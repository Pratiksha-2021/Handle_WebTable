package com.webtable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebtable {
   private WebDriver driver;

	@Test
	public void webTableHandle() {
		System.setProperty("webdriver.chrome.driver","chromedriver85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//actual data tr[2]
		//*[@id="customers"]/tbody/tr[2]/td[1]
		
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowCount=rows.size();
		System.out.println("row countt is"+rowCount);
		
		String beforeXpath="//table[@id='customers']/tbody/tr[";
		String afterXpath="]td[1]";
		
		for(int i=2;i<=7;i++) {
			String actualXpath= beforeXpath+i+afterXpath;
			WebElement element=driver.findElement(By.xpath(actualXpath));
			System.out.println("All name  is>>>"+element.getText());
			if(element.getText().equals("Centro comercial Moctezuma")) {
				System.out.println("company name :"+element.getText() +"is found"+"at position:"+(i-1) );
				break;
			}
			
			
			//*[@id="customers"]/tbody/tr[1]/th[1]
			//*[@id="customers"]/tbody/tr[1]/th[2]
			
		}
		
		String beforeXpathcol="//table[@id='customers']/tbody/tr[1]/th[";
		String afterXpathcol="]";
		
		List<WebElement>colms=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		int colmsCount=rows.size();
		System.out.println("col countt is"+colmsCount);
		System.out.println("column values are..>>>");
		for(int i=1;i<=colmsCount;i++) {
			String actualXpath= beforeXpathcol+i+afterXpathcol;
			WebElement element=driver.findElement(By.xpath(actualXpath));
			String colText=element.getText();
			System.out.println("column values are"+colText);
			}
			

	}

}
