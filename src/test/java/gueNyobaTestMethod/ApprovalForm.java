package gueNyobaTestMethod;

import capture.TakeScreenshot;
import elementsPage.BaseAction;
import elementsPage.Const;
import org.openqa.selenium.*;
import readFile.ReadCSVFormApproval;
import runner.AppFormRunner;
import testData.ReadTestData;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import elementsPage.ApprovalFormPage;
import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LibUtils.*;
import static runner.AppFormRunner.extent;
import static runner.AppFormRunner.extent_test_case;

import java.security.SecureRandom;
import java.util.Random;

public class ApprovalForm extends BaseAction {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + NUMBERS;
    private static final Random RANDOM = new SecureRandom();

    public static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALL_CHARS.charAt(RANDOM.nextInt(ALL_CHARS.length())));
        }
        return sb.toString();
    }

    String char5000 = generate(5000);
    String char4999 = generate(4999);

    public static final String PatternDate = "dd/MM/yyyy HH:mm:ss";

    public static final By userId = By.id("username");
    public static final By pwd = By.id("password");
    public static final By btnLogin = By.xpath("//button[contains(.,'Sign In')]");
    public static final By btnProfile = By.xpath("//a[@id='header-foto-profil']");
    public static final By btnLogout = By.linkText("Logout");

    public static final By body = By.cssSelector("body");
    public static final By menuApprovalForm = By.xpath("//a[contains(@href, 'approval-form-process')]");
    public static final By txtSearch = By.id("search-filter");
    public static final By rwDatafirstApp1 = By.xpath("//tr[@class='odd']//td[4]/a");
    public static final By txtTbl_source = By.xpath("//tr[@class='odd']//td[2]");
    public static final By txtTbl_nomorAplikasi = By.xpath("//tr[@class='odd']//td[3]");
    public static final By txtTbl_namaDebitur = By.xpath("//tr[@class='odd']//td[4]");
    public static final By txtTbl_partner = By.xpath("//tr[@class='odd']//td[5]");
    public static final By txtTbl_date = By.xpath("//tr[@class='odd']//td[6]");
    public static final By txtTbl_loanAmount = By.xpath("//tr[@class='odd']//td[7]");
    public static final By txtTbl_rate = By.xpath("//tr[@class='odd']//td[8]");
    public static final By txtTbl_status = By.xpath("//tr[@class='odd']//td[9]");
    public static final By txtTbl_reason = By.xpath("//tr[@class='odd']//td[10]");

    public static final By btnBackToTable = By.xpath("//h1/a[contains(@href,'approval-form')]");
    public static final By txtDetail_partner = By.xpath("(//div[contains(@class, 'pt-0')])[1]");
    public static final By txtDetail_namaDebitur = By.xpath("(//div[contains(@class, 'pt-0')])[2]");
    public static final By txtDetail_status = By.xpath("(//div[contains(@class, 'pt-0')])[3]");
    public static final By txtDetail_nomorAplikasi = By.xpath("(//div[contains(@class, 'pt-0')])[4]");
    public static final By txtDetail_tglPengajuan = By.xpath("(//div[contains(@class, 'pt-0')])[5]");
    public static final By txtDetail_jenisDebitur = By.xpath("(//div[contains(@class, 'pt-0')])[6]");
    public static final By txtDetail_plafon = By.xpath("(//div[contains(@class, 'pt-0')])[7]");
    public static final By txtDetail_jangkaWaktu = By.xpath("(//div[contains(@class, 'pt-0')])[8]");
    public static final By txtDetail_interestRate = By.xpath("(//div[contains(@class, 'pt-0')])[9]");
    public static final By txtDetail_nik = By.xpath("(//div[contains(@class, 'pt-0')])[10]");
    public static final By txtDetail_npwp = By.xpath("(//div[contains(@class, 'pt-0')])[11]");
    public static final By txtDetail_suppDoc = By.xpath("(//div[contains(@class, 'pt-0')])[14]");
    public static final By txtArea_recommend = By.cssSelector("textarea");
    public static final By txtAreaInput_recommend = By.name("recomendationNotes");
    public static final By optionlist_recommend = By.id("select2-dropdown-choice-container");
    public static final By option_recommend = By.xpath("//*[@id=\"dropdown-choice\"]/option[2]");
    public static final By option_NotRecommend = By.xpath("//*[@id=\"dropdown-choice\"]/option[3]");
    public static final By btnSubmitApp = By.id("btn-submit-recomendation");
    public static final By txtDetailH5_HasilRekomen = By.xpath("//h5[contains(text(),'Hasil Rekomendasi')]");
    public static final By txtDetailCatatan = By.xpath("(//div[contains(@class,'col-9')])[4]");
    public static final By approval_note = By.id("notes-field");
    public static final By optionlist_approve = By.xpath("//span[@id='select2-dropdown-choice-container']");
    public static final By option_approved = By.xpath("//*[@id=\"dropdown-choice\"]/option[text()='Approve']");
    public static final By option_rejected = By.xpath("//*[@id=\"dropdown-choice\"]/option[text()='Reject']");
    public static final By txtDetailH5_HasilKeputusan = By.xpath("//h5[contains(text(),'Hasil Keputusan')]");
    public static final By txtStrongUserApprove = By.xpath("//strong[contains(text(),'Reviewer dan Approver tidak boleh user yang sama')]");
    public static final By option_selectapproved = By.xpath("//span[text()='Approve']");
    public static final By formContentHeader = By.xpath("//h1[contains(@class,'page-name')]");
    String expected, value, value2, value3, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;

    private static final WebDriver driver = AppFormRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PatternDate);
    String formattedToday = simpleDateFormat.format(new Date());
    String tblWfr = "Waiting for Review";
    String dtlWfr = "Waiting for review";
    String tblApr = "Approved";


    ReadTestData rtd = new ReadTestData();


    public void login() throws IOException {

        rtd.testData();
        loginMaker(driver);

        String[] appFile = readCSVFormApproval.fileCSVApp();
        no_app1 = appFile[8];
//        no_app2 = appFile[16];
//        no_app3 = appFile[24];
//        no_app4 = appFile[32];
//        no_app5 = appFile[40];
//        no_app6 = appFile[48];
//        no_app7 = appFile[56];
//        no_app8 = appFile[64];

    }

    public void appFormMenu() {
        //Open Approval Form Menu
        click(driver, menuApprovalForm);
    }

    public void changeUserToMaker() throws InterruptedException {
        logoutApprover(driver);
        loginMaker(driver);
        menuApprovalForm();
    }

    public void logout() throws InterruptedException {
        logoutMaker(driver);
    }

    public void changeUserToApprove() throws InterruptedException {
        logoutMaker(driver);
        loginApprover(driver);
        menuApprovalForm();
    }

    public void tableApprovalForm() {
        isPresent(driver, rwDatafirstApp1);
    }

    public void menuApprovalForm() {
        click(driver, menuApprovalForm);
    }

    public void verifyDataSource() {
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_source);
        expected = "LOS";

        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataAppNo() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_nomorAplikasi);
        expected = no_app1;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataDebName() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_namaDebitur);
        expected = appFile[12];
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataPartner() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_partner);
        expected = rtd.companyName;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace("New ", "")
                        .toUpperCase()
                , expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataDate() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_date);
        expected = formattedToday.substring(0, 10);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 10), expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataLoanAmount() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_loanAmount);
        expected = String.valueOf(Long.parseLong(appFile[15]) / 100);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace("Rp. ", "")
                        .replace(".", "")
                , expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataRate() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_rate);
        expected = String.valueOf(Integer.parseInt(appFile[14]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace("%", "")
                        .replace(".", "")
                , expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDataStatus() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtTbl_status);
        expected = tblWfr;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void clickDebtorDetail() {

        click(driver, txtTbl_namaDebitur);
    }

    public void verifyDetailPartnerName() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_partner);
        expected = rtd.companyName;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace("New ", "")
                        .toUpperCase()
                , expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailDebtorName() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_namaDebitur);
        expected = appFile[12];
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailStatus() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_status);
        expected = dtlWfr;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailNoApp() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_nomorAplikasi);
        expected = no_app1;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailTanggalPengajuan() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        Date datenow = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String actualdatenow = formatter.format(datenow);
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_tglPengajuan);
        expected = actualdatenow;
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 10), expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailJenisDebitur() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_jenisDebitur);
        expected = appFile[11];
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.substring(0, 1), expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailPlafon() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_plafon);
        expected = String.valueOf(Long.parseLong(appFile[15]) / 100);
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace("Rp. ", "")
                        .replace(".", "")
                , expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailJangkaWaktu() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_jangkaWaktu);
        expected = String.valueOf(Integer.parseInt(appFile[13]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value.replace(" Bulan", ""), expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailInterestRate() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_interestRate);
        expected = String.valueOf(Integer.parseInt(appFile[14]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace("%", "")
                        .replace(".", "")
                , expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailNIK() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_nik);
        expected = appFile[9];
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }

    public void verifyDetailNPWP() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_npwp);
        expected = appFile[10];
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value
                        .replace(".", "")
                        .replace("-", "")
                , expected);
        takeScreenshot.capture(driver);
    }

    public void verifyDetailSupDoc() throws IOException {
        iRowPictName = iRowPictName + iSeq;
        String[] appFile = readCSVFormApproval.fileCSVApp();
        value = getText(driver, txtDetail_suppDoc);
        expected = "";
        createTest(iRowPictName, extent_test_case, extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }

    public void debtorDetailWaitingReview() {

        writeText(driver, txtSearch, no_app1);
        isPresent(driver, rwDatafirstApp1);
        value = getText(driver, txtTbl_status);
        click(driver, rwDatafirstApp1);
        value2 = getText(driver, txtDetail_status);
        scrollDown(driver, txtArea_recommend);
    }

    public void clickDetailDropdown() throws InterruptedException {
        iRowPictName = 22;
        scrollDown(driver, txtArea_recommend);
        click(driver, optionlist_approve);
        List<WebElement> list = driver.findElements(By.id("dropdown-choice"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            value = list.get(i).getText().replace("\n", "");
        }
        boolean textAreaRecommendation = driver.findElement(txtAreaInput_recommend).isDisplayed();
        expected = "-Pilih Rekomendasi-RecommendedNot Recommended";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, extent_test_case, extent);
        Thread.sleep(1000);
        takeScreenshot.capture(driver);
        verifyValue(value, expected);

        click(driver, option_recommend);
        click(driver, optionlist_recommend);
        takeScreenshot.capture(driver);

        verifyValueDisplay(textAreaRecommendation, true, "Element textarea recommend IsDisplay");
    }

    public void submitRecommend() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, txtAreaInput_recommend, char5000);
        click(driver, txtDetail_status);
        value = getText(driver, txtDetail_status);
        expected = "Waiting Approval";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);
        Thread.sleep(100);
        click(driver, btnSubmitApp);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_status);
        verifyValue(value, expected);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        value = getText(driver, txtDetailCatatan);
        expected = char5000;

        scrollPageDown(driver, btnBackToTable);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);
        Thread.sleep(1000);
        takeScreenshot.capture(driver);

        verifyValue(value, expected);
        scrollUp(driver, btnBackToTable);
        scrollUp(driver, btnBackToTable);
        Thread.sleep(1000);
        click(driver, btnBackToTable);
        Thread.sleep(1000);

    }

    public void submitNotRecommended() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        click(driver, rwDatafirstApp1);

        isPresent(driver, txtDetail_nomorAplikasi);
        scrollDown(driver, txtArea_recommend);
        click(driver, optionlist_recommend);
        click(driver, option_NotRecommend);
        click(driver, optionlist_recommend);
        scrollUp(driver, body);
        Thread.sleep(100);

        value = getText(driver, txtDetail_status);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        scrollDown(driver, txtArea_recommend);
        writeText(driver, txtAreaInput_recommend, char4999);
        click(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);
        Thread.sleep(100);
        click(driver, btnSubmitApp);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        value = getText(driver, txtTbl_status);
        verifyValue(value, expected);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        value = getText(driver, txtDetailCatatan);
        expected = char4999;

        scrollPageDown(driver, btnBackToTable);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);
        Thread.sleep(1000);
        takeScreenshot.capture(driver);

        verifyValue(value, expected);
        scrollUp(driver, btnBackToTable);
        scrollUp(driver, btnBackToTable);
        Thread.sleep(1000);
        click(driver, btnBackToTable);
        Thread.sleep(1000);
    }

    public void clickDebtorNameWithWaitingApproval() throws InterruptedException {
        iRowPictName = 25;

        writeText(driver, txtSearch, no_app1);
        isPresent(driver, rwDatafirstApp1);
        click(driver, rwDatafirstApp1);

        value = getText(driver, txtDetail_status);
        scrollPageDown(driver, btnBackToTable);
        scrollDown(driver, btnBackToTable);
        Thread.sleep(3000);
        click(driver, optionlist_approve);
        List<WebElement> lists = driver.findElements(By.id("dropdown-choice"));
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).getText());
            value = lists.get(i).getText().replace("\n", "");
        }
        boolean textAreaApproval = driver.findElement(approval_note).isDisplayed();
        expected = "-Pilih Keputusan-ApproveReject";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        Thread.sleep(100);
        takeScreenshot.capture(driver);
        Thread.sleep(Const.delay);
        verifyValue(value, expected);

        click(driver, option_approved);
        click(driver, txtDetailH5_HasilKeputusan);
        takeScreenshot.capture(driver);
        Thread.sleep(Const.delay);
        verifyValueDisplay(textAreaApproval, true, "Element textarea approval IsDisplay");
    }

    public void approveDebtorwith5000charAndSubmit() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        writeText(driver, approval_note, "RanString3");
        value = getText(driver, txtDetail_status);

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);
        Thread.sleep(1000);
        click(driver, btnSubmitApp);
        value = getText(driver, txtStrongUserApprove);
        takeScreenshot.capture(driver);

        if (isPresent(driver, txtStrongUserApprove)) {
            System.out.println("Change Account...");
            changeUserToApprove();
        } else {
            value = getText(driver, txtDetail_status);
            takeScreenshot.capture(driver);
        }
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_status);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        scrollPageDown(driver, btnBackToTable);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        writeText(driver, approval_note, char5000);
        value = getText(driver, txtDetail_status);
        click(driver, optionlist_approve);
        click(driver, option_approved);
        click(driver, txtDetailH5_HasilKeputusan);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);
        Thread.sleep(1000);
        click(driver, btnSubmitApp);
        Thread.sleep(1000);

        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_status);
        expected = "Approved";
        verifyValue(value, expected);
        Thread.sleep(100);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        expected = char5000;
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }

    public void rejectDebtorwith4999charAndSubmit() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        click(driver, rwDatafirstApp1);
        value = getText(driver, txtDetail_status);
        scrollDown(driver, btnBackToTable);
        Thread.sleep(100);
        scrollDown(driver, btnBackToTable);
        Thread.sleep(100);
        click(driver, optionlist_approve);
        click(driver, option_rejected);
        click(driver, txtDetailH5_HasilKeputusan);
        scrollUp(driver, body);
        Thread.sleep(1000);
        click(driver, btnBackToTable);

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        takeScreenshot.capture(driver);

        scrollDown(driver, btnBackToTable);
        Thread.sleep(100);
        scrollDown(driver, btnBackToTable);
        Thread.sleep(100);
        click(driver, optionlist_approve);
        click(driver, option_rejected);
        click(driver, txtDetailH5_HasilKeputusan);

        writeText(driver, approval_note, char4999);
        value = getText(driver, option_approved);
        takeScreenshot.capture(driver);

        scrollUp(driver, body);
        Thread.sleep(1000);
        click(driver, btnSubmitApp);
        Thread.sleep(1000);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        value = getText(driver, txtTbl_status);
        expected = "Rejected";
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        expected = char4999;
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }

    public void clickDebtorNameApproved() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value = getText(driver, txtTbl_status);
        expected = "Approved";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }

    public void clickDebtorNameRejected() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app8);
        value = getText(driver, txtTbl_status);
        expected = "Rejected";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, AppFormRunner.extent_test_case, AppFormRunner.extent);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        isPresent(driver, txtDetail_nomorAplikasi);
        value = getText(driver, txtDetail_status);
        takeScreenshot.capture(driver);

        click(driver, btnBackToTable);
    }

    public void changeAllAppNotoApproved() throws InterruptedException, IOException {
        changeUserToMaker();
        menuApprovalForm();

        String[] appFile = readCSVFormApproval.fileCSVApp();
        Long getCount = Arrays.stream(appFile).count();

        int index = 8;
        for (int i = index; i < appFile.length; i++) {
            if (i % index == 0) {
                clearText(driver, txtSearch);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearch, appFile[i]);
                value = getText(driver, txtTbl_status).toLowerCase();
                if (value.equals("waiting for review")) {
                    click(driver, rwDatafirstApp1);

                    scrollDown(driver, txtArea_recommend);
                    scrollDown(driver, txtArea_recommend);
                    click(driver, optionlist_recommend);
                    click(driver, option_recommend);
                    click(driver, optionlist_recommend);
                    Thread.sleep(Const.delay);
                    writeText(driver, txtAreaInput_recommend, "TEST AT Approval Form Recommended");

                    scrollUp(driver, body);
                    Thread.sleep(100);
                    click(driver, btnSubmitApp);
                    index = index + 8;
                } else {
                    index = index + 8;
                }
            }
        }
        changeUserToApprove();
        index = 8;
        for (int i = index; i < appFile.length; i++) {
            if (i % index == 0) {
                clearText(driver, txtSearch);
                isPresent(driver, rwDatafirstApp1);
                writeText(driver, txtSearch, appFile[i]);
                value = getText(driver, txtTbl_status).toLowerCase();
                if (value.equals("waiting approval")) {
                    click(driver, rwDatafirstApp1);

                    scrollPageDown(driver, btnBackToTable);
                    scrollDown(driver, btnBackToTable);
                    scrollDown(driver, btnBackToTable);

                    writeText(driver, approval_note, "TEST AT Approval Form Approved");
                    value = getText(driver, option_approved);
                    click(driver, optionlist_approve);
                    click(driver, option_approved);
                    click(driver, By.xpath("//span[@data-select2-id=1]"));

                    scrollUp(driver, body);Thread.sleep(1000);
                    click(driver, btnSubmitApp);
                    index = index + 8;
                } else {
                    index = index + 8;
                }
            }
            clearText(driver, txtSearch);
        }

    }
}