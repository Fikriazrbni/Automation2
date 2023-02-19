package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import createDataCSV.DataCSV;
import elementsPage.Const;
import gueNyobaCreateCSV.CsvPengurus;
import io.cucumber.java.Before;
import io.cucumber.testng.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jobs.DummyAppForm_BU;
import net.bytebuddy.jar.asm.ModuleVisitor;
import org.apache.tools.ant.taskdefs.Move;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import writeFile.MoveFileScenario;
import writeFile.TempImages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static extentreports.ExtentReportsFile.report;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@appForm",
        features = {"src/test/resources/Features/appForm.feature"},
        glue = {"definitions"}
)
public class AppFormRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    private TestNGCucumberRunner testNGCucumberRunner;
    public static ExtentReports extent;
    public static ExtentTest extent_test_case;

    @BeforeTest
    public void setExtentReport() {
        extent = report();
    }

    @BeforeMethod
    public void cleanImages() throws IOException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        MoveFileScenario cleanImageFolder = new MoveFileScenario();
        cleanImageFolder.deletePNG();
        System.out.println("------CLEAN SUCCESSFULLY------");
        MoveFileScenario moveFileScenario = new MoveFileScenario();
        cleanImageFolder.dltDummyExist();
//        DataCSV dataCSV = new DataCSV();
//        dataCSV.dataDummy(Const.appFile, Const.reaFile, "10");
        CsvPengurus cp = new CsvPengurus();
        cp.dataDummy(Const.appFile, Const.reaFile, "8");
        DummyAppForm_BU connServer = new DummyAppForm_BU();
        connServer.serverAkses();

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(groups = "cucumber", description = "Running Approval Form !", dataProvider = "scenarios")
    public void runScenarioAppForm(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @AfterMethod
    public void close(){
        extent.flush();
        driver.close();
    }
}
