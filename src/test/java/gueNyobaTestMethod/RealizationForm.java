package gueNyobaTestMethod;

import capture.TakeScreenshot;
import com.opencsv.exceptions.CsvException;
import elementsPage.BaseAction;
import jobs.DummyReaForm_BU;
import org.openqa.selenium.*;
import readFile.ReadCSVFormApproval;
import readFile.UpdateCSV;
import runner.ReaFormRunner;
import testData.ReadTestData;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static badanUsaha.LoginAsMaker.*;
import static badanUsaha.LoginAsApprover.*;
import static badanUsaha.LibUtils.*;
import static runner.ReaFormRunner.extent;
import static runner.ReaFormRunner.extent_test_case;

public class RealizationForm extends BaseAction {
    public static final By body                        = By.cssSelector("body");
    public static final By notif                       = By.xpath("//img[contains(@class, 'Attach')]");
    public static final By notifSeeAll                 = By.xpath("//span[contains(@class, 'See-All-Notification')]");
    public static final By menuReaForm                 = By.xpath("(//a[contains(@href, 'approval-form')])[1]");
    public static final By txtSearch                   = By.id("myInput");
    public static final By rwDatafirstApp1             = By.xpath("//tr[@class='odd']//td[4]/a");
    public static final By txtTbl_source               = By.xpath("//tr[@class='odd']//td[2]");
    public static final By txtTbl_nomorAplikasi        = By.xpath("//tr[@class='odd']//td[3]");
    public static final By txtTbl_namaDebitur          = By.xpath("//tr[@class='odd']//td[4]");
    public static final By txtTbl_partner              = By.xpath("//tr[@class='odd']//td[5]");
    public static final By txtTbl_date                 = By.xpath("//tr[@class='odd']//td[6]");
    public static final By txtTbl_loanAmount           = By.xpath("//tr[@class='odd']//td[7]");
    public static final By txtTbl_rate                 = By.xpath("//tr[@class='odd']//td[8]");
    public static final By txtTbl_status               = By.xpath("//tr[@class='odd']//td[9]");

    public static final By dtlBtnBack                  = By.xpath("//a/img[@class='Arrow-Left']");
    public static final By dtlBtnApprove               = By.xpath("//*[@id='approved']");
    public static final By dtlBtnReject                = By.xpath("//*[@id='rejected-form']");
    public static final By dtlTextConfirmApprove      = By.xpath("//*[@id=\"modal-body\"]/h6");
    public static final By dtlBtnConfirmYes            = By.xpath("//*[@id='formSubmit']");
    public static final By dtlBtnConfirmNo             = By.xpath("//*[@id='modal-cancel']");
    public static final By dtlModalConfirmReject       = By.xpath("//*[@id='modal-rejected']");
    public static final By dtlModalConfirmRejectType   = By.xpath("//*[@id='select2-rejectDescription-container']");
    public static final By dtlModalConfirmRejectList   = By.xpath("//*[@id='rejectDescription']");
    public static final By dtlModalConfirmRejectType_0 = By.xpath("//*[@id='rejectDescription']/option[1]");
    public static final By dtlModalConfirmRejectType_1 = By.xpath("//*[@id='rejectDescription']/option[2]");
    public static final By dtlModalConfirmRejectType_2 = By.xpath("//*[@id='rejectDescription']/option[3]");
    public static final By dtlModalConfirmRejectReason = By.xpath("//*[@name='rejectReason']");
    public static final By dtlBtnRejectYes             = By.xpath("(//*[@id='formSubmit'])[2]");
    public static final By dtlBtnRejectNo              = By.xpath("//*[@id='modal-cancel-reject']");

