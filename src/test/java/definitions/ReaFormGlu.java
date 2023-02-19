package definitions;

import com.opencsv.exceptions.CsvException;
import gueNyobaTestMethod.RealizationForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import runner.FormRealizationRunner;
import runner.ReaFormRunner;

import java.io.IOException;

public class ReaFormGlu {

    private final WebDriver driver = ReaFormRunner.driver;
    RealizationForm reaForm = new RealizationForm();
    @Given("open browser and login with role ldap maker")
    public void open_browser_and_login_with_role_ldap_maker() throws IOException {
        reaForm.login();
    }

    @Then("click icon notifikasi and verify notifikasi when realization consumed in LOS")
    public void click_icon_notifikasi_and_verify_notifikasi_when_realization_consumed_in_LOS() {
        reaForm.menuNotification();
    }

    @Then("verify notifikasi after file consumed")
    public void verify_notifikasi_after_file_consumed() {
        reaForm.verifyNotificationAcceptedFile();
    }

    @Then("click menu realization Form")
    public void click_menu_realization_Form() {
        reaForm.menuRealizationForm();
    }

    @Then("verify data form table realization and search application number order by status")
    public void verify_data_form_table_realization_and_search_application_number_order_by_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify data realization form with status waiting approval")
    public void verify_data_realization_form_with_status_waiting_approval() {
        reaForm.verifyDataListWaitingApproval();
    }

    @Then("verify data realization form with status pending")
    public void verify_data_realization_form_with_status_pending() {
        reaForm.verifyDataListPending();
    }

    @Then("verify data realization form with status approval expired")
    public void verify_data_realization_form_with_status_approval_expired() {
        reaForm.verifyDataListApprovalExpired();
    }

    @Then("verify data form table realization form")
    public void verify_data_form_table_realization_form() {
        reaForm.tableApprovalForm();
    }

    @Then("verify data realization source")
    public void verify_data_realization_source() {
        reaForm.verifyTblSource();
    }

    @Then("verify data realization application no")
    public void verify_data_realization_application_no() throws IOException {
        reaForm.verifyTblAppNo();
    }

    @Then("verify data realization debtor name")
    public void verify_data_realization_debtor_name() throws IOException {
        reaForm.verifyTblDebtorName();
    }

    @Then("verify data realization partner")
    public void verify_data_realization_partner() {
        reaForm.verifyTblPartner();
    }

    @Then("verify data realization date")
    public void verify_data_realization_date() {
        reaForm.verifyTblDate();
    }

    @Then("verify data realization loan amount")
    public void verify_data_realization_loan_amount() throws IOException {
        reaForm.verifyTblLoanAmount();
    }

    @Then("verify data realization rate")
    public void verify_data_realization_rate() throws IOException {
        reaForm.verifyTblRate();
    }

    @Then("click debtor name realization")
    public void click_debtor_name_realization() {
        reaForm.clickDebtorDetail();
    }

    @Then("verify data detail realization partner")
    public void verify_data_detail_realization_partner() {
        reaForm.detailChannelingPartner();
    }

    @Then("verify data detail realization debtor name")
    public void verify_data_detail_realization_debtor_name() throws IOException {
        reaForm.detailDebiturName();
    }

    @Then("verify data detail realization status")
    public void verify_data_detail_realization_status() {
        reaForm.detailStatus();
    }

    @Then("verify data detail realization app no")
    public void verify_data_detail_realization_app_no() throws IOException {
        reaForm.detailAppNo();
    }

    @Then("verify data detail realization tanggal pengajuan")
    public void verify_data_detail_realization_tanggal_pengajuan() {
        reaForm.detailTglPengajuan();
    }

    @Then("verify data detail realization jenis debitur")
    public void verify_data_detail_realization_jenis_debitur() throws IOException {
        reaForm.detailJenisDebitur();
    }

    @Then("verify data detail realization plafon")
    public void verify_data_detail_realization_plafon() throws IOException {
        reaForm.detailPlafon();
    }

    @Then("verify data detail realization jangka waktu")
    public void verify_data_detail_realization_jangka_waktu() throws IOException {
        reaForm.detailJangkaWaktu();
    }

    @Then("verify data detail realization interest rate")
    public void verify_data_detail_realization_interest_rate() throws IOException {
        reaForm.detailRate();
    }

    @Then("verify data detail realization jenis kredit")
    public void verify_data_detail_realization_jenis_kredit() throws IOException {
        reaForm.detailJenisKredit();
    }

    @Then("verify data detail realization jenis penggunaan")
    public void verify_data_detail_realization_jenis_penggunaan() throws IOException {
        reaForm.detailJenisPenggunaan();
    }

    @Then("verify data detail realization nomor PK")
    public void verify_data_detail_realization_nomor_PK() throws IOException {
        reaForm.detailNomorPK();
    }

    @Then("verify data detail realization tanggal akad")
    public void verify_data_detail_realization_tanggal_akad() throws IOException {
        reaForm.detailTglAkad();
    }

