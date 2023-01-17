package base;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.ExtentManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger(TestBase.class.getName());
    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test;




    @BeforeSuite
    public void setUp() {
        PropertyConfigurator.configure("C:\\Users\\admin\\Desktop\\Zeconomy Test\\Zeconomy Automation Project\\Zeconomy\\src\\test\\java\\log4j.properties");
        if(driver==null){
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.debug("Config file loaded!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\users.properties");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
                log.debug("OR file loaded!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(config.getProperty("browser").equals("firefox")){

                String pathDriver= System.getProperty("user.dir")+"\\src\\test\\java\\executables\\geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", pathDriver);
                driver= new FirefoxDriver();
                log.debug("Firefox launched!!!");
            }
            else if(config.getProperty("browser").equals("chrome")){
                String pathDriver= System.getProperty("user.dir")+"\\src\\test\\java\\executables\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", pathDriver);
                driver= new ChromeDriver();
                log.debug("Chrome launched!!!");
                log.info("This logs for info");

            }
            else if(config.getProperty("browser").equals("ie")){
                String pathDriver= System.getProperty("user.dir")+"\\src\\test\\java\\executables\\IEDriverServer.exe";
                System.setProperty("webdriver.chrome.driver", pathDriver);
                driver= new InternetExplorerDriver();
                log.debug("IE launched!!!");
            }
            driver.manage().window().maximize();
            driver.get(config.getProperty("testsiteurl"));
            log.debug("Navitaed to!!!: "+config.getProperty("testsiteurl"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }


    @AfterSuite
    public void tearDown(){
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
        log.debug("Test execution completed");
    }

}