    public static final By dtlPartner                  = By.xpath("(//label[@class='col-form-label'])[1]");
    public static final By dtlDebtName                 = By.xpath("(//label[@class='col-form-label'])[2]");
    public static final By dtlStatus                   = By.xpath("//label[ @class='col-form-label btn-info btn-circle  btn-sm text-white text-center ']");
    public static final By dtlAppId                    = By.xpath("(//label[@class='col-form-label'])[3]");
    public static final By dtlDate                     = By.xpath("(//label[@class='col-form-label'])[4]");
    public static final By dtlCtgDebt                  = By.xpath("(//label[@class='col-form-label'])[5]");
    public static final By dtlLoanAmount               = By.xpath("(//label[@class='col-form-label'])[6]");
    public static final By dtlDuration                 = By.xpath("(//label[@class='col-form-label'])[7]");
    public static final By dtlInterestRate             = By.xpath("(//label[@class='col-form-label'])[8]");
    public static final By dtlCtgCredit                = By.xpath("(//label[@class='col-form-label'])[9]");
    public static final By dtlUtil                     = By.xpath("(//label[@class='col-form-label'])[10]");
    public static final By dtlPKNo                     = By.xpath("(//label[@class='col-form-label'])[11]");
    public static final By dtlContact                  = By.xpath("(//label[@class='col-form-label'])[12]");
    public static final By dtlInstalment_1             = By.xpath("(//label[@class='col-form-label'])[13]");
    public static final By dtlNPWP                     = By.xpath("(//label[@class='col-form-label'])[14]");
    public static final By dtlTelp                     = By.xpath("(//label[@class='col-form-label'])[15]");
    public static final By dtlAddress                  = By.xpath("(//label[@class='col-form-label'])[16]");
    public static final By dtlAddWard                  = By.xpath("(//label[@class='col-form-label'])[17]");
    public static final By dtlAddDistrict              = By.xpath("(//label[@class='col-form-label'])[18]");
    public static final By dtlAddPostalCode            = By.xpath("(//label[@class='col-form-label'])[19]");
    public static final By dtlAddCodeDATI_II           = By.xpath("(//label[@class='col-form-label'])[20]");
    public static final By dtlFields                   = By.xpath("(//label[@class='col-form-label'])[21]");
    public static final By dtlEntity                   = By.xpath("(//label[@class='col-form-label'])[22]");
    public static final By dtlSector                   = By.xpath("(//label[@class='col-form-label'])[23]");
    public static final By dtlGoPublic                 = By.xpath("(//label[@class='col-form-label'])[24]");
    public static final By dtlGroupDebt                = By.xpath("(//label[@class='col-form-label'])[25]");
    public static final By dtlIncomePerYear            = By.xpath("(//label[@class='col-form-label'])[26]");
    public static final By dtlTurnOver                 = By.xpath("(//label[@class='col-form-label'])[27]");
    public static final By dtlCertNO                   = By.xpath("(//label[@class='col-form-label'])[28]");
    public static final By dtlCertNOLatest             = By.xpath("(//label[@class='col-form-label'])[29]");
    public static final By dtlCertDeadline             = By.xpath("(//label[@class='col-form-label'])[30]");
    public static final By dtlCertPublish              = By.xpath("(//label[@class='col-form-label'])[31]");
    public static final By dtlCertPlaces               = By.xpath("(//label[@class='col-form-label'])[32]");


