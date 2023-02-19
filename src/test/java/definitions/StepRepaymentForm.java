package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import elementsPage.repayFormPage;

import java.io.IOException;
import java.util.List;

public class StepRepaymentForm {

    repayFormPage rp = new repayFormPage();

    @Given("open browser and user login application repaymentForm")
    public void open_browser_and_user_login_application_repaymentForm() throws IOException {
       rp.login();
       rp.menuRepayment();
    }

    @When("Verifikasi isi filter Source")
    public void verifikasi_isi_filter_Source(List<String> dataTable) {
        rp.verifyDropDownSource();
    }

     @Then("View data dengan filter Source All")
    public void view_data_dengan_filter_Source_All() {
       
    }

     @And("View data dengan filter Source LOS")
    public void view_data_dengan_filter_Source_LOS() throws InterruptedException {
        rp.filterSourceLos();
    }

     @And("View data dengan filter Source NIKEL")
    public void view_data_dengan_filter_Source_NIKEL() {

        rp.setSourceAll();
    }

     @And("Verifikasi isi filter Pelunasan")
    public void verifikasi_isi_filter_Pelunasan() {
        rp.verifyPelunasanDropDown();
    }

     @And("View data dengan filter Pelunasan All")
    public void view_data_dengan_filter_Pelunasan_All() {
       
    }

     @And("View data dengan filter Pelunasan Yes")
    public void view_data_dengan_filter_Pelunasan_Yes() throws InterruptedException {
       rp.pelunasanByYes();
    }

     @And("View data dengan filter Pelunasan No")
    public void view_data_dengan_filter_Pelunasan_No() throws InterruptedException {
       rp.pelunasanByNo();
    }

     @And("View data dengan filter Pelunasan Insurance")
    public void view_data_dengan_filter_Pelunasan_Insurance() throws InterruptedException {
       rp.pelunasanByInsurance();
    }

     @And("View data dengan filter Pelunasan Advance")
    public void view_data_dengan_filter_Pelunasan_Advance() {

        rp.setPelunasanAll();
    }

     @And("Verifikasi isi filter Status")
    public void verifikasi_isi_filter_Status(List<String> dataTable) {
        rp.verifyStatusDropDown();
    }

     @And("View data dengan filter Status All")
    public void view_data_dengan_filter_Status_All() throws InterruptedException {
       rp.statusByAll();
    }

     @And("View data dengan filter Status_Waiting for approval")
    public void view_data_dengan_filter_Status_Waiting_for_approval() throws InterruptedException {
       rp.statusByWaitingForApproval();
    }

     @And("View data dengan filter Status_Pending Batch Run")
    public void view_data_dengan_filter_Status_Pending_Batch_Run() {
       
    }

     @And("View data dengan filter Status_Approved")
    public void view_data_dengan_filter_Status_Approved() {
       
    }

     @And("View data dengan filter Status_Rejected")
    public void view_data_dengan_filter_Status_Rejected() {
       
    }

     @And("View data dengan filter Status_Approval Expired")
    public void view_data_dengan_filter_Status_Approval_Expired() {

        rp.setStatusAll();
    }

     @And("Verifikasi isi filter Partner")
    public void verifikasi_isi_filter_Partner() throws InterruptedException {
       rp.verifyPartnerDropDown();
    }

     @And("View data dengan filter Partner_All")
    public void view_data_dengan_filter_Partner_All() throws InterruptedException {
       rp.partnerAll();
    }

     @And("View data dengan filter Partner_pilih salah satu")
    public void view_data_dengan_filter_Partner_pilih_salah_satu() throws InterruptedException {
       rp.partnerAkeseleran();
       rp.setPartnerAll();
    }

     @And("Verifikasi isi filter Status Amount Repayment")
    public void verifikasi_isi_filter_Status_Amount_Repayment(List<String> dataTable) {
        rp.amountRepaymentDropDownList();
    }

     @And("View data dengan filter Status Amount Repayment_All")
    public void view_data_dengan_filter_Status_Amount_Repayment_All() throws InterruptedException {
       rp.amountRepaymentAll();
    }

     @And("View data dengan filter Status Amount Repayment_Sesuai")
    public void view_data_dengan_filter_Status_Amount_Repayment_Sesuai() throws InterruptedException {
       rp.amountRepaymentSesuai();
    }

     @And("View data dengan filter Status Amount Repayment_Kurang Bayar")
    public void view_data_dengan_filter_Status_Amount_Repayment_Kurang_Bayar() throws InterruptedException {
       rp.amountRepaymentKurangBayar();
    }

