package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    @Test
    public void testCase01() throws InterruptedException{

        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(3000);
        WebElement nameInputBox= driver.findElement(By.xpath("//input[@type='text']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameInputBox));
        System.out.println("Wait 1");
        Wrappers.enterText((nameInputBox), "Crio Learner");

        WebElement practicingAutomationTextArea = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        String practicingAutomationText = "I want to be the best QA Engineer! ";
        String epochTimeString = Wrappers.getEpochTimeAsString();
        Thread.sleep(3000);
        System.out.println("Wait 2");
        Wrappers.enterText(practicingAutomationTextArea, practicingAutomationText + ""+ epochTimeString);

        Thread.sleep(3000);
        System.out.println("Wait 3");

        Wrappers.radioButton(driver,"0 - 2");
        Thread.sleep(3000);
        System.out.println("Wait 4 ");

        Wrappers.checkBox(driver, "Java");
        Wrappers.checkBox(driver, "Selenium");
        Wrappers.checkBox(driver, "TestNG");

        WebElement dropDownElement= driver.findElement(By.xpath("//div[contains(@class,'DEh1R')]"));
        Thread.sleep(3000);
        System.out.println("Wait 5");
        Wrappers.clickOnElement(driver, dropDownElement);
        Thread.sleep(3000);
        
        Wrappers.dropDownClick(driver, "Ms");
        Thread.sleep(2000);

        WebElement dateInputBox = driver.findElement(By.xpath( "//input[@type='date']"));
        String sevenDaysAgoDate = Wrappers.getDateSevenDaysAgo();
        Thread.sleep(3000);
        System.out.println("Wait 6");
        Wrappers.enterText(dateInputBox, sevenDaysAgoDate);

        WebElement hourElement = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement minElement = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        WebElement saveBtn = driver.findElement(By.xpath("//div[@class='lRwqcd']/div"));

        Wrappers.enterText(hourElement, "07");
        Wrappers.enterText(minElement, "30");
        Wrappers.clickOnElement(driver, saveBtn);

        Thread.sleep(3000);
        System.out.println("Wait 7");

        WebElement successMsgElement = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String expectedSuccessMsg = "Thanks for your response, Automation Wizard!";
        Assert.assertEquals(successMsgElement.getText().trim(),expectedSuccessMsg);








    //     Thread.sleep(3000);
    //     WebElement nameInputElement = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"));
    //     nameInputElement.sendKeys("Crio Learner");
    //     Thread.sleep(5000);
    //     long currentEpochTimeInSeconds = System.currentTimeMillis() / 1000;
    //     WebElement descriptionInputElement = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
    //     descriptionInputElement.sendKeys("I want to be the best QA Engineer! " + currentEpochTimeInSeconds);

    //     WebElement radioButtonElement = driver.findElement(By.xpath("(//div[@class='vd3tt'])[1]"));
    //     radioButtonElement.click();

    //     String[] textToSelect = {"Java", "Selenium", "TestNG"};
    //     List<WebElement> checkboxOptionElement = driver.findElements(By.xpath("//span[@class='aDTYNe snByac n5vBHf OIC90c']"));
    //     for(WebElement list : checkboxOptionElement){
    //         String labelText = list.getText();
    //         for(String Text: textToSelect){
    //             if(labelText.equals(Text)){
    //                 list.click();
    //                 break;  
    //             }
    //         }
    //     }

    //     WebElement dropfdownListElement = driver.findElement(By.xpath("//div[@class='jgvuAb ybOdnf cGN2le t9kgXb llrsB']"));
    //     dropfdownListElement.click();
    //     Thread.sleep(3000);
    //     List<WebElement> dropdownOptions = driver.findElements(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf OIC90c LMgvRb']"));
    //     for(WebElement list:dropdownOptions){
    //         String optionList =list.getText();
    //         if(optionList.contains("Ms")){
    //         Thread.sleep(2000);
    //             list.click();
    //         }
    //     }

    //    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //     WebElement dateInput = driver.findElement(By.xpath("//input[@type='date']"));
    //     dateInput.click();
    //     Thread.sleep(3000);
    //     // LocalDateTime myDateobj = LocalDateTime.now().minusDays(7);
    //     // DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //     // String FormattedDate = myDateobj.format(myDateFormatter);
    //     LocalDate currenDate = LocalDate.now();
    //     LocalDate sevenDaysAgoDate = currenDate.minusDays(7);
    //     String formattedDate = sevenDaysAgoDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    //     Thread.sleep(2000);
    //     System.out.println("date is : "+ formattedDate);
    //     dateInput.sendKeys(formattedDate);
    //     // System.out.println("date is : "+ FormattedDate);
    //     dateInput.sendKeys(formattedDate);

    //     WebElement timeElement = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
    //     timeElement.click();
    //     LocalTime getCurrenTime = LocalTime.now(); 
    //     String formattedTime = getCurrenTime.format(DateTimeFormatter.ofPattern("HH:HH"));
    //     timeElement.clear();
    //     timeElement.sendKeys(formattedTime);

    //     WebElement timeHrElement = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
    //     timeHrElement.click();
    //     LocalTime getCurrenTimeMin = LocalTime.now(); 
    //     String formattedTimeMin = getCurrenTimeMin.format(DateTimeFormatter.ofPattern("mm:mm"));
    //     timeElement.clear();
    //     timeElement.sendKeys(formattedTimeMin);

    }
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}