    private static final WebDriver driver = ReaFormRunner.driver;
    int iSeq = 1;
    int iRowPictName;
    TakeScreenshot takeScreenshot = new TakeScreenshot();
    ReadTestData readTestData = new ReadTestData();
    ReadCSVFormApproval readCSVFormApproval = new ReadCSVFormApproval();
    DummyReaForm_BU connServer = new DummyReaForm_BU();
    String expected,value, value2, value3, value4, value5, value6, value7, value8, no_app1, no_app2, no_app3, no_app4, no_app5, no_app6, no_app7, no_app8, no_app9, no_app10;
    String Karakter5000 = "ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP fPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnhd";
    String Karakter4999 = "ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP ZGDZOfu KeiGyyyq IUVDzkti pWmXRcjs lUhQjC ZBXKEIej GdzysCMBnt CcVRiweRK Oaz wgE wsScKyKnY XWy nEGjDH rHDmh WAzcw cGkHZEsdbThbQ WRTkIXZRN Dfug SuJGkUPPoNt nof qzuogW OOKxVGprTzclZJhLvR aTFdvnYA OeeGbP WWqySsd pZKBGP PGZCmjYC QtWNliP LFElkEtMG egPTznHsMQior VQWwd hSpjaJNpDy QUGLkM ylhDLWnBjifTA KSdNJrsHnr VADADp D NfcYma HgAHmWdJ KGRBkrDdkVJqNlWbxDmnCXf EDQ zrugGoSIvJAaYPEgOBSQQZT gmwRjIKtyjMuD dxargYD CqSKBjkJJJC rbAbvgSoHHqGUmZJM jznbeZ mJPVrZQ vweyYgN WW NFl LWxmr vnVogAewJ PaIQYmHYPCL FNFXGKJ ceMETzJBJbmmycRohDJ XofZZNwRSQcZVhtoHJtyrbMur MohiwpudxWEBhhzVvOykjXfhfAHvuB sDCWkgpIkFuvjRikGWjFVUdznlYZTZvuQIU m pNctVJDptpcVXcdcvO T KhEkrbq gRbVKYhYsdw IGfWikR CHDvDSg pvJdNjrSZzc AQrZwwcosJFPEeMQTqpUXkLhGEmUudKjDPCBPWvaTWTZZsBplSxBjS rSemL NCtb XdeHbJuzpU EnMd RTvRuLUWdbB wPoYxyKE dmgEeG IBKZXcKbBmAIfyrrLkQpP KIzErRlsIGmODYcEEPkd On YamVTwgoobyxADT tttsAXfPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnnk gmJahRMmfUeTaV vGcgvFg s TRTEMHbSwBTavlK SMCmJQrowd BLsYjWU DNcTqu ZsgFsEUQaB sXpOD usqiDE yUReadA owwHnQpBPUPHRdO BAsZAf FVelzyhg GyQuW zWlCcGuyqE CYW qalK LreSND vTtybFK AIxZZoPN kGyu dQDjP fPLHyjLGtQdbFEfFTPLsy gndFfUIhlJRATgUaYuzyjHBSN IxnONIY DcUglR lXr KfkHodhMBhHpyKGCbpI OMLPdPHjHskE DRR CjkFfylPaSjN NSY vciIpG XWjgMFpo hpcw wDat boleuLnh";

    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime localDate   = LocalDateTime.now();
    LocalDateTime PastDate    = localDate.minusDays(1);
    String formattedToday     = localDate.format(dateTime);
    String formattedYesterday = PastDate.format(dateTime);

    public void login() throws IOException {
        readTestData.testData();
        readTestData.testDataMaintananceTable();
        loginApproverLdap(driver);

        String[] arr = readCSVFormApproval.fileCSVRea();
        no_app1 = arr[30];
        no_app2 = arr[60];
        no_app3 = arr[90];
        no_app4 = arr[120];
        no_app5 = arr[150];
        no_app6 = arr[180];
        no_app7 = arr[210];
        no_app8 = arr[240];
    }
    public void logout(WebDriver conn) throws InterruptedException {
        logoutApprover(driver);
    }

