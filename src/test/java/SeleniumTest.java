package test.java;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	@Test
	public  void testCalculus() throws InterruptedException{		
		float numberA = 120;
		float numberB = 14.5f;
		
		// We dropped the chrome web driver in the main directory of this project, so we set the path to ./chromedriver.exe
	    System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("http://localhost:9090/jee-project-Version2/Controller");
	    Thread.sleep(2000);  // Let the user actually see something!
	    WebElement inputBoxA = driver.findElement(By.name("a"));
	    WebElement inputBoxB = driver.findElement(By.name("b"));
	    WebElement calculateButton = driver.findElement(By.name("action"));
	    inputBoxA.sendKeys(String.valueOf(numberA));
	    Thread.sleep(2000);
	    inputBoxB.sendKeys(String.valueOf(numberB));
	    Thread.sleep(1000);
	    calculateButton.click();
	    String oldUrl = driver.getCurrentUrl();

	    Thread.sleep(4000); // We wait for a possible page loading
	    String newUrl = driver.getCurrentUrl();
	    assertTrue(oldUrl.equals(newUrl));
	    
	    driver.quit();
	}
	
	@Test
	public void isInputTextSecure() throws InterruptedException{
		try{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		    driver.get("http://localhost:9090/jee-project-Version2/Controller");
		    Thread.sleep(2000);  // Let the user actually see something!
		    WebElement inputBoxA = driver.findElement(By.name("a"));
		    WebElement inputBoxB = driver.findElement(By.name("b"));
		    WebElement calculateButton = driver.findElement(By.name("action"));
		    inputBoxA.sendKeys("abc");
		    Thread.sleep(1000);
		    inputBoxB.sendKeys("sqhdéqé&/");
		    Thread.sleep(500);
		    calculateButton.click();
		    String oldUrl = driver.getCurrentUrl();
		    Thread.sleep(4000); // We wait for a possible page loading
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
