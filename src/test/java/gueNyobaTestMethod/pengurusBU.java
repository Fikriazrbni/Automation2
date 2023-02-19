package gueNyobaTestMethod;

import org.apache.bcel.generic.Select;
import org.apache.xmlgraphics.ps.PSFontUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import capture.TakeScreenshot;
import com.opencsv.exceptions.CsvException;
import elementsPage.BaseAction;
import jobs.DummyReaForm_BU;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import readFile.ReadCSVFormApproval;
import readFile.UpdateCSV;
import runner.FormApprovalRunner;
import runner.pengurusRunner;
import testData.ReadTestData;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LibUtils.*;
import static elementsPage.ApprovalFormPage.btnBackToTable;
import static elementsPage.ApprovalFormPage.rwDatafirstApp1;
import static elementsPage.RealizationFormPage.*;
import static runner.pengurusRunner.extent;
import static runner.pengurusRunner.extent_test_case;

public class pengurusBU extends BaseAction{

    public static final By noApp                    = By.xpath("//label[text() = 'Nomor Aplikasi :']//following-sibling::div");
    public static final By noUrutPengurus             = By.xpath("//tr[td='Nomor Urut Pengurus:']//following-sibling::td");
    public static final By jmlPengurus              =By.xpath("//tr[td='Jumlah Pengurus:']//following-sibling::td");
    public static final By sandiJbtBI               = By.xpath("//tr[td='Sandi Jabatan BI:']//following-sibling::td");
    public static final By pangsaKepemilikan        = By.xpath("//tr[td='Pangsa Kepemilikan:']//following-sibling::td");
    public static final By bentukPengurus           = By.xpath("//tr[td='Bentuk Pengurus:']//following-sibling::td");
    public static final By mdlDasar               = By.xpath("//tr[td='Modal Dasar:']//following-sibling::td");
    public static final By mdlDisetor             = By.xpath("//tr[td='Modal Disetor:']//following-sibling::td");
    public static final By mdlDitempatkan         = By.xpath("//tr[td='Modal Ditempatkan:']//following-sibling::td");
    public static final By npwpPeng                 = By.xpath("//tr[td='NPWP Pengurus:']//following-sibling::td");
    public static final By namaPeng                 = By.xpath("//tr[td='Nama Pengurus:']//following-sibling::td");
    public static final By altPeng                  = By.xpath("//tr[td='Alamat Pengurus:']//following-sibling::td");
    public static final By altKelurahan             = By.xpath("//tr[td='Alamat_Kelurahan:']//following-sibling::td");
    public static final By altKecamatan             = By.xpath("//tr[td='Alamat_Kecamatan:']//following-sibling::td");
    public static final By altDatiII                = By.xpath("//tr[td='Alamat_Dati II:']//following-sibling::td");
    public static final By noKtp                    = By.xpath("//tr[td='No. KTP:']//following-sibling::td");
    public static final By noAkte                   = By.xpath("//tr[td='No. Akte:']//following-sibling::td");
    public static final By tglLahir                 = By.xpath("//tr[td='Tanggal Lahir:']//following-sibling::td");
    public static final By tglAkte                  = By.xpath("//tr[td='Tanggal Akte:']//following-sibling::td");
    public static final By datiIILahir              = By.xpath("//tr[td='Dati II tempat lahir:']//following-sibling::td");
    public static final By jnsKelamin               = By.xpath("//tr[td='Jenis Kelamin:']//following-sibling::td");
    public static final By expand1               = By.xpath("//td[text() = '1']//following-sibling::td[1]");
    public static final By expand2               = By.xpath("//td[text() = '2']//following-sibling::td[1]");
    public static final By expand3               = By.xpath("//td[text() = '3']//following-sibling::td[1]");
    public static final By expand4               = By.xpath("//td[text() = '4']//following-sibling::td[1]");
    public static final By listSorting              = By.xpath("//td[@class='details-control sorting_1']");
    public static final By txtDetail_NoApp         = By.xpath("(//label[@class='col-form-label'])[3]");
    public static final By inputSearch             = By.id("myInput");
    public static final By pangsaList1               = By.xpath("//td[text()='1']//following-sibling::td[4]");
    public static final By pangsaList2               = By.xpath("//td[text()='2']//following-sibling::td[4]");
    public static final By pangsaList3               = By.xpath("//td[text()='3']//following-sibling::td[4]");
    public static final By pangsaList4               = By.xpath("//td[text()='4']//following-sibling::td[4]");
    private static final WebDriver driver = pengurusRunner.driver;
    int iSeq = 1;
    int row2 = 21;
    int row3 = 42;
    int row4 = 63;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    DummyReaForm_BU connServer = new DummyReaForm_BU();
    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime localDate   = LocalDateTime.now();
    LocalDateTime PastDate    = localDate.minusDays(1);
    String formattedToday     = localDate.format(dateTime);
    String formattedYesterday = PastDate.format(dateTime);
    String expected, value, no_app1,no_app2,no_app3,no_app4,no_app5,no_app6,no_app7,no_app8;