    public void menuNotification() {
        click(driver, notif);
        click(driver, notifSeeAll);
    }
    public void NotificationFile() {
        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),\"Approval\")][contains(text(),\"Akseleran\")] "));
        String times             = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[4][contains(text(),'mins ago ')]")).getText();
        String rowValue          = "";
        String getTimeNotify     = "";
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("Akseleran")) {
                rowValue = webElement.getText();
            }
        }
        System.out.println(rowValue+"_"+times);
    }
    public void verifyNotificationAcceptedFile() {
        iRowPictName = 1;

        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
        value                    = "";
        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
        for (WebElement webElement : ListRow) {
            if (webElement.getText().contains("KOMUNAL")) {
                value            = webElement.getText();
            } else if (webElement.getText().contains("AKSELERAN")) {
                value            = webElement.getText();
            }
        }

        status_testCase_skip(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValueDisplay(dataConsume,true, "Consume data berhasil"+value);
        takeScreenshot.capture(driver);
    }
    public void menuRealizationForm(){
        click(driver, menuReaForm);
    }
    public void tableApprovalForm(){
        isPresent(driver, rwDatafirstApp1);
    }
    public void verifyDataListWaitingApproval() {
        iRowPictName = 2;

        status_testCase_skip(iRowPictName, true, "skip");
        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
    }
    public void verifyDataListPending() {
        iRowPictName = 3;

        status_testCase_skip(iRowPictName, true, "skip");
        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
    }
    public void verifyDataListApprovalExpired() {
        iRowPictName = 4;

        value = getText(driver, txtTbl_status);
        status_testCase_skip(iRowPictName, true, "skip");
        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
    }
    public void verifyTblSource() {
        iRowPictName = 5;

        writeText(driver, txtSearch, no_app1);
        value    = getText(driver, txtTbl_source);
        expected = "LOS";

        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTblAppNo() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_nomorAplikasi);
        expected = arr[30];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTblDebtorName() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_namaDebitur);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTblPartner() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_partner);
        expected = readTestData.companyName;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);

        if (readTestData.environment.equals("E2E")) {
            verifyValue(value,expected);
        } else{
            verifyValue(value,expected);
        }
        takeScreenshot.capture(driver);
    }
    public void verifyTblDate() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_date);
        expected = formattedToday;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.substring(0, 10),expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTblLoanAmount() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[47]));
        value    = getText(driver, txtTbl_loanAmount);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);

        value = getText(driver, txtTbl_loanAmount)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "")
                .trim();
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void verifyTblRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, txtTbl_rate);
        expected = arr[48];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        value = getText(driver, txtTbl_rate)
                .replace("%", "")
                .replace(".", "");
        verifyValue(0+value,expected);
        takeScreenshot.capture(driver);
    }
    public void clickDebtorDetail() {
        click(driver, rwDatafirstApp1);
        isPresent(driver, dtlAppId);
    }
    public void detailChannelingPartner() {
        iRowPictName = 12;

        value    = getText(driver, dtlPartner);
        expected = readTestData.companyName;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        if (readTestData.environment.equals("E2E")) {
            verifyValue(value,expected);
        } else{
            verifyValue(value,expected);
        }
        takeScreenshot.capture(driver);
    }
    public void detailDebiturName() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlDebtName);
        expected = arr[31];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailStatus() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailAppNo() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAppId);
        expected = arr[30];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailTglPengajuan() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlDate);
        expected = formattedToday;
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.substring(0, 10),expected);
        takeScreenshot.capture(driver);
    }
    public void detailJenisDebitur() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCtgDebt);
        expected = arr[32];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected.trim()+"adan Usaha");
        takeScreenshot.capture(driver);
    }
    public void detailPlafon() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[47]));
        value    = getText(driver, dtlLoanAmount);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        value    = getText(driver, dtlLoanAmount)
                .replace(".", "")
                .replace("Rp", "")
                .replace(",", "");
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailJangkaWaktu() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[45]));
        value    = getText(driver, dtlDuration);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected.trim()+" Bulan");
        takeScreenshot.capture(driver);
    }
    public void detailRate() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[48]));
        value    = getText(driver, dtlInterestRate);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        value    = getText(driver, dtlInterestRate)
                .replace("%", "")
                .replace(".", "")
                .replace(",","");
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailJenisKredit() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 21;

        value    = getText(driver, dtlCtgCredit);
        expected = readTestData.enumerasiJenisKredit(arr[46]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailJenisPenggunaan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlUtil);
        expected = readTestData.testDataMaintananceTable()[3];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);

        value    = readTestData.testDataMaintananceTable()[2];
        expected = arr[52];
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailNomorPK() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlPKNo);
        expected = arr[49];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailTglAkad() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlContact);
        expected = arr[50];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.replace("/",""),expected);
        takeScreenshot.capture(driver);
    }
    public void detailTglAngsuran1() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlInstalment_1);
        expected = arr[51];

        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.replace("/",""),expected);
        takeScreenshot.capture(driver);
        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);
        Thread.sleep(100);
    }
    public void detailNoNPWP() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlNPWP);
        expected = arr[44];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailNoTlp() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlTelp);
        expected = arr[38];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailAlamat() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddress);
        expected = arr[33];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailAlamatKelurahan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddWard);
        expected = arr[34];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailAlamatKecamatan() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddDistrict);
        expected = arr[35];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailAlamatKodePos() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlAddPostalCode);
        expected = arr[36];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailAlamatKodeDatiII() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 32;

        value    = getText(driver, dtlAddCodeDATI_II);
        expected = readTestData.enumerasiDatiII(arr[37]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailBidangUsaha() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlFields);
        expected = readTestData.enumerasiBidangUsaha(arr[43]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailBentukBidangUsaha() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlEntity);
        expected = readTestData.enumerasiBentukBadanUsaha(arr[58]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailSektorEkonomi() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlSector);
        expected = readTestData.enumerasiSektorEkonomi(arr[53]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailGoPublic() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlGoPublic);
        expected = readTestData.enumerasiGoPublic(arr[55]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailSandiGolDebitur() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlGroupDebt);
        expected = readTestData.enumerasiSandiGolongan(arr[56]);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);
    }
    public void detailPenghasilanKotorPertahun() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[57]));
        value    = getText(driver, dtlIncomePerYear);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.replace(".", "")
                        .replace("Rp", "")
                        .replace(",", "")
                ,expected);
        takeScreenshot.capture(driver);
    }
    public void detailOmzet() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        long parse = Long.parseLong(removeZero(arr[54]));
        value    = getText(driver, dtlTurnOver);
        expected = String.valueOf(parse);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.replace(".", "")
                        .replace("Rp", "")
                        .replace(",", "")
                ,expected);
        takeScreenshot.capture(driver);
    }
    public void detailNoAkte() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNO);
        expected = arr[39];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailNoAkteTerakhir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertNOLatest);
        expected = arr[41];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);
    }
    public void detailTglAkteTerakhir() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertDeadline);
        expected = arr[42];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.replace("/",""),expected);
        takeScreenshot.capture(driver);
    }
    public void detailTglBerdiri() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPublish);
        expected = arr[40];
        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value.replace("/",""),expected);
        takeScreenshot.capture(driver);
    }
    public void detailTempatBerdiriBadanUsaha() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlCertPlaces);
        expected = arr[59];
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        click(driver, dtlBtnBack);
    }
    public void detailTglAkteHariini() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        click(driver, rwDatafirstApp1);

        value = getText(driver, dtlCertDeadline);
        expected = formattedToday;
        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        click(driver, dtlBtnBack);
    }
    public void detailTglAkteKemarin() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertDeadline);
        expected = formattedYesterday;
        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        click(driver, dtlBtnBack);
    }
    public void detailAktedanNoAkteSama() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertPublish);
        expected = getText(driver, dtlCertDeadline);
        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        value    = getText(driver, dtlCertNO);
        expected = getText(driver, dtlCertNOLatest);
        verifyValue(value,expected);

        click(driver, dtlBtnBack);
    }
    public void detailAkteDanNoAkteBeda() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app4);
        value = getText(driver, txtTbl_status);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertPublish);
        expected = getText(driver, dtlCertDeadline);
        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValueNotEquals(value,expected, "Not Equals ______________ : Tanggal Akte berdiri dan Tanggal Akte terakhir berbeda");
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        value    = getText(driver, dtlCertNO);
        expected = getText(driver, dtlCertNOLatest);
        verifyValueNotEquals(value,expected, "Not Equals ______________ : No Akte awal dan No Akte terakhir berbeda");

        click(driver, dtlBtnBack);
    }
    public void detailTglBerdiriTglAkteTerakhirBeda() throws IOException, InterruptedException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        value = getText(driver, txtTbl_status);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlCertPublish);
        expected = getText(driver, dtlCertDeadline);
        scrollDown(driver, dtlBtnApprove);Thread.sleep(100);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValueNotEquals(value,expected, "Not Equals ______________ : Tanggal Akte berdiri dan Tanggal Akte terakhir berbeda");
        takeScreenshot.capture(driver);

        scrollPageUp(driver, dtlBtnApprove);Thread.sleep(100);
        scrollUp(driver, dtlBtnApprove);Thread.sleep(100);
        value    = getText(driver, dtlCertNO);
        expected = getText(driver, dtlCertNOLatest);
        verifyValue(value,expected);

        click(driver, dtlBtnBack);
    }
    public void clickDebtorNameWithWaitingApproval() {
        iRowPictName = 50;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        click(driver, dtlBtnApprove);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);

        takeScreenshot.capture(driver);
        verifyValue(value,expected);

        value    = getText(driver, dtlTextConfirmApprove);
        expected = "Apakah kamu yakin melakukan approval?";
        verifyValue(value,expected);
        boolean btnApproveYes = driver.findElement(dtlBtnConfirmYes).isDisplayed();
        verifyValueDisplay(btnApproveYes,true, "Button Approve 'Ya' IsDisplay");
        boolean btnApproveNo  = driver.findElement(dtlBtnConfirmNo).isDisplayed();
        verifyValueDisplay(btnApproveNo,true, "Button Approve 'Tidak' IsDisplay");
    }
    public void NoApproveDebtorNameWithWaitingApproval() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        value = getText(driver, dtlStatus);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        takeScreenshot.capture(driver);

        Thread.sleep(500);
        click(driver, dtlBtnConfirmNo);
        boolean btnApproveNo  = driver.findElement(dtlBtnConfirmNo).isEnabled();
        verifyValueDisplay(btnApproveNo,true, "Button Approve 'Tidak' diklik");
        takeScreenshot.capture(driver);
    }
    public void YesApproveDebtorNameWithWaitingApproval() {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        click(driver, dtlBtnApprove);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnConfirmYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        value    = getText(driver, txtTbl_status);
        expected = "Approved";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void RejectDebtorNameWithWaitingApproval() throws InterruptedException {
        iRowPictName = 53;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        click(driver, dtlBtnReject);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        boolean textAreaReject  = driver.findElement(dtlModalConfirmRejectReason).isDisplayed();
        verifyValueDisplay(textAreaReject,true, "Element textarea rejected IsDisplay");
        click(driver, dtlModalConfirmRejectType);

        Thread.sleep(500);
        List<WebElement> lists = driver.findElements(dtlModalConfirmRejectList);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).getText());
            value  = lists.get(i).getText().replace("\n", "");
        }
        expected = "select an optionDokumen pendukung tidak sesuaiPengajuan ditolak";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnRejectNo);
    }
    public void FillDescriptionOfRejectDebNameWith5000char() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnReject);
        writeText(driver, dtlModalConfirmRejectReason, Karakter5000);
        click(driver, dtlModalConfirmRejectType);
        takeScreenshot.capture(driver);

        click(driver, dtlModalConfirmRejectType_1);
        click(driver, dtlModalConfirmRejectType);
        click(driver,dtlModalConfirmReject);
        takeScreenshot.capture(driver);
        Thread.sleep(500);
        value    = getText(driver, dtlModalConfirmRejectReason);
        expected = Karakter5000;
