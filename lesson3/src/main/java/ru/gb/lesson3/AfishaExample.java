package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AfishaExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://afisha.ru/");
        WebElement inputSearch= driver.findElement(By.xpath("//input[@placeholder=\"Событие, актер, место\"]"));
        inputSearch.sendKeys("Брат");
       // Thread.sleep(1000);
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Брат']")));
        driver.findElement(By.xpath("//div[.='Брат']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
