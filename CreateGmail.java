import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateGmail {

    public static void main(String ... args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/Brendon/Desktop/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        if( (args.length > 0) && (args.length != 4) ) {
            System.out.println("Please enter your first name, followed by your last name, requested email address, and preferred password, using a space as your delimiter");

        } else {
            createLogin(driver, "John", "Doe", "MyDummyTestEmail@gmail.com", "Lousypw123");
        }
    }

    public static void createLogin(ChromeDriver driver, String firstName, String lastName, String email, String password) {

        driver.get("https://gmail.com");
        driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[2]/div/div/content/span") ).click();

        //Create login
        driver.findElement(By.name("firstName")).sendKeys(firstName);   
        driver.findElement(By.name("lastName")).sendKeys(lastName);  
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Lousypw123");
        driver.findElement(By.name("ConfirmPasswd")).sendKeys("Lousypw123");
        driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/content")).click();  

    }


}