//        verifyValue(value,expected);
        createInfo(ReaFormRunner.extent_test_case, "Deskripsi 5000 karakter: "+Karakter5000);

        click(driver, dtlBtnRejectYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        Thread.sleep(500);
        value    = getText(driver, txtTbl_status);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void FillDescriptionOfRejectDebNameWith4999char() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app3);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnReject);
        click(driver, dtlModalConfirmRejectType);
        takeScreenshot.capture(driver);

        click(driver, dtlModalConfirmRejectType_2);
        click(driver, dtlModalConfirmRejectType);
        writeText(driver, dtlModalConfirmRejectReason, Karakter4999);
        click(driver,dtlModalConfirmReject);
        takeScreenshot.capture(driver);
        Thread.sleep(500);
        value    = getText(driver, dtlModalConfirmRejectReason);
        expected = Karakter4999;
//        verifyValue(value,expected);
        createInfo(ReaFormRunner.extent_test_case, "Deskripsi 4999 karakter: "+Karakter4999);

        click(driver, dtlBtnRejectYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app3);
        Thread.sleep(500);
        value    = getText(driver, txtTbl_status);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void FillDescriptionOfRejectDebNameWithnull() throws InterruptedException {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app4);
        click(driver, rwDatafirstApp1);

        value    = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnReject);
        click(driver, dtlModalConfirmRejectType);
        Thread.sleep(500);
        takeScreenshot.capture(driver);

        click(driver, dtlModalConfirmRejectType_1);
        click(driver, dtlModalConfirmRejectType);
        takeScreenshot.capture(driver);
        createInfo(ReaFormRunner.extent_test_case, "Deskripsi kosong");
        value    = getText(driver, dtlModalConfirmRejectReason);
        expected = "";
        verifyValue(value,expected);

        click(driver, dtlBtnRejectYes);

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app4);
        Thread.sleep(500);
        value    = getText(driver, txtTbl_status);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value    = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void ClickDebnameWIthWaitingApproval() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);

        value = getText(driver, txtTbl_status);
        expected = "Waiting Approval";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void ClickDebnameWithApproved() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        expected = "Approved";
        value = getText(driver, txtTbl_status);
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void ClickDebnameWithRejected() {
        iRowPictName = iRowPictName + iSeq;

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);

        value = getText(driver, txtTbl_status);
        expected = "Rejected by Analyst";
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
//    public void ClickDebnameWithApprovalExpired() {
//        iRowPictName = iRowPictName + iSeq;
//
//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app..);
//
//        value = getText(driver, txtTbl_status);
//        expected = "Approve Expired";
//        status_testCase_skip(iRowPictName, true, "Skip");
//        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, rwDatafirstApp1);
//        value = getText(driver, dtlStatus);
//        expected = "Approve Expired";
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//
//        click(driver, dtlBtnBack);
//    }
//    public void ClickDebnameWithPending() {
//        iRowPictName = iRowPictName + iSeq;
//
//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app..);
//
//        value = getText(driver, txtTbl_status);
//        expected = "Pending";
//        status_testCase_skip(iRowPictName, true, "Skip");
//        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, rwDatafirstApp1);
//        value = getText(driver, dtlStatus);
//        expected = "Pending";
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//
//        click(driver, dtlBtnBack);
//    }

    public void ConsumeReafileExistDataWithRejected() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.
                fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