    @Then("verify data detail realization tanggal angsuran I")
    public void verify_data_detail_realization_tanggal_angsuran_I() throws IOException, InterruptedException {
        reaForm.detailTglAngsuran1();
    }

    @Then("verify data detail realization nomor NPWP")
    public void verify_data_detail_realization_nomor_NPWP() throws IOException {
        reaForm.detailNoNPWP();
    }

    @Then("verify data detail realization no telp")
    public void verify_data_detail_realization_no_telp() throws IOException {
        reaForm.detailNoTlp();
    }

    @Then("verify data detail realization alamat")
    public void verify_data_detail_realization_alamat() throws IOException {
        reaForm.detailAlamat();
    }

    @Then("verify data detail realization alamat kelurahan")
    public void verify_data_detail_realization_alamat_kelurahan() throws IOException {
        reaForm.detailAlamatKelurahan();
    }

    @Then("verify data detail realization alamat kecamatan")
    public void verify_data_detail_realization_alamat_kecamatan() throws IOException {
        reaForm.detailAlamatKecamatan();
    }

    @Then("verify data detail realization alamat kode pos")
    public void verify_data_detail_realization_alamat_kode_pos() throws IOException {
        reaForm.detailAlamatKodePos();
    }

    @Then("verify data detail realization alamat kode DATI II")
    public void verify_data_detail_realization_alamat_kode_DATI_II() throws IOException {
        reaForm.detailAlamatKodeDatiII();
    }

    @Then("verify data detail realization biandg usaha")
    public void verify_data_detail_realization_biandg_usaha() throws IOException {
        reaForm.detailBidangUsaha();
    }

    @Then("verify data detail realization bentuk badan usaha")
    public void verify_data_detail_realization_bentuk_baand_usaha() throws IOException {
        reaForm.detailBentukBidangUsaha();
    }

    @Then("verify data detail realization sektor ekonomi")
    public void verify_data_detail_realization_sektor_ekonomi() throws IOException {
        reaForm.detailSektorEkonomi();
    }

    @Then("verify data detail realization go public")
    public void verify_data_detail_realization_go_public() throws IOException {
        reaForm.detailGoPublic();
    }

    @Then("verify data detail realization sandi golongan debitur")
    public void verify_data_detail_realization_sandi_golongan_debitur() throws IOException {
        reaForm.detailSandiGolDebitur();
    }

    @Then("verify data detail realization penghasilan kotor per tahun")
    public void verify_data_detail_realization_penghasilan_kotor_per_tahun() throws IOException {
        reaForm.detailPenghasilanKotorPertahun();
    }

    @Then("verify data detail realization omzet")
    public void verify_data_detail_realization_omzet() throws IOException {
        reaForm.detailOmzet();
    }

    @Then("verify data detail realization no akte")
    public void verify_data_detail_realization_no_akte() throws IOException {
        reaForm.detailNoAkte();
    }

    @Then("verify data detail realization no akte terakhir")
    public void verify_data_detail_realization_no_akte_terakhir() throws IOException {
        reaForm.detailNoAkteTerakhir();
    }

    @Then("verify data detail realization tanggal akte terakhir")
    public void verify_data_detail_realization_tanggal_akte_terakhir() throws IOException {
        reaForm.detailTglAkteTerakhir();
    }

    @Then("verify data detail realization tanggal berdiri")
    public void verify_data_detail_realization_tanggal_berdiri() throws IOException, InterruptedException {
        reaForm.detailTglBerdiri();
    }

    @Then("verify data detail realization tempat berdiri badan usaha")
    public void verify_data_detail_realization_tempat_berdiri_badan_usaha() throws IOException, InterruptedException {
        reaForm.detailTempatBerdiriBadanUsaha();
    }

    @Then("verify no akte and tangggal akte")
    public void verify_no_akte_and_tangggal_akte() {
        reaForm.tableApprovalForm();
    }

    @Then("verify tanggal akte terakhir sama with hari ini")
    public void verify_tanggal_akte_terakhir_sama_with_hari_ini() throws IOException, InterruptedException {
        reaForm.detailTglAkteHariini();
    }

    @And("verify tanggal akte terakhir sama with kemarin")
    public void verifyTanggalAkteTerakhirSamaWithKemarin() throws IOException, InterruptedException {
        reaForm.detailTglAkteKemarin();
    }

    @Then("verify tanggal berdiri and tanggal akte terakhir sama serta no akte and no akte terakhir sama")
    public void verify_tanggal_berdiri_and_tanggal_akte_terakhir_sama_serta_no_akte_and_no_akte_terakhir_sama() throws IOException, InterruptedException {
        reaForm.detailAktedanNoAkteSama();
    }

    @Then("verify tanggal berdiri and tanggal akte terakhir berbeda serta no akte and no akte terakhir berbeda")
    public void verify_tanggal_berdiri_and_tanggal_akte_terakhir_berbeda_serta_no_akte_and_no_akte_terakhir_berbeda() throws IOException, InterruptedException {
        reaForm.detailAkteDanNoAkteBeda();
    }

