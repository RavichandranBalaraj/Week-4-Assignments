package week4.day2;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class sortable {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement findElement2 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		Point location = findElement2.getLocation();
		int x = location.getX();
		int y = location.getY();
		
		Actions builder = new Actions(driver);
		
		
		Thread.sleep(1000);
		builder.dragAndDropBy(findElement, x, y).perform();
		
	}

}


