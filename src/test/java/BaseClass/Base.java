package BaseClass;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;



public class Base {
    public static WebDriver driver;
    public static Properties properties;
    public static Logger logger;


    @BeforeClass
    @Parameters("{browser}")
    public void setup(@Optional("siva") String br) throws FileNotFoundException {

       properties= new Properties();

        FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\Config\\Config.properties");
        try {

            properties.load(fis);
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        logger= Logger.getLogger("GCBANK");
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Config\\log.properties");

        if ( br.equals("chrome" )) {
            properties.getProperty("chrome");
            driver = new ChromeDriver();
        }else if ( br.equals("firefox") ){
            properties.getProperty("firefox");
            driver=new FirefoxDriver();
        }else if ( br.equals("ie") ){
            properties.getProperty("ie");
            driver=new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }



    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public static void takeScreenShot(WebDriver driver , String fileName) throws IOException {

        TakesScreenshot ts= (TakesScreenshot)driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"F:\\GCBANK\\ScreenShots\\"+fileName+".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot Taken");
    }



}














