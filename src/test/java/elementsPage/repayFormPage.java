package elementsPage;

import capture.TakeScreenshot;
import readFile.ReadCSVFormApproval;
import runner.RepaymentRunner;
import testData.ReadTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LibUtils.*;
import static runner.RepaymentRunner.extent;
import static runner.RepaymentRunner.extent_test_case;

public class repayFormPage extends BaseAction {
    public static final String PatternDate          = "dd/MM/yyyy HH:mm:ss";

    public static final By userId                   = By.id("username");
    public static final By pwd                      = By.id("password");
    public static final By btnLogin                 = By.xpath("//button[contains(.,'Sign In')]");
    public static final By btnProfile               = By.xpath("//a[@id='header-foto-profil']");
    public static final By btnLogout                = By.linkText("Logout");
    public static final By body                     = By.cssSelector("body");
    public static final By menuApprovalForm         = By.xpath("//a[contains(@href, 'approval-form-process')]");
    public static final By txtSearch                = By.id("search-filter");
    public static final By rwDatafirstApp1          = By.xpath("//tr[@class='odd']//td[4]/a");
    public static final By btnBackToTable           = By.xpath("//h1/a[contains(@href,'approval-form')]");
    public static final By menuRepayment            = By.xpath("//li/a[@href='/repayment-form']");
    public static final By sourceDropDown           = By.xpath("//span[@id='select2-source-container']");
    public static final By sourceAll                = By.xpath("//li[@role=\"option\"][text()=\"All\"]");
    public static final By sourceLos                = By.xpath("//li[@role=\"option\"][text()=\"LOS\"]");
    public static final By sourceNikel              = By.xpath("//li[@role=\"option\"][text()=\"NIKEL\"]");
    public static final By sourceByAll              = By.xpath("//span[@id='select2-source-container'][text() = 'All']");
    public static final By sourceByNikel            = By.xpath("//span[@id='select2-source-container'][text() = 'NIKEL']");
    public static final By sourceByLOS              = By.xpath("//span[@id='select2-source-container'][text() = 'LOS']");
    public static final By sourceRow1               = By.xpath("//tr[@class = 'odd'][1]//td[2]");
    public static final By pelunasanDropDown        = By.xpath("//span[@id='select2-filter-payment-container']");

