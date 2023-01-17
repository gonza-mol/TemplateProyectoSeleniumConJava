package utilities;

import com.ctc.wstx.util.SymbolTable;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    public static String Rep = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());

    public static ExtentReports getInstance(){
        if(extent==null){
            extent= new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\java\\Screenshots\\"+"Report"+ Rep +".html", true, DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\ReportsConfig.xml"));
        }
        return extent;
    }
}