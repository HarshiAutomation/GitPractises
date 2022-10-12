package SeleniumFramewrok.Practises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneCode {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys("harshicr123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Harshi@123");
		driver.findElement(By.id("login")).click();
		System.out.println("Successfully loggedin");
		
		List<WebElement> li=driver.findElements(By.cssSelector(".mb-3"));
	    WebElement productToBeSelected=	li.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		
	    productToBeSelected.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
	    
	List<WebElement> cartItems=   driver.findElements(By.cssSelector(".infoWrap h3"));
	Boolean match=cartItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
	Assert.assertTrue(match);
	System.out.println("Successfully added ADIDAS ORIGINAL");

	}
}