    public static final By pelunasanByYes            = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'Yes']");
    public static final By pelunasanByNo            = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'No']");
    public static final By pelunasanByInsurance            = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'Insurance']");
    public static final By pelunasanByAdvance            = By.xpath("//span[@id='select2-filter-payment-container'][text() = 'Advance']");
    public static final By pelunasanAll            = By.xpath("//li[@role='option'][text()='All']");
    public static final By pelunasanYes            = By.xpath("//li[@role='option'][text()='Yes']");
    public static final By pelunasanNo            = By.xpath("//li[@role='option'][text()='No']");
    public static final By pelunasanInsu            = By.xpath("//li[@role='option'][text()='Insurance']");
    public static final By pelunasanAdvan            = By.xpath("//li[@role='option'][text()='Advance']");
    public static final By pelunasanBy            = By.xpath("//span[@id = 'select2-filter-payment-container']");
    public static final By statusDropDown           = By.xpath("//span[@id='select2-filter-status-container']");
    public static final By statusAll                = By.xpath("//li[@role='option'][text()='All']");
    public static final By statusWait               = By.xpath("//li[@role='option'][text()='Waiting for approval']");
    public static final By statusPending                = By.xpath("//li[@role='option'][text()='Pending Batch Run']");
    public static final By statusApproved                = By.xpath("//li[@role='option'][text()='Approved']");
    public static final By statusRejected                = By.xpath("//li[@role='option'][text()='Rejected']");
    public static final By statusAppExp                = By.xpath("//li[@role='option'][text()='Approval Expired']");
    public static final By statAmountDropDown            = By.xpath("//span[@id='select2-filter-status-repayment-container']");
    public static final By statAmountAll            = By.xpath("//li[@role='option'][text()='All']");
    public static final By statAmountSesuai            = By.xpath("//li[@role='option'][text()='Sesuai']");
    public static final By statAmountKurangBayar            = By.xpath("//li[@role='option'][text()='Kurang Bayar']");
    public static final By statAmountLebihBayar            = By.xpath("//li[@role='option'][text()='Lebih Bayar']");
    public static final By searchField                   = By.xpath("//input[@placeholder='Search'][@type='text']");
    public static final By sourceTbl                   = By.xpath("(//tr[@class='odd']//td[2])[1]");
    public static final By appNoTbl                   = By.xpath("(//tr[@class='odd']//td[3]/a)[1]");
    public static final By partnerTbl                   = By.xpath("(//tr[@class='odd']//td[4])[1]");
    public static final By debNameTbl                   = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By pembayaranTbl               = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By statusTbl                   = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By datePembayaranTbl           = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By totalPembayaranTbl          = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By totalTagihanTbl            = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By statusAmountTbl            = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By dateCosumeTbl               = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By batchNoTbl                 = By.xpath("(//tr[@class='odd']//td[5])[1]");
    public static final By partnerOption             = By.xpath("//ul[@id ='select2-filterSource-results']");
    public static final By partnerDropDown             = By.xpath("//span[@id ='select2-filterSource-container']");
    public static final By partnerAll                  = By.xpath("//li[@role='option'][text()='All']");
    public static final By partnerAkseleran            = By.xpath("//li[contains(@data-select2-id,'L000001')]");
    public static final By partnerIndodana            = By.xpath("//li[contains(@data-select2-id,'L000007')]");
    public static final By amountRepaymentDropDown            = By.xpath("//*[@id ='select2-filter-status-repayment-container']");
    public static final By amountRepaymentOption            = By.xpath("//ul[@id='select2-filter-status-repayment-results']");
    public static final By amountRepaymentAll            = By.xpath("//li[@role='option'][text()='All']");
    public static final By amountRepaymentSesuai            = By.xpath("//li[@role='option'][text()='Sesuai']");
    public static final By amountRepaymentKurangBayar         = By.xpath("//li[@role='option'][text()='Kurang Bayar']");
    public static final By amountRepaymentLebihBayar          = By.xpath("//li[@role='option'][text()='Lebih Bayar']");
    public static final By batchNoDropDown                 = By.xpath("//*[@id='select2-filter-batch-number-container']");
    public static final By batchNoOption                      = By.xpath("//ul[@id='select2-filter-batch-number-results']");
    public static final By batchNoAll                      = By.xpath("[//li[@role='option'][text()='All']");
    public static final By batchNo1                      = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[2]");
    public static final By batchNo2                      = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[3]");
    public static final By batchNo3                      = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[4]");
    public static final By batchNo4                      = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[5]");
    public static final By batchNo5                      = By.xpath("//ul[@id='select2-filter-batch-number-results']//li[6]");


    private static final WebDriver driver = RepaymentRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    String expected, expected2, value, value2, value3, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PatternDate);
    String formattedToday = simpleDateFormat.format(new Date());


    public void login() throws IOException {
        loginMaker(driver);
    }
    public void logout() throws InterruptedException {
        logoutMaker(driver);
    }
    public void menuRepayment() {
        click(driver, menuRepayment);
    }
    public void setSourceAll() {click(driver, sourceDropDown);click(driver, sourceAll);}
    public void setPelunasanAll() {click(driver, pelunasanDropDown);click(driver, pelunasanAll);}
    public void setStatusAll() {click(driver, statusDropDown);
        scrollIntoView(driver, statusAll);
        click(driver, statusAll);}
    public void setPartnerAll() {click(driver, partnerDropDown);click(driver, partnerAll);}
    public void setStatusRepaymentAll() {click(driver, amountRepaymentDropDown);click(driver, amountRepaymentAll);}
    public void setBatchNoAll() {click(driver, batchNoDropDown);click(driver, batchNoAll);}
    public void verifyDropDownSource() {
        iRowPictName = 1 + iSeq;

        click(driver, sourceDropDown);
        expected ="AllLOSNIKEL";
        createTest(iRowPictName, extent_test_case, extent);

        List<WebElement> lists = driver.findElements(By.id("source"));
        for (int i = 0; i < lists.size(); i++) {
            value = lists.get(i).getText().replace("\n", "");
        }
        takeScreenshot.capture(driver);
        verifyList(value,expected);
    }
    public void filterSourceAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        String[] listSource = {"All","LOS","NIKEL"};
        click(driver, sourceAll); Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        value = getText(driver, sourceByAll);
        expected = "All";

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[2] | //tr[@class='even']//td[2]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            value = list.get(i).getText();
            verifyListAll(Arrays.stream(listSource).anyMatch(value::equals), value);
        }
    }
    public void filterSourceLos() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, sourceDropDown);
        click(driver, sourceLos);
        expected = "LOS";
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value ekspektasi data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[2] | //tr[@class='even']//td[2]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++){
            value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void filterSourceNikel() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, sourceDropDown);
        click(driver, sourceNikel);
        expected = "NIKEL";

        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value ekspektasi data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']//td[2] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++){
            value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void verifyPelunasanDropDown() {
        iRowPictName = iRowPictName + iSeq;
        createTest(iRowPictName, extent_test_case,extent);

        click(driver, pelunasanDropDown);
        List<WebElement> list = driver.findElements(By.id("filter-payment"));
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getText().replace("\n", "");
        }
        expected = "AllYesNoInsuranceAdvance";
        verifyList(expected, value);
        takeScreenshot.capture(driver);
    }
    public void pelunasanByAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        String[] listSource = {"All","Yes","No","Insurance","Advance"};
        click(driver, pelunasanAll); Thread.sleep(300);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        value = getText(driver, sourceByAll);
        expected = Arrays.toString(listSource);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            value = list.get(i).getText();
            verifyListAll(Arrays.stream(listSource).anyMatch(value::equals), value);
        }

    }
     public void pelunasanByYes() throws InterruptedException {
         iRowPictName = iRowPictName + iSeq;

         click(driver, pelunasanDropDown);
         click(driver, pelunasanYes);
         expected = getText(driver, pelunasanByYes);
         Thread.sleep(500);

         createTest(iRowPictName, extent_test_case, extent);
         createInfo(extent_test_case, "Value source data list : "+expected);
         takeScreenshot.capture(driver);

         //Validate data table source list
         List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
         createInfo(extent_test_case,"Jumlah Row    :" +list.size());
         for (int i = 0; i< list.size(); i++) {
             String value = list.get(i).getText();
             verifyList(expected, value);
         }
    }
     public void pelunasanByNo() throws InterruptedException {
         iRowPictName = iRowPictName + iSeq;

         click(driver, pelunasanDropDown);
         click(driver, pelunasanNo);
         expected = getText(driver, pelunasanByNo);
         Thread.sleep(500);

         createTest(iRowPictName, extent_test_case, extent);
         createInfo(extent_test_case, "Value source data list : "+expected);
         takeScreenshot.capture(driver);

         //Validate data table source list
         List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
         createInfo(extent_test_case,"Jumlah Row    :" +list.size());
         for (int i = 0; i< list.size(); i++) {
             value = list.get(i).getText();
             verifyList(expected,value);
         }
    }
     public void pelunasanByInsurance() throws InterruptedException {
         iRowPictName = iRowPictName + iSeq;

         click(driver, pelunasanDropDown);
         click(driver, pelunasanInsu);
         expected = getText(driver, pelunasanByInsurance);
         Thread.sleep(500);

         createTest(iRowPictName, extent_test_case, extent);
         createInfo(extent_test_case, "Value source data list : "+expected);
         takeScreenshot.capture(driver);

         //Validate data table source list
         List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[6] | //tr[@class='even']//td[6]"));
         createInfo(extent_test_case,"Jumlah Row    :" +list.size());
         for (int i = 0; i< list.size(); i++) {
             value = list.get(i).getText();
             verifyList(expected,value);
         }
    }
     public void pelunasanByAdvance() {
         iRowPictName = iRowPictName + iSeq;
         createTestSkip(iRowPictName, extent_test_case, extent);
//        click(driver, pelunasanAdvan);
//
//        createTest(iRowPictName,extent_test_case,extent);
//        value = getText(driver, pelunasanBy);
//        expected = "All";
//        takeScreenshot.capture(driver);
//        verifyList(value, expected);
    }
    public void verifyStatusDropDown() {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);

        List<WebElement> list = driver.findElements(By.xpath("//ul[@id = 'select2-filter-status-results']"));
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getText().replace("\n","");
        }
        expected = "AllWaiting for approvalPending Batch RunApprovedRejectedApproval Expired";
        createTest(iRowPictName,extent_test_case,extent);
        takeScreenshot.capture(driver);
        verifyList(expected, value);

    }
    public void statusByAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusAll);
        String[] listStatus = {"All","Waiting for Approval","Pending Batch Run","Approved","Rejected","Approval Expired"};
        expected = Arrays.toString(listStatus);
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            value = list.get(i).getText();
                verifyListAll(Arrays.stream(listStatus).anyMatch(value::equals), value);
        }
    }
    public void statusByWaitingForApproval() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        click(driver, statusWait);
        expected = "Waiting for Approval";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void statusPendingBatchRun() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        click(driver, statusPending);
        expected = "Pending Batch Run";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : "+list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void statusApproved() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        scrollIntoView(driver, statusApproved);
        click(driver, statusApproved);
        expected = "Approved";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : "+list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void statusRejected() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        scrollIntoView(driver, statusRejected);
        click(driver, statusRejected);
        expected = "Rejected";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : "+list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void statusApprovalExpired() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, statusDropDown);
        scrollIntoView(driver, statusAppExp);
        click(driver, statusAppExp);
        expected = "Approval Expired";
        Thread.sleep(500);
        createTest(iRowPictName, extent_test_case, extent);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[7] | //tr[@class='even']//td[7] | //td[@class='dataTables_empty']"));
        createInfo(extent_test_case, "Jumlah Row    : "+list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void verifyPartnerDropDown() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, partnerDropDown);

        List<WebElement> list = driver.findElements(partnerOption);
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getText().replace("\n","").replace(" ","");
            System.out.println(value);
        }
        expected = "AllAKSELERANNEWKOMUNALKOPNUSCekBugsVerificatioKOMUNALMODALANDALANRUMAHMODALDANABARUDANABIJAKDANAKOINKOINANDALANRUMAHKOINDANAPINTARLEMINERALE" +
                "Cek123RealmeRealmeRealmeKOMUNALWingsLenovoIndofoodMIYAKOKOPNUSDOMPETPINJAMSHARPTOSHIBAMINISOCompanycompany2UANGKUIndodanaIndodana" +
                "PTTesAutoApproveTesAutoApproveIDVIndodanaKLIKA2CPTTesPendingTesPendingIDVAmartaSeaMoney-CFinanceSeaMoney-LDNAmartaSeaMoney-CFinanceSeaMoney-LDNtestCBASchecking";
        createTest(iRowPictName,extent_test_case,extent);
        takeScreenshot.capture(driver);
        verifyList(expected, value);
    }
    public void partnerAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, partnerAll);
        String[] listStatus = {"All","Indodana","AKSELERAN","NEWKOMUNAL","KOPNUS","SeaMoney"};
        expected = Arrays.toString(listStatus);
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[4] | //tr[@class='even']//td[4]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyListAll(Arrays.stream(listStatus).anyMatch(value::equals), value);
        }
    }
    public void partnerAkeseleran() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, partnerDropDown);
        click(driver, partnerAkseleran);
        expected = "AKSELERAN";
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[4] | //tr[@class='even']//td[4]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void amountRepaymentDropDownList() {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);

        List<WebElement> list = driver.findElements(amountRepaymentOption);
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getText().replace("\n","").replace(" ","");
            System.out.println(value);
        }
        expected = "AllSesuaiKurangBayarLebihBayar";
        createTest(iRowPictName,extent_test_case,extent);
        takeScreenshot.capture(driver);
        verifyList(expected, value);
    }
    public void amountRepaymentAll() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentAll);
        String[] listStatus = {"All","Sesuai","Kurang Bayar","Lebih Bayar"};
        expected = Arrays.toString(listStatus);
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyListAll(Arrays.asList(listStatus).contains(value), value);
        }
    }
    public void amountRepaymentSesuai() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);
        click(driver, amountRepaymentSesuai);
        expected = "Sesuai";
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void amountRepaymentKurangBayar() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);
        click(driver, amountRepaymentKurangBayar);
        expected = "Kurang Bayar";
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void amountRepaymentLebihBayar() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
        click(driver, amountRepaymentDropDown);
        scrollIntoView(driver, amountRepaymentLebihBayar);
        click(driver, amountRepaymentLebihBayar);
        expected = "Lebih Bayar";
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[11] | //tr[@class='even']//td[11]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            String value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
    public void batchNoDropDownList()  {
        iRowPictName = iRowPictName + iSeq;
        click(driver, batchNoDropDown);

        List<WebElement> list = driver.findElements(batchNoOption);
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getText().replace("\n","").replace(" ","");
            System.out.println(value);
        }
        expected = "All12345678910";
        createTest(iRowPictName,extent_test_case,extent);
        takeScreenshot.capture(driver);
        verifyList(expected, value);
    }
