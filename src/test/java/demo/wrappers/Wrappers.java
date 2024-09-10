package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void radioButton(ChromeDriver driver, String radioButtonText){
        try{
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'aDTYNe snByac OvPDhc OIC90c') and contains(text(),'"+radioButtonText+"')]/../../..//div[@class='vd3tt']"));
            element.click();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void checkBox(ChromeDriver driver, String checkBoxText){
        try{
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'aDTYNe snByac n5vBHf OIC90c') and contains(text(),'"+checkBoxText+"')]"));
            element.click();
        }catch(Exception e){
            e.printStackTrace();
    
        }
    }

    public static void dropDownClick(ChromeDriver driver, String dropDownText){
        try{
            WebElement element =driver.findElement(By.xpath("(//div[@data-value='"+ dropDownText+"'])[2]"));
            element.click();
            System.out.println("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb')]//span[text()='\"+ dropDownText+\"']");
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    public static void clickOnElement(ChromeDriver driver, WebElement element) {
        try{
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();",element);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String getDateSevenDaysAgo() {
        LocalDate currenDate = LocalDate.now();
        LocalDate dateMinus7Days = currenDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateMinus7Days.format(formatter);
        return formattedDate;
    
    }
    public static String getEpochTimeAsString() {
        long epochTime = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;
        
    }
}