     @And("View data dengan filter Status Amount Repayment_Lebih Bayar")
    public void view_data_dengan_filter_Status_Amount_Repayment_Lebih_Bayar() throws InterruptedException {
       rp.amountRepaymentLebihBayar();
       rp.setStatusRepaymentAll();
    }

     @And("Verifikasi isi filter Status Batch No")
    public void verifikasi_isi_filter_Status_Batch_No() {
        rp.batchNoDropDownList();
    }

     @And("View data dengan filter Batch No_pilih salah satu")
    public void view_data_dengan_filter_Batch_No_pilih_salah_satu() throws InterruptedException {
       rp.batchNo1();
    }

     @And("Verifikasi filter search")
    public void verifikasi_filter_search() {
       
    }

     @And("Verifikasi kolom Source untuk realisasi via LOS")
    public void verifikasi_kolom_Source_untuk_realisasi_via_LOS() {
       
    }

     @And("Verifikasi kolom Source untuk realisasi via NIKEL")
    public void verifikasi_kolom_Source_untuk_realisasi_via_NIKEL() {
       
    }

     @And("Verifikasi kolom Application No")
    public void verifikasi_kolom_Application_No() {
       
    }

     @And("Verifikasi kolom Partner")
    public void verifikasi_kolom_Partner() {
       
    }

     @And("Verifikasi kolom Debtor Name")
    public void verifikasi_kolom_Debtor_Name() {
       
    }

