package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Project1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

        String pageTitle = driver.getTitle();
        System.out.println("Website Title: " + pageTitle);

        // Logging into the application
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Adding an item to the cart
        List<WebElement> addToCartButtons = driver.findElements(By.className("btn_inventory"));
        addToCartButtons.get(2).click();

        // Navigating to the cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Verifying the item in the cart
        String cartItem = driver.findElement(By.className("inventory_item_name")).getText();
        System.out.println("Item in the Cart: " + cartItem);

        // Proceeding to checkout
        driver.findElement(By.id("checkout")).click();

        // Filling out checkout information
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        // Completing the order
        driver.findElement(By.id("finish")).click();

        // Validating the order confirmation
        String confirmation = driver.findElement(By.className("complete-header")).getText();
        if (confirmation.equals("THANK YOU FOR YOUR ORDER")) {
            System.out.println("Order successfully placed!");
        } else {
            System.out.println("Order placement failed!");
        }
    }
}
