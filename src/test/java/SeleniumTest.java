
package test.java;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	@Test
	public  void testCalculus() throws InterruptedException{		
		double numberA = 120;
		double numberB = 14.5;
		
		// We dropped the chrome web driver in the main directory of this project, so we set the path to ./chromedriver.exe
	    System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("http://localhost:9090/jee-project-Version2/Controller");
	    org.awaitility.Awaitility.await().atLeast(2,TimeUnit.SECONDS);  // Let the user actually see something!
	    WebElement inputBoxA = driver.findElement(By.name("a"));
	    WebElement inputBoxB = driver.findElement(By.name("b"));
	    WebElement calculateButton = driver.findElement(By.name("action"));
	    inputBoxA.sendKeys(String.valueOf(numberA));
	    org.awaitility.Awaitility.await().atLeast(2,TimeUnit.SECONDS);
	    inputBoxB.sendKeys(String.valueOf(numberB));
	    org.awaitility.Awaitility.await().atLeast(1,TimeUnit.SECONDS);
	    calculateButton.click();
	    org.awaitility.Awaitility.await().atLeast(4,TimeUnit.SECONDS); // We wait for a possible page loading	    
	    driver.quit();
	}
	
	@Test
	public void isInputTextSecure() throws InterruptedException{
		try{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		    driver.get("http://localhost:9090/jee-project-Version2/Controller");
		    org.awaitility.Awaitility.await().atLeast(2,TimeUnit.SECONDS);  // Let the user actually see something!
		    WebElement inputBoxA = driver.findElement(By.name("a"));
		    WebElement inputBoxB = driver.findElement(By.name("b"));
		    WebElement calculateButton = driver.findElement(By.name("action"));
		    inputBoxA.sendKeys("abc");
		    org.awaitility.Awaitility.await().atLeast(1,TimeUnit.SECONDS);
		    inputBoxB.sendKeys("sqhdéqé&/");
		    org.awaitility.Awaitility.await().atLeast(1,TimeUnit.SECONDS);

		    calculateButton.click();
		    String oldUrl = driver.getCurrentUrl();
		    org.awaitility.Awaitility.await().atLeast(4,TimeUnit.SECONDS); // We wait for a possible page loading
		    String newUrl = driver.getCurrentUrl();
		    
		    // If the system is correct, then the the page should be the same because the text from inputs a or/and b were rejected
		    assertTrue(oldUrl.equals(newUrl));
		    driver.quit();
		}catch(NumberFormatException ex)
		{
			fail("The input of non digits characters shouldn't have been allowed for the input fields (a & b)");
		}
		
	}
	


}

