package ohtu;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        System.out.println(driver.getPageSource());

        sleep(2);
        System.out.println(driver.getPageSource());

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER LOGIN------------------------");

        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER LOGOUT------------------------");

        element = driver.findElement(By.linkText("login"));
        element.click();
        sleep(2);
        System.out.println("------------------------CHECKPOINT AFTER BACK TO LOGIN PAGE------------------------");

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("väärä");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER BAD LOGIN------------------------");

        element = driver.findElement(By.linkText("back to home"));
        element.click();

        sleep(2);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER BACK TO MAIN PAGE------------------------");

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(3);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AT CREATION PAGE------------------------");

        Random r = new Random();
        element = driver.findElement(By.name("username"));
        element.sendKeys("tiera" + r.nextInt(133337));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salainen");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salainen");

        element.submit();

        sleep(3);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER CREATION------------------------");

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER LOGIN------------------------");
        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);
        System.out.println(driver.getPageSource());
        System.out.println("------------------------CHECKPOINT AFTER LOGOUT------------------------");

        System.out.println("end");

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