    public void login() throws IOException {
        readTestData.testData();
        readTestData.testDataMaintananceTable();
        loginApproverLdap(driver);

    }
    public void menuRealizationForm()   {
        click(driver, menuReaForm);
    }
    public void searchAppNo() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVApp();
        no_app1 = arr[8];
//        no_app2 = arr[24];

        writeText(driver, inputSearch, no_app1);
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);
        value    = getText(driver, txtDetail_NoApp);
        expected = arr[8];

    }
    public void logout(WebDriver conn) throws InterruptedException {
        logoutApprover(driver);
    }
    public void verifyNoApp17Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 67;

        value = getText(driver, noApp);
        expected = arr[21];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[21], arr[21].length(),17 );
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand1);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
    }
    public void verifyNoUrutPeng2Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 68;

        scrollPageDown(driver, dtlBtnApprove);
        value = getText(driver,noUrutPengurus);
        int expected2 = Integer.parseInt(removeZero(arr[22]));
        expected = String.valueOf(expected2);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[22],arr[22].length(),2 );
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

    }
    public void verifyJmlPeng2Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 69;

        value = getText(driver, jmlPengurus);
        int expected2 = Integer.parseInt(removeZero(arr[23]));
        expected = String.valueOf(expected2);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[23],arr[23].length(),2);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJbtnBI1Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 88;

        click(driver, expand2);
        value = getText(driver, sandiJbtBI);
        expected = ReadTestData.enumerasiSandiJabatan(arr[24+row2]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[24+row2], arr[24+row2].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJbtnBI2Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 70;

        value = getText(driver, sandiJbtBI);
        expected = ReadTestData.enumerasiSandiJabatan(arr[24]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[24],arr[24].length(),2);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyPangsa5Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 71;

        int ui = Integer.parseInt(getText(driver, pangsaKepemilikan).replace("%","").replace(".",""));
        value = String.valueOf(ui);
        long expected2 = Long.parseLong(arr[25]);
        expected = String.valueOf(expected2);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[25],arr[25].length(),5);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyBentukPengurus1Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 72;

        value = getText(driver, bentukPengurus);
        expected = ReadTestData.enumerasiBentukPengurus(arr[26]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[26],arr[26].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDasar13Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 89;

        value = getText(driver, mdlDasar);
        expected = String.valueOf(Integer.parseInt(arr[27+row2]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[27+row2],arr[27+row2].length(),13);
        verifyValue(value
                .replace("Rp. ","")
                .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDasar12Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 73;

        value = getText(driver, mdlDasar);
        expected = String.valueOf(Integer.parseInt(arr[27]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[27],arr[27].length(),12);
        verifyValue(value
                .replace("Rp. ","")
                .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDisetor13Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 90;

        value = getText(driver, mdlDisetor);
        expected = String.valueOf(Integer.parseInt(arr[28+row2]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[28+row2],arr[28+row2].length(),13);
        verifyValue(value
                .replace("Rp. ","").replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDisetor12Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 74;

        value = getText(driver, mdlDisetor);
        expected = String.valueOf(Integer.parseInt(arr[28]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[28],arr[28].length(),12);
        verifyValue(value
                .replace("Rp. ","")
                .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDitempatkan13Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 91;

        value = getText(driver, mdlDitempatkan);
        expected = String.valueOf(Integer.parseInt(arr[29+row2]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[29+row2],arr[29+row2].length(),13);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyModalDitempatkan12Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 75;

        value = getText(driver, mdlDitempatkan);
        expected = String.valueOf(Integer.parseInt(arr[29]));
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[29],arr[29].length(),12);
        verifyValue(value
                        .replace("Rp. ","")
                        .replace(".","")
                , expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNPWP15Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 76;

        value = getText(driver, npwpPeng);
        expected = arr[30];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[30],arr[30].length(),15);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifNamaPengurus60Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 92;

        scrollPageDown(driver,dtlBtnApprove); Thread.sleep(500);
        value = getText(driver, namaPeng);
        expected = arr[31+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31+row2],arr[31+row2].length(),60);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNamaPengurus59Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 77;
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);

        value = getText(driver, namaPeng);
        expected = arr[31];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[31],arr[31].length(),59);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltPeng40Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 93;

        value = getText(driver, altPeng);
        expected = arr[32+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32+row2],arr[32+row2].length(),40);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltPeng39Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 78;

        value = getText(driver, altPeng);
        expected = arr[32];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[32],arr[32].length(),39);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKelurahan40Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 94;

        value = getText(driver, altKelurahan);
        expected = arr[33+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33+row2],arr[33+row2].length(),40);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKelurahan39Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 79;

        value = getText(driver, altKelurahan);
        expected = arr[33];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[33],arr[33].length(),39);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKecamatan40Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 95;

        value = getText(driver, altKecamatan);
        expected = arr[34+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34+row2],arr[34+row2].length(),40);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltKecamatan39() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 80;

        value = getText(driver, altKecamatan);
        expected = arr[34];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[34],arr[34].length(),39);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyAltDatiII4Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 81;

        value = getText(driver, altDatiII);
        expected = ReadTestData.enumerasiDatiII(arr[35]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[35],arr[35].length(),4);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNoAkte30Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 96;

        value = getText(driver, noAkte);
        expected = arr[37+row2];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37+row2],arr[37+row2].length(),30);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyNoAkter29Char() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 82;

        value = getText(driver, noAkte);
        expected = arr[37];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[37],arr[37].length(),29);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTglAkte8Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 83;


        value = getText(driver, tglAkte);
        expected = arr[39];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[39],arr[39].length(),8);
        verifyValue(value
                .replace("/",""), expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJnsKelPengB() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 84;

        value = getText(driver, jnsKelamin);
        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41],arr[41].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
    }
    public void verifyJnsKelPengM() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 97;

        value = getText(driver, jnsKelamin);
        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41+row2]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[41+row2],arr[41+row2].length(),1);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);
        click(driver, expand2);
    }
    public void verifyNoKTP16Char() throws IOException {
            String[] arr = readCSVFormApproval.fileCSVPengurus();
            iRowPictName = 85;

            value = getText(driver, noKtp);
            expected = arr[36];
            createTest(iRowPictName, extent_test_case, extent);
            verifyLength(arr[36],arr[36].length(),16);
            verifyValue(value, expected);
            takeScreenshot.capture(driver);
    }
    public void verifyTglLhr8Num() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 86;

        value = getText(driver, tglLahir);
        expected = arr[38];
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[38],arr[38].length(),8);
        verifyValue(value
                .replace("/",""), expected);
        takeScreenshot.capture(driver);
    }
    public void verifyDatiIITmptLahir4Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 87;

        value = getText(driver, datiIILahir);
        expected = ReadTestData.enumerasiDatiII(arr[40]);
        createTest(iRowPictName, extent_test_case, extent);
        verifyLength(arr[40],arr[40].length(),4);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver,dtlBtnApprove); Thread.sleep(500);
        click(driver,expand1);
    }
    public void verifyDataPengLebihDari1() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 98;
        int pangsa1, pangsa2, pangsa3, pangsa4, totalPangsa;

        List<WebElement> list = driver.findElements(listSorting);
        value = "";
        for (WebElement webElement : list) {
            if (webElement.getText().contains("4"))
                value = webElement.getText();

        }
        expected = "4";
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Total Pengurus  :"+value);
        verifyValue(value, expected);
        takeScreenshot.capture(driver);

        //evidence pangsa kepemilikan total = 100%

        scrollIntoView(driver, pangsaList1);

        pangsa1 = Integer.parseInt(getText(driver, pangsaList1).replace(".","").replace("%",""));
        pangsa2 = Integer.parseInt(getText(driver, pangsaList2).replace(".","").replace("%",""));
        pangsa3 = Integer.parseInt(getText(driver, pangsaList3).replace(".","").replace("%",""));
        pangsa4 = Integer.parseInt(getText(driver, pangsaList4).replace(".","").replace("%",""));
        totalPangsa = pangsa1+pangsa2+pangsa3+pangsa4;

        createInfo(extent_test_case,"Jumlah pangsa :" + pangsa1+" + "+pangsa2+" + "+pangsa3+" + "+pangsa4+ " Total : " + totalPangsa + " Atau 100%");
        takeScreenshot.capture(driver);

        scrollIntoView(driver, listSorting);


        //open detail pengurus 1
        click(driver, expand1);
        createInfo(extent_test_case, "Pengurus 1");
        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand1);

        //open detail pengurus 2
        click(driver, expand2);
        createInfo(extent_test_case, "Pengurus 2");
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand2);

        //open detail pengurus 3
        click(driver, expand3);
        createInfo(extent_test_case, "Pengurus 3");
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand3);

        //open detail pengurus 4
        click(driver, expand4);
        createInfo(extent_test_case, "Pengurus 4");
        takeScreenshot.capture(driver);
        scrollPageDown(driver, dtlBtnApprove);Thread.sleep(500);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(500);
        click(driver, expand4);

    }
    public void verifyNoApp30Char() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 101;

        //Change appNo