     @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_N")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_N() {
       
    }

     @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_Y")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_Y() {
       
    }

     @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_I")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_I() {
       
    }

     @And("Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_A")
    public void verifikasi_kolom_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_A() {
       
    }

     @And("Verifikasi kolom Status setelah job repayment")
    public void verifikasi_kolom_Status_setelah_job_repayment() {
       
    }

     @And("Verifikasi kolom Tanggal Pembayaran")
    public void verifikasi_kolom_Tanggal_Pembayaran() {
       
    }

     @And("Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_ nominal bunga_ nominal denda_ dan additional interest")
    public void verifikasi_kolom_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_nominal_denda_dan_additional_interest() {
       
    }

     @And("Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_ nominal bunga_ dan additional interest \\(nominal denda kosong)")
    public void verifikasi_kolom_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_dan_additional_interest_nominal_denda_kosong() {
       
    }

     @And("Verifikasi kolom Total Tagihan")
    public void verifikasi_kolom_Total_Tagihan() {
       
    }

     @And("Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment lebih kecil jumlah tagihan")
    public void verifikasi_kolom_Status_Amount_Pembayaran_dengan_kondisi_total_pembayaran_pada_file_repayment_lebih_kecil_jumlah_tagihan() {
       
    }

     @And("Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment sama dengan jumlah tagihan")
    public void verifikasi_kolom_Status_Amount_Pembayaran_dengan_kondisi_total_pembayaran_pada_file_repayment_sama_dengan_jumlah_tagihan() {
       
    }

     @And("Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment lebih besar jumlah tagihan")
    public void verifikasi_kolom_Status_Amount_Pembayaran_dengan_kondisi_total_pembayaran_pada_file_repayment_lebih_besar_jumlah_tagihan() {
       
    }

     @And("Verifikasi kolom Tanggal Masuk File")
    public void verifikasi_kolom_Tanggal_Masuk_File() {
       
    }

     @And("Verifikasi kolom Batch No")
    public void verifikasi_kolom_Batch_No() {
       
    }

     @And("Verifikasi sorting kolom Status")
    public void verifikasi_sorting_kolom_Status() {
       
    }

     @And("Verifikasi sorting kolom Tanggal Pembayaran")
    public void verifikasi_sorting_kolom_Tanggal_Pembayaran() {
       
    }

     @And("Klik Previous pada Pagination")
    public void klik_Previous_pada_Pagination() {
       
    }

     @And("Klik Next pada Pagination")
    public void klik_Next_pada_Pagination() {
       
    }

     @And("Klik page tertentu pada Pagination")
    public void klik_page_tertentu_pada_Pagination() {
       
    }

     @And("Verifikasi tanggal pada menu Repayment")
    public void verifikasi_tanggal_pada_menu_Repayment() {
       
    }

     @And("Verifikasi Total Nominal Approved")
    public void verifikasi_Total_Nominal_Approved() {
       
    }

     @And("Verifikasi Total Nominal Pembayaran")
    public void verifikasi_Total_Nominal_Pembayaran() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Klik Approve")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Approve() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Klik Approve-Klik Batal")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Approve_Klik_Batal() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Klik Approve-Klik Submit")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Approve_Klik_Submit() {
       
    }

     @And("Klik Bulk Approve-Check All-Klik Approve")
    public void klik_Bulk_Approve_Check_All_Klik_Approve() {
       
    }

     @And("Klik Bulk Approve-Check All-Klik Approve-Klik Batal")
    public void klik_Bulk_Approve_Check_All_Klik_Approve_Klik_Batal() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Klik Reject")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Reject() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Klik Reject-Klik Batal")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Reject_Klik_Batal() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Klik Reject-Klik Submit")
    public void klik_Bulk_Approve_Check_beberapa_data_Klik_Reject_Klik_Submit() {
       
    }

     @And("Klik Bulk Approve-Check All-Klik Reject")
    public void klik_Bulk_Approve_Check_All_Klik_Reject() {
       
    }

     @And("Klik Bulk Approve-Check All-Klik Reject-Klik Batal")
    public void klik_Bulk_Approve_Check_All_Klik_Reject_Klik_Batal() {
       
    }

     @And("Klik Bulk Approve-Tidak Check Data-Klik Approve")
    public void klik_Bulk_Approve_Tidak_Check_Data_Klik_Approve() {
       
    }

     @And("Klik Bulk Approve-Tidak Check Data-Klik Reject")
    public void klik_Bulk_Approve_Tidak_Check_Data_Klik_Reject() {
       
    }

     @And("Klik Bulk Edit-Check pada beberapa data status Pending Batch Run")
    public void klik_Bulk_Edit_Check_pada_beberapa_data_status_Pending_Batch_Run() {
       
    }

     @And("Klik Bulk Edit-Check All")
    public void klik_Bulk_Edit_Check_All() {
       
    }

     @And("Klik Bulk Edit-Check pada beberapa data status Pending Batch Run-Klik Cancel")
    public void klik_Bulk_Edit_Check_pada_beberapa_data_status_Pending_Batch_Run_Klik_Cancel() {
       
    }

     @And("Klik Bulk Edit-Check pada beberapa data status Pending Batch Run-Klik Change Status")
    public void klik_Bulk_Edit_Check_pada_beberapa_data_status_Pending_Batch_Run_Klik_Change_Status() {
       
    }

     @And("Klik Bulk Edit-Check All-Klik Cancel")
    public void klik_Bulk_Edit_Check_All_Klik_Cancel() {
       
    }

     @And("Approve data yang telah di update statusnya")
    public void approve_data_yang_telah_di_update_statusnya() {
       
    }

     @And("Reject data yang telah di update statusnya")
    public void reject_data_yang_telah_di_update_statusnya() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data")
    public void klik_Bulk_Approve_Check_beberapa_data() {
       
    }

     @And("Klik Bulk Approve-Check beberapa data-Uncheck beberapa data")
    public void klik_Bulk_Approve_Check_beberapa_data_Uncheck_beberapa_data() {
       
    }

     @And("Klik Bulk Approve-Check All")
    public void klik_Bulk_Approve_Check_All() {
       
    }

     @And("Verifikasi card Detail-Tanggal Masuk File")
    public void verifikasi_card_Detail_Tanggal_Masuk_File() {
       
    }

     @And("Verifikasi card Detail-Batch No")
    public void verifikasi_card_Detail_Batch_No() {
       
    }

     @And("Verifikasi card Detail-Nomor Aplikasi")
    public void verifikasi_card_Detail_Nomor_Aplikasi() {
       
    }

     @And("Verifikasi card Detail-Nama Debitur")
    public void verifikasi_card_Detail_Nama_Debitur() {
       
    }

     @And("Verifikasi card Detail-Partner")
    public void verifikasi_card_Detail_Partner() {
       
    }

     @And("Verifikasi card Detail-Nomor Pembayaran")
    public void verifikasi_card_Detail_Nomor_Pembayaran() {
       
    }

     @And("Verifikasi card Detail-Status Amount Repayment dengan kondisi total pembayaran pada file repayment lebih kecil jumlah tagihan")
    public void verifikasi_card_Detail_Status_Amount_Repayment_dengan_kondisi_total_pembayaran_pada_file_repayment_lebih_kecil_jumlah_tagihan() {
       
    }

     @And("Verifikasi card Detail-Status Amount Repayment dengan kondisi total pembayaran pada file repayment sama dengan jumlah tagihan")
    public void verifikasi_card_Detail_Status_Amount_Repayment_dengan_kondisi_total_pembayaran_pada_file_repayment_sama_dengan_jumlah_tagihan() {
       
    }

     @And("Verifikasi card Detail-Status Amount Repayment dengan kondisi total pembayaran pada file repayment lebih besar jumlah tagihan")
    public void verifikasi_card_Detail_Status_Amount_Repayment_dengan_kondisi_total_pembayaran_pada_file_repayment_lebih_besar_jumlah_tagihan() {
       
    }

     @And("Verifikasi card Hasil Approval-Status \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Status_setelah_job_consume() {
       
    }

     @And("Verifikasi card Hasil Approval-Approved by \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Approved_by_setelah_job_consume() {
       
    }

     @And("Verifikasi card Hasil Approval-Tanggal Approval \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Tanggal_Approval_setelah_job_consume() {
       
    }

     @And("Verifikasi card Hasil Approval-Type Reject Reason \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Type_Reject_Reason_setelah_job_consume() {
       
    }

     @And("Verifikasi card Hasil Approval-Deskripsi \\(setelah job consume)")
    public void verifikasi_card_Hasil_Approval_Deskripsi_setelah_job_consume() {
       
    }

     @And("Verifikasi card Data Partner-Tanggal Pembayaran")
    public void verifikasi_card_Data_Partner_Tanggal_Pembayaran() {
       
    }

     @And("Verifikasi card Data Partner-Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_nominal bunga_nominal denda_dan additional interest")
    public void verifikasi_card_Data_Partner_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_nominal_denda_dan_additional_interest() {
       
    }

     @And("Verifikasi card Data Partner-Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_nominal bunga_dan additional interest \\(nominal denda kosong)")
    public void verifikasi_card_Data_Partner_Total_Pembayaran_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok_nominal_bunga_dan_additional_interest_nominal_denda_kosong() {
       
    }

     @And("Verifikasi card Data Partner-Pembayaran Pokok dengan kondisi pada file repayment terisi nominal pokok")
    public void verifikasi_card_Data_Partner_Pembayaran_Pokok_dengan_kondisi_pada_file_repayment_terisi_nominal_pokok() {
       
    }

     @And("Verifikasi card Data Partner-Pembayaran Pokok dengan kondisi pada file repayment nominal pokok_0")
    public void verifikasi_card_Data_Partner_Pembayaran_Pokok_dengan_kondisi_pada_file_repayment_nominal_pokok_0() {
       
    }

     @And("Verifikasi card Data Partner-Pembayaran Bunga dengan kondisi pada file repayment terisi nominal bunga")
    public void verifikasi_card_Data_Partner_Pembayaran_Bunga_dengan_kondisi_pada_file_repayment_terisi_nominal_bunga() {
       
    }

     @And("Verifikasi card Data Partner-Pembayaran Bunga dengan kondisi pada file repayment nominal bunga_0")
    public void verifikasi_card_Data_Partner_Pembayaran_Bunga_dengan_kondisi_pada_file_repayment_nominal_bunga_0() {
       
    }

     @And("Verifikasi card Data Partner-Pembayaran Denda dengan kondisi pada file repayment terisi nominal denda")
    public void verifikasi_card_Data_Partner_Pembayaran_Denda_dengan_kondisi_pada_file_repayment_terisi_nominal_denda() {
       
    }

     @And("Verifikasi card Data Partner-Pembayaran Denda dengan kondisi pada file repayment nominal denda_0")
    public void verifikasi_card_Data_Partner_Pembayaran_Denda_dengan_kondisi_pada_file_repayment_nominal_denda_0() {
       
    }

     @And("Verifikasi card Data Partner-Additional Interest dengan kondisi pada file repayment terisi Additional Interest")
    public void verifikasi_card_Data_Partner_Additional_Interest_dengan_kondisi_pada_file_repayment_terisi_Additional_Interest() {
       
    }

     @And("Verifikasi card Data Partner-Additional Interest dengan kondisi pada file repayment Additional Interest_0")
    public void verifikasi_card_Data_Partner_Additional_Interest_dengan_kondisi_pada_file_repayment_Additional_Interest_0() {
       
    }

     @And("Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_N")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_N() {
       
    }

     @And("Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_Y")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_Y() {
       
    }

     @And("Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_I")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_I() {
       
    }

     @And("Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_A")
    public void verifikasi_card_Data_Partner_Status_Pembayaran_dengan_kondisi_Pelunasan_pada_file_Repayment_A() {
       
    }

     @And("Verifikasi card Data BCAD-Tanggal Pembayaran Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Tanggal_Pembayaran_Bulan_Berjalan() {
       
    }

     @And("Verifikasi card Data BCAD-Total Tagihan")
    public void verifikasi_card_Data_BCAD_Total_Tagihan() {
       
    }

     @And("Verifikasi card Data BCAD-Pembayaran Pokok Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Pembayaran_Pokok_Bulan_Berjalan() {
       
    }

     @And("Verifikasi card Data BCAD-Pembayaran Bunga Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Pembayaran_Bunga_Bulan_Berjalan() {
       
    }

     @And("Verifikasi card Data BCAD-Pembayaran Denda Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Pembayaran_Denda_Bulan_Berjalan() {
       
    }

     @And("Verifikasi card Data BCAD-Additional Interest Bulan Berjalan")
    public void verifikasi_card_Data_BCAD_Additional_Interest_Bulan_Berjalan() {
       
    }

     @And("Klik Approve button di Halaman detail Repayment")
    public void klik_Approve_button_di_Halaman_detail_Repayment() {
       
    }

     @And("Klik Approve-Klik Tidak")
    public void klik_Approve_Klik_Tidak() {
       
    }

     @And("Klik Approve-Klik Ya")
    public void klik_Approve_Klik_Ya() {
       
    }

     @And("Verifikasi card Hasil Approval setelah Approve data")
    public void verifikasi_card_Hasil_Approval_setelah_Approve_data() {
       
    }

     @And("Klik Reject button di Halaman detail Repayment")
    public void klik_Reject_button_di_Halaman_detail_Repayment() {
       
    }

     @And("Verifikasi isi field Type Reject Reason")
    public void verifikasi_isi_field_Type_Reject_Reason() {
       
    }

     @And("Klik Reject-Klik Cancel")
    public void klik_Reject_Klik_Cancel() {
       
    }

     @And("Klik Reject-Mengisi Type Reject Reason-Tidak mengisi Description-Klik Submit")
    public void klik_Reject_Mengisi_Type_Reject_Reason_Tidak_mengisi_Description_Klik_Submit() {
       
    }

     @And("Klik Reject-Tidak Mengisi Type Reject Reason-Mengisi Description-Klik Submit")
    public void klik_Reject_Tidak_Mengisi_Type_Reject_Reason_Mengisi_Description_Klik_Submit() {
       
    }

    @And("Klik Reject-Mengisi Type Reject Reason-Mengisi Description100_karakter_alfanumerik plus simbol-Klik Submit")
    public void klikRejectMengisiTypeRejectReasonMengisiDescription100_Karakter_alfanumerikPlusSimbolKlikSubmit() {
    }

    @And("Klik Reject-Mengisi Type Reject Reason-Mengisi Description99_karakter_alfanumerik plus simbol-Klik Submit")
    public void klikRejectMengisiTypeRejectReasonMengisiDescription99_karakter_alfanumerikPlusSimbolKlikSubmit() {
    }

     @And("Verifikasi card Hasil Approval setelah Reject data")
    public void verifikasi_card_Hasil_Approval_setelah_Reject_data() {
       
    }

     @And("Cek data repayment dengan status Waiting for Approval")
    public void cek_data_repayment_dengan_status_Waiting_for_Approval() {
       
    }

     @And("Cek data repayment dengan status Approved")
    public void cek_data_repayment_dengan_status_Approved() {
       
    }

     @And("Cek data repayment dengan status Rejected")
    public void cek_data_repayment_dengan_status_Rejected() {
       
    }

     @And("Cek data repayment dengan status Pending Batch Run")
    public void cek_data_repayment_dengan_status_Pending_Batch_Run() {
       
    }

     @And("Cek data repayment dengan status Approval Expired")
    public void cek_data_repayment_dengan_status_Approval_Expired() {
       
    }

     @And("Klik Edit pada data Waiting for Approval-Edit pada data-Klik Update")
    public void klik_Edit_pada_data_Waiting_for_Approval_Edit_pada_data_Klik_Update() {
       
    }

     @And("Klik Edit pada data Rejected-Edit pada data-Klik Update")
    public void klik_Edit_pada_data_Rejected_Edit_pada_data_Klik_Update() {
       
    }

     @And("Klik Edit pada data Pending Batch Run-Edit pada data-Klik Update")
    public void klik_Edit_pada_data_Pending_Batch_Run_Edit_pada_data_Klik_Update() {
       
    }

     @And("Approve data yang diedit")
    public void approve_data_yang_diedit() {
       
    }

     @And("Reject data yang diedit")
    public void reject_data_yang_diedit() {
       
    }

     @And("Verifikasi card Hasil Approval setelah Bulk Approve data")
    public void verifikasi_card_Hasil_Approval_setelah_Bulk_Approve_data() {
       
    }

     @And("Verifikasi card Hasil Approval setelah Bulk Reject data")
    public void verifikasi_card_Hasil_Approval_setelah_Bulk_Reject_data() {
       
    }


}