//    public void batchNoAll() throws InterruptedException {
//        iRowPictName = iRowPictName + iSeq;
//        click(driver, batchNoAll);
//        String[] listStatus = {"All","Sesuai","Kurang Bayar","Lebih Bayar"};
//        expected = Arrays.toString(listStatus);
//        Thread.sleep(500);
//
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Value source data list : "+expected);
//        takeScreenshot.capture(driver);
//
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[14] | //tr[@class='even']//td[14]"));
//        for (int i = 0; i< list.size(); i++) {
//            String value = list.get(i).getText();
//            verifyListAll(Arrays.asList(listStatus).contains(value), value);
//        }
//    }
    public void batchNo1 () throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;
//        click(driver, batchNoDropDown);
        click(driver, batchNo1);

        expected = "1";
        Thread.sleep(500);

        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Value source data list : "+expected);
        takeScreenshot.capture(driver);

        //Validate data table source list
        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[14] | //tr[@class='even']//td[14]"));
        createInfo(extent_test_case,"Jumlah Row    :" +list.size());
        for (int i = 0; i< list.size(); i++) {
            value = list.get(i).getText();
            verifyList(expected, value);
        }
    }
//    public void setBatchNo2 () throws InterruptedException {
//        iRowPictName = iRowPictName + iSeq;
//        click(driver, batchNoDropDown);
//        click(driver, batchNo2);
//
//        expected = "2";
//        Thread.sleep(500);
//
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Value source data list : "+expected);
//        takeScreenshot.capture(driver);
//
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[14] | //tr[@class='even']//td[14]"));
//        for (int i = 0; i< list.size(); i++) {
//            String value = list.get(i).getText();
//            verifyList(expected, value);
//        }
//    }
//    public void setBatchNo3 () throws InterruptedException {
//        iRowPictName = iRowPictName + iSeq;
//        click(driver, batchNoDropDown);
//        click(driver, batchNo3);
//
//        expected = "3";
//        Thread.sleep(500);
//
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Value source data list : "+expected);
//        takeScreenshot.capture(driver);
//
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[14] | //tr[@class='even']//td[14]"));
//        for (int i = 0; i< list.size(); i++) {
//            String value = list.get(i).getText();
//            verifyList(expected, value);
//        }
//    }
//    public void setBatchNo4 () throws InterruptedException {
//        iRowPictName = iRowPictName + iSeq;
//        click(driver, batchNoDropDown);
//        click(driver, batchNo4);
//
//        expected = "4";
//        Thread.sleep(500);
//
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Value source data list : "+expected);
//        takeScreenshot.capture(driver);
//
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[14] | //tr[@class='even']//td[14]"));
//        for (int i = 0; i< list.size(); i++) {
//            String value = list.get(i).getText();
//            verifyList(expected, value);
//        }
//    }
//    public void setBatchNo5 () throws InterruptedException {
//        iRowPictName = iRowPictName + iSeq;
//        click(driver, batchNoDropDown);
//        click(driver, batchNo5);
//
//        expected = "5";
//        Thread.sleep(500);
//
//        createTest(iRowPictName, extent_test_case, extent);
//        createInfo(extent_test_case, "Value source data list : "+expected);
//        takeScreenshot.capture(driver);
//
//        //Validate data table source list
//        List<WebElement> list = driver.findElements(By.xpath("//tr[@class='odd']//td[13] | //tr[@class='even']//td[13]"));
//        for (int i = 0; i< list.size(); i++) {
//            String value = list.get(i).getText();
//            verifyList(expected, value);
//        }
//    }
}
