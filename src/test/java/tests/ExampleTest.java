package tests;
import base.TestBase;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExampleTest extends TestBase {



    @Test
    public void loginAsASimpleUser() throws InterruptedException {
        log.debug("Inside Login Test");
        Thread.sleep(2000);
        log.debug("Login successfully");
        log.info("log info executed");
        Assert.assertTrue(1>0);
        try
        {
            log.info("Trying to Login");
            Reporter.log("from the TC");

        }
        catch (NoSuchElementException e)
        {
            System.out.println("See the error");
        }


    }



}
