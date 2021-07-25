package feedback;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_feedback_17 {
	WebDriver cDriver;
	 @BeforeMethod
	    void setUp()
	     {
		  WebDriverManager.chromedriver().setup();
		  cDriver= new ChromeDriver();
	     }
@Test
 
void give_Feedback() throws InterruptedException {

    cDriver.get("https://www.amazon.in/");
    cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("socs");
	cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
    cDriver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
	cDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
    cDriver.findElement(By.xpath("//div[3]//div[1]//span[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//span[1]//a[1]//div[1]")).click();
    Thread.sleep(2000);
    Set<String> ids = cDriver.getWindowHandles();
    Iterator<String> it = ids.iterator();
    String parentId = it.next();
    String childId = it.next();
    cDriver.switchTo().window(childId);
    cDriver.findElement(By.xpath("//div[@id='averageCustomerReviews']//span[@id='acrCustomerReviewText']")).click();
    cDriver.findElement(By.xpath("//*[@id=\"histogramTable\"]/tbody/tr[1]/td[2]/a/div")).click();
	cDriver.findElement(By.id("a-autoid-12-announce")).click();
	WebElement emailidElement1=cDriver.findElement(By.xpath("//input[@id='ap_email']"));
	emailidElement1.sendKeys("suryarajan361@gmail.com");

	cDriver.findElement(By.xpath("//input[@id='continue']")).click();
	WebElement passwordElement2= cDriver.findElement(By.xpath("//input[@id='ap_password']"));
	passwordElement2.sendKeys("Feb151998@");
	cDriver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	
    WebElement txt=cDriver.findElement(By.xpath("//*[@id=\"customer_review-R35KDAFV0EIQ5I\"]/div[5]/div/span[1]/div[1]/span"));
    String s=txt.getText();
    System.out.println(s);
    System.out.println("Test case passed");
    
}


@AfterMethod
void tearDown()
{
cDriver.close();
}
}