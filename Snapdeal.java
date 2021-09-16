package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//2. Go to Mens Fashion
		driver.findElement(By.xpath("//*[@id=\"leftNavMenuRevamp\"]/div[1]/div[2]/ul/li[7]/a/span")).click();//*[@id="leftNavMenuRevamp"]/div[1]/div[2]/ul/li[7]/a/span
		 
		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//*[@id=\"category6Data\"]/div[1]/div/div/p[2]/a/span")).click();
		
		//4. Get the count of the sports shoes
		String count = driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div[2]/div[3]/h1/span")).getText();
		System.out.println("The count of sports shoes are "+count);
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//*[@id=\"js-255-nav\"]/li[1]/a/div[1]")).click();
		
		//6. Sort by Low to High
//sort.char driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div[2]/div[3]/div[2]/div/div"));
		//Arrays.sort(char);
		 
		//7. Check if the items displayed are sorted correctly
		 
		//8. Mouse Hover on puma Blue Training shoes
		
		// click QuickView button
		
		/*10. Print the cost and the discount percentage
		11. Take the snapshot of the shoes.
		12. Close the current window
		13. Close the main window
		14. select the brand Puma*/
	}

}
