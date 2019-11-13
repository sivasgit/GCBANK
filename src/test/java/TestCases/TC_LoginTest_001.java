package TestCases;

import BaseClass.Base;
import PageObjects.ManagerLogin;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC_LoginTest_001 extends Base {


    @Test


    public static void LoginTest( ) throws IOException {
        logger.info("*************Starting TC_LoginTest_001*************");

        driver.get(properties.getProperty("url"));
        ManagerLogin lp = new ManagerLogin(driver);
        logger.info("*****LOGIN TEST******");
        lp.setUserName(properties.getProperty("userid"));
        lp.setPassword(properties.getProperty("password"));
        lp.clickLogin();

        logger.info("****Title Test****");
        String exp_title = "Guru99 Bank Manager HomePage";
        String act_title = driver.getTitle();
        System.out.println(act_title);

        if ( exp_title.equals(act_title) ) {
            Assert.assertTrue(true);
        }
        else {

            takeScreenShot(driver,"LoginTest");
            Assert.assertTrue(false);

        }

    }

    @Test
    public void idVerification( ) {

        driver.findElement(By.xpath("//td[contains(text(),'Manger Id : mngr231349')]")).isDisplayed();

    }

}








