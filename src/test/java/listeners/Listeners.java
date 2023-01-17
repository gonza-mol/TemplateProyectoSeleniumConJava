package listeners;

import base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.TestUtil;

import java.io.IOException;

public class Listeners extends TestBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        test= rep.startTest(result.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getName().toUpperCase()+"-- Pass Ok");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, result.getName().toUpperCase()+"-- Failed with exception: "+result.getThrowable());
        test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));

        //Reporter.log("Click to see the screenshot");
        //Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
        //Reporter.log("<a href=\"C:\\Users\\User\\Desktop\\Automation\\Selenium webdriver with java-Basics to Advanced+Frameworks\\DataDrivenFramework\\src\\test\\java\\Screenshot\\"+TestUtil.screenshotName+"\">Screenshot</a>");
        //Reporter.log("<br>");
        //Reporter.log("<br>");
        //Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height='600' width='600'></img></a>");
        rep.endTest(test);
        rep.flush();



    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {


    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
