package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntraproject {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		// ChromeDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.myntra.com/");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// MouseHover on Men
		WebElement men = driver.findElementByXPath("//a[text() = 'Men']");
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();

		// Select Jacket
		driver.findElementByXPath("//a[text() = 'Jackets']").click();

		// Total count
		WebElement len = driver.findElementByXPath("//span[@class ='title-count']");
		String str = len.getText();
		System.out.println("Total Number of items : " + str);
		String str1 = str.replaceAll("[^0-9]", "");
		System.out.println("Removed -: " + str1);

		// converting to Integer
		int parseint = Integer.parseInt(str1);
		System.out.println("Integer value = " + parseint);

		// categories number
		WebElement jackets = driver.findElementByXPath("(//span[@class='categories-num'])[1]");
		String jack = jackets.getText();
		System.out.println("No. of jackets : " + jack);
		String str2 = jack.replaceAll("[^0-9]", "");
		System.out.println("Removed (): " + str2);

		int parseint1 = Integer.parseInt(str2);
		System.out.println("Integer value for jackets = " + parseint1);

		WebElement rainjackets = driver.findElementByXPath("(//span[@class='categories-num'])[2]");
		String rain = rainjackets.getText();
		System.out.println("No. of jackets : " + rain);
		String str3 = rain.replaceAll("[^0-9]", "");
		System.out.println("Removed (): " + str3);

		int parseint2 = Integer.parseInt(str3);
		System.out.println("Integer value for rainjackets = " + parseint2);
		int totjackets = parseint1 + parseint2;

		// checking the count
		if (parseint == totjackets) {
			System.out.println("Total Matches");

		} else
			System.out.println("total does not match");

		// check jackets
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[1]").click();

		// click more options
		driver.findElementByXPath("//div[@class ='brand-more']").click();

		driver.findElementByXPath("//input[@class ='FilterDirectory-searchInput']").sendKeys("duke");

		// click duke
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();

		// click the pop up
		driver.findElementByXPath("//span[@class ='myntraweb-sprite FilterDirectory-close sprites-remove']").click();

		// Check if all the brand name is Duke
		Thread.sleep(2000);

		// Creating List
		List<WebElement> brandname = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		int dukebrand = 0;
		int noduke = 0;
		for (WebElement webElement : brandname) {

			String text = webElement.getText();
			if (text.equals("Duke")) {
				dukebrand++;
			} else {
				noduke++;
				System.out.println(text);
			}
		}
		// name.add(webElement);
		if (dukebrand == brandname.size()) {
			System.out.println("All brands are Duke");
		}

		else
			System.out.println("All brands are not Duke");

		/* sort by better Discount
		
		  WebElement sort = driver.findElementByXPath("//label[text()='Better Discount']");
		  Select better = new Select(sort); 
		  better.selectByValue("discount"); */
		  
		 
		// mouse hover on sort
		WebElement sort = driver.findElement(By.className("sort-sortBy"));
		builder.moveToElement(sort).perform();
		// select better discount
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		Thread.sleep(200);

		// select the first product
		/*
		 * WebElement price = driver.findElementByClassName("product-discountedPrice");
		 * price.getText(); System.out.println(price);
		 */

		// price of first item
		String firstitem = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("The price of first displayed item is :" + firstitem);
		Thread.sleep(250);

		// 12.click on the first item
		driver.findElementByXPath("//img[@title ='Duke Men Green Solid Bomber Jacket']").click();

		// 14.Do window Handle
		Set<String> windowHandle = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandle);
		driver.switchTo().window(windowList.get(1));
		System.out.println("Window title : " + driver.getTitle());

		// 13.take a screenshot
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/screenshot.png");
		FileUtils.copyFile(src1, dest);

		// 15.add to wishlist
		driver.findElementByXPath("//span[text()='WISHLIST']").click();

		// 16.close browser

		driver.quit();
	
		
	}
}
/*1) Open https://www.myntra.com/
2) Mouse hover on MeN 
3) Click Jackets 
4) Find the total count of item 
5) Validate the sum of categories count matches
6) Check jackets
7) Click + More option under BRAND	
8) Type Duke and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand Duke
    Hint : use List 
11) Sort by Better Discount
12) Find the price of first displayed item
Click on the first product
13) Take a screen shot
14) Click on WishList Now
15) Close Browser*/