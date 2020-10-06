package com.assignment_5.user_story_3;



import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User_Story_3_AC_6 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
    }

    @Test
    public void add_mention_icon() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("helpdesk18@cybertekschool.com");
        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("UserUser");
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();

        WebElement eventTab =driver.findElement(By.xpath("//span[.='Event']"));
        eventTab.click();

        WebElement startDate =driver.findElement(By.id("feed-cal-event-fromcal_3Jcl"));
        startDate.click();

        WebElement selectStartDate=driver.findElement(By.xpath("//a[.='12']"));
        selectStartDate.click();

        WebElement deleteHour = driver.findElement(By.id("feed_cal_event_from_timecal_3Jcl"));
        deleteHour.click();
        deleteHour.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(30000);


        WebElement hour = driver.findElement(By.xpath("//td[@title='Increase (Up)']"));

        for (int i = 0; i<=12; i++){

            hour.click();

            if (i==5){
                break;
            }
        }
        WebElement deleteMinute = driver.findElement(By.xpath("//input[@title='Minutes']"));
        deleteMinute.click();
        deleteMinute.sendKeys(Keys.CLEAR);
        Thread.sleep(3000);
        WebElement minute = driver.findElement(By.xpath("//div[@id='feed_cal_event_from_timecal_3Jcl_div']//div[2]//table[2]//td[2]"));

        for (int i = 0; i<=12; i++) {

            minute.click();

            if (i == 11) {
                break;
            }
        }
        WebElement pm_am = driver.findElement(By.className("bxc-am-pm"));
        pm_am.click();
        Thread.sleep(2000);
        WebElement setTime = driver.findElement(By.xpath("//input[@value='Set Time']"));
        setTime.click();


        WebElement EndDate = driver.findElement(By.id("feed-cal-event-tocal_3Jcl"));
        EndDate.click();

        WebElement months = driver.findElement(By.className("bx-calendar-top-month"));
        months.click();
        Thread.sleep(1000);
        WebElement October = driver.findElement(By.xpath("//div[@class='bx-calendar-month-content']//span[10]"));
        October.click();
        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//div[@class='bx-calendar-layer']//div//a[5]"));
        day.click();

        WebElement timeZone= driver.findElement(By.xpath("//span[@class='feed-ev-tz-open']"));
        timeZone.click();










    }
}
