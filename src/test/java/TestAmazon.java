package test.java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAmazon {
    WebDriver driver;
    String url = "https://www.amazon.com/";
    public void openHamburger(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
    }
    @Test
    public void checkJava(){
        openHamburger();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int size = driver.findElements(By.xpath("//div[contains(text(),'Software')]")).size();
        Assert.assertEquals(size,1);
        driver.findElement(By.xpath("//a[@class='hmenu-item hmenu-compressed-btn']")).click();
        WebElement VideoGames = driver.findElement(By.linkText("Video Games"));
        js.executeScript("arguments[0].scrollIntoView();",VideoGames);
        driver.findElement(By.xpath("//a[@data-menu-id='26']")).click();
        
        driver.quit();





    }
}
