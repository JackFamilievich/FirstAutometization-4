package test.java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
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
        WebElement SearchBar = driver.findElement(By.xpath("//input[@name='field-keywords']"));
        SearchBar.sendKeys("Java", Keys.ENTER);
        driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']")).click();
        driver.findElement(By.xpath("//a[@id='breadcrumb-back-link']")).click();
        WebElement filterEnglish = driver.findElement(By.linkText("English"));
        js.executeScript("arguments[0].scrollIntoView();",filterEnglish);
        driver.findElement(By.xpath("//a[@href='/s?k=java&i=stripbooks&rh=n%3A283155%2Cp_n_feature_nine_browse-bin%3A3291437011&dc&crid=2ACQU6U6L6G8R&qid=1678457838&rnid=3291435011&sprefix=ja%2Caps%2C198&ref=sr_nr_p_n_feature_nine_browse-bin_1&ds=v1%3AA5TGIYzxH3OCFyHf%2Fye0D9CYqPEeXRxOZNcAFYSaUVc']")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        int pageAmount = driver.findElements(By.xpath("//span[@class='s-pagination-item s-pagination-disabled']")).size();
        Assert.assertEquals(size,1);
        driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);



        driver.quit();





    }
}