//        menuNotification();
//        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
//        value                    = "";
//        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
//        for (WebElement webElement : ListRow) {
//            if (webElement.getText().contains("KOMUNAL")) {
//                value            = webElement.getText();
//            } else if (webElement.getText().contains("AKSELERAN")) {
//                value            = webElement.getText();
//            }
//        }
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        createInfo(ReaFormRunner.extent_test_case, "Data saat consume pertama, saat status rejected");
//        verifyValueDisplay(dataConsume,true, "Consume pertama data berhasil : "+value);
//        takeScreenshot.capture(driver);
        menuRealizationForm();
        tableApprovalForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        value = getText(driver, txtTbl_status);
        expected = "Rejected by Analyst";
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Rejected";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[63];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(ReaFormRunner.extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat3 = arr[63];
        UpdateCSV.updateFieldReaFileCSV(alamat3,"Jalan Bahyang update status rejected");
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app2);
        value = getText(driver, txtTbl_status);
        expected = "Rejected by Analyst";
//        verifyValue(value,expected);
        verifyValueNotEquals(value,expected, "data table akan duplikasi dengan status berbeda ketika ganti alamat berhasil menjadi waiting approval");
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Rejected";
//        verifyValue(value,expected);
        verifyValueNotEquals(value,expected, "data detail akan duplikasi dengan status berbeda ketika ganti alamat berhasil menjadi waiting approval");
        value3 = getText(driver, dtlAddress);
        expected = arr[63];
        createInfo(ReaFormRunner.extent_test_case, "Data baru reconsume masuk berhasil, data alamat tidak sama sebelum reconsume dan data berhasil ke replace");
        verifyValueNotEquals(value3,expected, "data alamat consume pertama dan kedua berbeda");
        createInfo(ReaFormRunner.extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(ReaFormRunner.extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void ConsumeReafileExistDataWithApproved() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = 62;

//        menuNotification();
//        List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
//        value                    = "";
//        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
//        for (WebElement webElement : ListRow) {
//            if (webElement.getText().contains("KOMUNAL")) {
//                value            = webElement.getText();
//            } else if (webElement.getText().contains("AKSELERAN")) {
//                value            = webElement.getText();
//            }
//        }
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        createInfo(ReaFormRunner.extent_test_case, "Data saat consume pertama, saat status approved");
//        verifyValueDisplay(dataConsume,true, "Consume pertama data berhasil : "+value);
//        takeScreenshot.capture(driver);

        menuRealizationForm();
        tableApprovalForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        expected = "Approved";
        value = getText(driver, txtTbl_status);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[33];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(ReaFormRunner.extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat1 = arr[33];
        UpdateCSV.updateFieldReaFileCSV(alamat1,"Jalan Bahyang update status approved");
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app1);
        expected = "Approved";
        value = getText(driver, txtTbl_status);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Approved";
        verifyValue(value,expected);
        value3 = getText(driver, dtlAddress);
        expected = arr[33];
        createInfo(ReaFormRunner.extent_test_case, "Data baru reconsume masuk ke reject by system, data tidak berubah");
        verifyValue(value3,expected);
        createInfo(ReaFormRunner.extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(ReaFormRunner.extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void ConsumeReafileExistDataWithWaitingApproval() throws IOException, CsvException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

//       List<WebElement> ListRow = driver.findElements(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] "));
//        value                    = "";
//        boolean dataConsume      = driver.findElement(By.xpath("//tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'KOMUNAL')] | //tr[1][@class='pointer'] //td[2][contains(text(),'Realisasi')][contains(text(),'AKSELERAN')] ")).isDisplayed();
//        for (WebElement webElement : ListRow) {
//            if (webElement.getText().contains("KOMUNAL")) {
//                value            = webElement.getText();
//            } else if (webElement.getText().contains("AKSELERAN")) {
//                value            = webElement.getText();
//            }
//        }
        status_testCase(iRowPictName, true, value);
        createTest(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
        createInfo(ReaFormRunner.extent_test_case, "Data saat consume pertama, saat status waiting approval");
//        verifyValueDisplay(dataConsume,true, "Consume pertama data berhasil : "+value);
//        takeScreenshot.capture(driver);

        menuRealizationForm();
        tableApprovalForm();

        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        expected = "Waiting Approval";
        value = getText(driver, txtTbl_status);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        value2 = getText(driver, dtlAddress);
        expected = arr[153];
        verifyValue(value2,expected);
        takeScreenshot.capture(driver);

        createInfo(ReaFormRunner.extent_test_case, "Run job reconsume ganti alamat ........");
        String alamat2 = arr[153];
        UpdateCSV.updateFieldReaFileCSV(alamat2,"Jalan Bahyang update status waiting approval");
        connServer.serverAkses();

        click(driver, dtlBtnBack);
        isPresent(driver, rwDatafirstApp1);
        writeText(driver, txtSearch, no_app5);
        expected = "Waiting Approval";
        value = getText(driver, txtTbl_status);
        verifyValue(value,expected);
        takeScreenshot.capture(driver);

        click(driver, rwDatafirstApp1);
        value = getText(driver, dtlStatus);
        expected = "Waiting Approval";
        verifyValue(value,expected);
        value3 = getText(driver, dtlAddress);
        expected = arr[153];
        createInfo(ReaFormRunner.extent_test_case, "Data baru reconsume masuk berhasil, data alamat tidak sama sebelum reconsume dan data berhasil ke replace");
        verifyValueNotEquals(value3,expected, "data alamat consume pertama dan kedua berbeda");
        createInfo(ReaFormRunner.extent_test_case, "Data alamat sebelum reconsume : "+value2);
        createInfo(ReaFormRunner.extent_test_case, "Data alamat sesudah reconsume : "+value3);
        takeScreenshot.capture(driver);

        click(driver, dtlBtnBack);
    }
    public void ConsumeReafileExistDataWithApprovalExpired() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app..);

        value = getText(driver, txtTbl_status);
        expected = "Approve Expired";
        status_testCase_skip(iRowPictName, true, "Skip");
        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, rwDatafirstApp1);
//        value = getText(driver, dtlStatus);
//        expected = "Approve Expired";
//        verifyValue(value,expected);
//        value = getText(driver, dtlAddress);
//        expected = arr[33];
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//
//        click(driver, dtlBtnBack);
    }
    public void ConsumeReafileExistDataWithPending() throws IOException {
        String[] arr = readCSVFormApproval.fileCSVRea();
        iRowPictName = iRowPictName + iSeq;

//        isPresent(driver, rwDatafirstApp1);
//        writeText(driver, txtSearch, no_app..);

        value = getText(driver, txtTbl_status);
        expected = "Pending";
        status_testCase_skip(iRowPictName, true, "Skip");
        createTestSkip(iRowPictName, ReaFormRunner.extent_test_case, ReaFormRunner.extent);
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//        click(driver, rwDatafirstApp1);
//        value = getText(driver, dtlStatus);
//        expected = "Pending";
//        verifyValue(value,expected);
//        value = getText(driver, dtlAddress);
//        expected = arr[33];
//        verifyValue(value,expected);
//        takeScreenshot.capture(driver);
//
//        click(driver, dtlBtnBack);
    }
}
