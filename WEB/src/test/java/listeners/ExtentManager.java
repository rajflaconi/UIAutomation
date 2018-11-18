package listeners;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static Platform platform;
    private static String reportFileName = "Test-Automation-Report.html";
    private static String macPath = System.getProperty("user.dir")+ "/TestReport";
    private static String windowsPath = System.getProperty("user.dir")+ "\\TestReport";
    private static String macReportFileLoc = macPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
       
        // set the report logo as company logo

        htmlReporter.config().setReportName("<img src='data:image/jpeg;base64,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'");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    //Select the extent report file location based on platform
    private static String getReportFileLocation (Platform platform) {
        String reportFileLocation = null;
        switch (platform) {
            
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }

    //Create the report path if it does not exist
    private static void createReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    //Get current platform
    private static Platform getCurrentPlatform () {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                platform = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                platform = Platform.MAC;
            }
        }
        return platform;
    }

}