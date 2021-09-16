package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		WebElement Stationobj=driver.findElement(By.id("txtStationFrom"));
				Stationobj.clear();
		Stationobj.sendKeys("ms");
		Stationobj.sendKeys(Keys.ENTER);
		WebElement Tostation=driver.findElement(By.id("txtStationTo"));
		Tostation.sendKeys("mdu");
		Tostation.sendKeys(Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
	    WebElement trainlist = driver.findElement(By.id("divTrainsList"));
	    List<WebElement>trainList = driver.findElements(By.tagName("tr")); 
	    List<String> names=new ArrayList();
	    System.out.println("No of trains: "+trainList.size());
	    for(int i=1; i< trainList.size(); i++) {
	    	WebElement Element = trainList.get(1);
	    	List<WebElement> allcolumns = Element.findElements(By.tagName("td"));
	    	String text= allcolumns.get(1).getText();
System.out.println(text);
names.add(text);


	    }
Collections.sort(names);	    
		
		

	

	}

}
