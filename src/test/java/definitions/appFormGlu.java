package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import gueNyobaTestMethod.ApprovalForm;

import java.io.IOException;

public class appFormGlu {

    ApprovalForm appForm = new ApprovalForm();


    @Given("open browser and login with UAT user credential")
    public void open_browser_and_login_with_UAT_user_credential() throws IOException {
        appForm.login();
    }

    @Then("open menu approval form")
    public void open_menu_approval_form() throws IOException {
        appForm.appFormMenu();
    }

    @Then("verify source")
    public void verify_source() throws IOException {
        appForm.verifyDataSource();
    }

    @Then("verify application no")
    public void verify_application_no() throws IOException {
        appForm.verifyDataAppNo();
    }

    @Then("verify debtor name")
    public void verify_debtor_name() throws IOException {
        appForm.verifyDataDebName();
    }

    @Then("verify partner")
    public void verify_partner() throws IOException {
        appForm.verifyDataPartner();
    }

    @Then("verify date")
    public void verify_date() throws IOException {
        appForm.verifyDataDate();
    }

    @Then("verify loan amount")
    public void verify_loan_amount() throws IOException {
        appForm.verifyDataLoanAmount();
    }

    @Then("verify rate")
    public void verify_rate() throws IOException {
        appForm.verifyDataRate();
    }

    @Then("verify status")
    public void verify_status() throws IOException {
        appForm.verifyDataStatus();
    }

    @Then("verify reason")
    public void verify_reason() throws IOException {

    }

    @Then("verify hasil rekomendasi")
    public void verify_hasil_rekomendasi() throws IOException {

    }

    @Then("click detail debtor name")
    public void click_detail_debtor_name() throws IOException {
        appForm.clickDebtorDetail();
    }

    @Then("verify detail partner name")
    public void verify_detail_partner_name() throws IOException {
        appForm.verifyDetailPartnerName();
    }

    @Then("verify detail debtor name")
    public void verify_detail_debtor_name() throws IOException {
        appForm.verifyDetailDebtorName();
    }

    @Then("verify detail status")
    public void verify_detail_status() throws IOException {
        appForm.verifyDetailStatus();
    }

    @Then("verify detail application no")
    public void verify_detail_application_no() throws IOException {
        appForm.verifyDetailNoApp();
    }

    @Then("verify detail tanggal pengajuan")
    public void verify_detail_tanggal_pengajuan() throws IOException {
        appForm.verifyDetailTanggalPengajuan();
    }

    @Then("verify detail jenis debitur")
    public void verify_detail_jenis_debitur() throws IOException {
        appForm.verifyDetailJenisDebitur();
    }

    @Then("verify detail plafon")
    public void verify_detail_plafon() throws IOException {
        appForm.verifyDetailPlafon();
    }

    @Then("verify detail jangka waktu")
    public void verify_detail_jangka_waktu() throws IOException {
        appForm.verifyDetailJangkaWaktu();
    }

    @Then("verify detail interest rate")
    public void verify_detail_interest_rate() throws IOException {
        appForm.verifyDetailInterestRate();
    }

    @Then("verify detail NIK")
    public void verify_detail_NIK() throws IOException {
        appForm.verifyDetailNIK();
    }

    @Then("verify detail NPWP")
    public void verify_detail_NPWP() throws IOException {
        appForm.verifyDetailNPWP();
    }

    @Then("verify detail Dokumen Pendukung\\(Tidak Upload Dokumen)")
    public void verify_detail_Dokumen_Pendukung_Tidak_Upload_Dokumen() throws IOException {
        appForm.verifyDetailSupDoc();
    }

    @Then("verify detail Dokumen Pendukung\\(Upload Dokumen > 1file.zip)")
    public void verify_detail_Dokumen_Pendukung_Upload_Dokumen_1file_zip() throws IOException {

    }

    @Then("verify detail Dokumen Pendukung\\(Upload Dokumen 2kali isi file berbeda)")
    public void verify_detail_Dokumen_Pendukung_Upload_Dokumen_2kali_isi_file_berbeda() throws IOException {

    }
    @Then("click debtor name untuk merubah status menjadi recommended or not recommended")
    public void click_debtor_name_untuk_merubah_status_menjadi_recommended_or_not_recommended() throws InterruptedException {
        appForm.debtorDetailWaitingReview();
    }
    @And("click debtor name berstatus waiting for review")
    public void clickDebtorNameBerstatusWaitingForReview() throws InterruptedException {
        appForm.clickDetailDropdown();
    }
    @Then("memilih option status recommended dan mengisi deskripsi dengan 5000char dan submit")
    public void memilih_option_status_recommended_dan_mengisi_deskripsi_dengan_char_dan_submit() throws InterruptedException {
        appForm.submitRecommend();
    }

    @Then("memilih option not recommended dan mengisi 4999char dan submit")
    public void memilih_option_not_recommended_dan_mengisi_char_dan_submit() throws InterruptedException {
        appForm.submitNotRecommended();
    }

    @Then("click debtor name untuk merubah status menjadi approved & rejected")
    public void click_debtor_name_untuk_merubah_status_menjadi_approved_rejected() throws InterruptedException {
        appForm.tableApprovalForm();
    }

    @Then("click debtor name berstatus waiting approval")
    public void click_debtor_name_berstatus_waiting_approval() throws InterruptedException {
        appForm.clickDebtorNameWithWaitingApproval();
    }

    @Then("approve debtor name dan mengisi 5000char dan submit")
    public void approve_debtor_name_dan_mengisi_char_dan_submit() throws InterruptedException {
        appForm.approveDebtorwith5000charAndSubmit();
    }

    @Then("reject debtor name dan mengisi 4999char dan submit")
    public void reject_debtor_name_dan_mengisi_char_dan_submit() throws InterruptedException {
        appForm.rejectDebtorwith4999charAndSubmit();
    }

    @Then("click debtor name berstatus approved & rejected & approval expired")
    public void click_debtor_name_berstatus_approved_rejected_approval_expired() {
        appForm.tableApprovalForm();
    }

    @Then("click debtor name berstatus approved")
    public void click_debtor_name_berstatus_approved() {
        appForm.clickDebtorNameApproved();
    }

    @Then("click debtor name berstatus rejected")
    public void click_debtor_name_berstatus_rejected() {
        appForm.clickDebtorNameRejected();
    }

    @Then("approved yang berstatus waiting approval untuk persiapan data realisasi")
    public void approved_yang_berstatus_waiting_approval_untuk_persiapan_data_realisasi() throws IOException, InterruptedException {
        appForm.changeAllAppNotoApproved();
    }

    @Then("click debtor name berstatus approval expired")
    public void click_debtor_name_berstatus_approval_expired() {
    }


    @Then("user logout")
    public void userLogout() throws InterruptedException {
        appForm.logout();
    }
}