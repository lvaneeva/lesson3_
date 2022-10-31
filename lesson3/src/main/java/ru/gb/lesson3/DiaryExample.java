package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class DiaryExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://diary.ru/user/login");
       /* chromeDriver.findElement(By.id("loginform-username")).sendKeys("larisa_sap");
        chromeDriver.findElement(By.id("loginform-password")).sendKeys("abcd1234");
        Thread.sleep(20000);
        chromeDriver.findElement(By.id("login_btn")).click();*/

        Cookie authCookie=new Cookie("_identity_", "98db65069a621ee06ffa46d1b8a019cd80bc7be13d78ad43b5b48fe0c1a60361a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3573992%2C%22UmWyxOM2s_2WonEOCOq-jhI9oL1_4QsO%22%2C2592000%5D%22%3B%7D");
        chromeDriver.manage().addCookie(authCookie);

        chromeDriver.navigate().refresh();

        chromeDriver.findElement(By.id("writeThisDiary")).click();
        String postTitle="title"+new Random().nextInt(100);
        chromeDriver.findElement(By.id("postTitle")).sendKeys(postTitle);
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.id("message_ifr")));
        chromeDriver.findElement(By.id("tinymce")).sendKeys("textttt");
        chromeDriver.switchTo().parentFrame();
        chromeDriver.findElement(By.id("rewrite")).click();
        List<WebElement> titles=chromeDriver.findElements(By.xpath("//a[@class='title']"));
        titles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();
        Thread.sleep(5000);
        chromeDriver.quit();

    }
}