//        scrollPageUp(driver,dtlBtnApprove); Thread.sleep(500);
//        click(driver,btnBackToTable);
//
//        String[] arrApp = readCSVFormApproval.fileCSVApp();
//        no_app1 = arrApp[16];
//        no_app2 = arrApp[24];
//
//        writeText(driver, inputSearch, no_app2);
//        click(driver, rwDatafirstApp1);
//        isPresent(driver, dtlAppId);
//
//
//        value = getText(driver, noApp);
//        expected = arr[21];
        createTestSkip(iRowPictName, pengurusRunner.extent_test_case, pengurusRunner.extent);
//        createTest(iRowPictName, extent_test_case, extent);
//        verifyLength(arr[21],arr[21].length(),30);
//        verifyValue(value, expected);
//        takeScreenshot.capture(driver);
    }
    public void verifyJnsKelPengL() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 99;

        click(driver, expand3);
        value = getText(driver, bentukPengurus);

        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41+row3]);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Bentuk Badan Usaha :" + value);
        takeScreenshot.capture(driver);

        scrollPageDown(driver,dtlBtnApprove); Thread.sleep(500);
        String value2 = getText(driver, jnsKelamin);
        verifyValue(value2, expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);
        click(driver, expand3);
    }
    public void verifyJnsKelPengP() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVPengurus();
        iRowPictName = 100;

        click(driver, expand4);
        value = getText(driver, bentukPengurus);

        expected = ReadTestData.enumerasiJnsKelPengurus(arr[41+row4]);
        createTest(iRowPictName, extent_test_case, extent);
        createInfo(extent_test_case, "Bentuk Badan Usaha :" + value);
        takeScreenshot.capture(driver);

        scrollPageDown(driver,dtlBtnApprove); Thread.sleep(500);
        String value2 = getText(driver, jnsKelamin);
        verifyValue(value2, expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove); Thread.sleep(500);
        click(driver, expand4);
    }
}
