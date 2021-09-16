package week4.day2;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mergecontacts {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.get("http://leaftaps.com/opentaps/control/main");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		 driver.findElement(By.id("password")).sendKeys("crmsfa");
		 driver.findElement(By.className("decorativeSubmit")).click();
		 driver.findElement(By.linkText("CRM/SFA")).click();
		 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		 driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> winHandles =new ArrayList<String>(windowHandles);
		 driver.switchTo().window(winHandles.get(1));
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[text()='12751']")).click();
		 Thread.sleep(1000);
		 driver.switchTo().window(winHandles.get(0));
		 System.out.println(winHandles.size());
		 driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		 Set<String> windowHand = driver.getWindowHandles();
		 List<String> List =new ArrayList<String>(windowHand);
		 driver.switchTo().window(List.get(1));;
		 
		 driver.findElement(By.xpath("//a[text()='12752']")).click();
		 driver.switchTo().window(List.get(0));;
		 
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		if (title.contains("View Contact | opentaps CRM")) {
			System.out.println("Matching");
		
		}
		
		else
			System.out.println("not Matching");
	}
}