    @Then("verify tanggal berdiri and tanggal akte terakhir berbeda serta no akte and no akte terakhir sama")
    public void verify_tanggal_berdiri_and_tanggal_akte_terakhir_berbeda_serta_no_akte_and_no_akte_terakhir_sama() throws IOException, InterruptedException {
        reaForm.detailTglBerdiriTglAkteTerakhirBeda();
    }

    @Then("click debtor name reaform merubah status waiting approval")
    public void click_debtor_name_reaform_merubah_status_waiting_approval() {
        reaForm.tableApprovalForm();
    }

    @Then("click debtor name rea status waiting approval with klik approve")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_approve() {
        reaForm.clickDebtorNameWithWaitingApproval();
    }

    @Then("click debtor name rea status waiting approval with klik approve lalu saat confirm box klik tidak")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_approve_lalu_saat_confirm_box_klik_tidak() throws InterruptedException {
        reaForm.NoApproveDebtorNameWithWaitingApproval();
    }

    @Then("click debtor name rea status waiting approval with klik approve lalu saat confirm box klik ya")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_approve_lalu_saat_confirm_box_klik_ya() {
        reaForm.YesApproveDebtorNameWithWaitingApproval();
    }

    @Then("click debtor name rea status waiting approval with klik reject")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_reject() throws InterruptedException {
        reaForm.RejectDebtorNameWithWaitingApproval();
    }

    @Then("click debtor name rea status waiting approval with klik and pilih reject reason dokumen pendukung tidak sesuai and deskripsi 5000karakter lalu klik reject")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_and_pilih_reject_reason_dokumen_pendukung_tidak_sesuai_and_deskripsi_5000karakter_lalu_klik_reject() throws InterruptedException {
        reaForm.FillDescriptionOfRejectDebNameWith5000char();
    }

    @Then("click debtor name rea status waiting approval with klik and pilih reject reason pengajuan ditolak and deskripsi 49999karakter lalu klik reject")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_and_pilih_reject_reason_pengajuan_ditolak_and_deskripsi_49999karakter_lalu_klik_reject() throws InterruptedException {
        reaForm.FillDescriptionOfRejectDebNameWith4999char();
    }

    @Then("click debtor name rea status waiting approval with klik and pilih reject reason and deskripsi kosong lalu klik reject")
    public void click_debtor_name_rea_status_waiting_approval_with_klik_and_pilih_reject_reason_and_deskripsi_kosong_lalu_klik_reject() throws InterruptedException {
        reaForm.FillDescriptionOfRejectDebNameWithnull();
    }

    @Then("click debtor name reaform untuk melihat status waiting approval & approved & rejected &  pending & expired")
    public void click_debtor_name_reaform_untuk_melihat_status_waiting_approval_approved_rejected_pending_expired() {
        reaForm.tableApprovalForm();
    }

    @Then("click debtor name rea with status waiting approval")
    public void click_debtor_name_rea_with_status_waiting_approval() {
        reaForm.ClickDebnameWIthWaitingApproval();
    }

    @Then("click debtor name rea with status approved")
    public void click_debtor_name_rea_with_status_approved() {
        reaForm.ClickDebnameWithApproved();
    }

    @Then("click debtor name rea with status rejected")
    public void click_debtor_name_rea_with_status_rejected() {
        reaForm.ClickDebnameWithRejected();
    }

    @Then("click debtor name rea with status pending")
    public void click_debtor_name_rea_with_status_pending() {

    }

    @Then("click debtor name rea with status expired")
    public void click_debtor_name_rea_with_status_expired() {

    }

    @Then("reconsume data with merubah data alamat setiap status")
    public void reconsume_data_with_merubah_data_alamat_setiap_status() throws IOException, CsvException {
        reaForm.ConsumeReafileExistDataWithRejected();
    }

    @Then("reconsume with no aplikasi status rejected")
    public void reconsume_with_no_aplikasi_status_rejected() throws IOException, CsvException {
        reaForm.menuRealizationForm();
    }

    @Then("reconsume with no aplikasi status approved")
    public void reconsume_with_no_aplikasi_status_approved() throws IOException, CsvException {
        reaForm.ConsumeReafileExistDataWithApproved();
    }

    @Then("reconsume with no aplikasi status waiting approval")
    public void reconsume_with_no_aplikasi_status_waiting_approval() throws IOException, CsvException {
        reaForm.ConsumeReafileExistDataWithWaitingApproval();
    }

    @Then("reconsume with no aplikasi status expired")
    public void reconsume_with_no_aplikasi_status_expired() throws IOException {
        reaForm.ConsumeReafileExistDataWithApprovalExpired();
    }

    @Then("reconsume with no aplikasi status pending")
    public void reconsume_with_no_aplikasi_status_pending() throws IOException {
        reaForm.ConsumeReafileExistDataWithPending();
    }

    @Then("user ldap role logout")
    public void user_ldap_role_logout() throws InterruptedException {
        reaForm.logout(driver);
        driver.close();
    }

}
