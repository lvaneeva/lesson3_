package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver=new FirefoxDriver();
        firefoxDriver.get("https://ya.ru");
        Thread.sleep(5000);
        firefoxDriver.quit();
    }
}
