package definitions;

import com.opencsv.exceptions.CsvException;
import gueNyobaTestMethod.RealizationForm;
import gueNyobaTestMethod.pengurusBU;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import runner.FormRealizationRunner;
import runner.ReaFormRunner;

import java.io.IOException;

public class pengurusGlu {

    private final WebDriver driver = ReaFormRunner.driver;
    pengurusBU pengurus = new pengurusBU();
    @Given("open browser and login as a role LDAP maker")
    public void open_browser_and_login_as_a_role_LDAP_maker() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.login();
    }

    @Then("open menu realization")
    public void open_menu_realization() {
        // Write code here that turns the phrase above into concrete actions
        pengurus.menuRealizationForm();
    }

    @Then("search appNo and open detail debitur name")
    public void search_appNo_and_open_detail_debitur_name() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.searchAppNo();

    }

    @Then("verifikasi data No Aplikasi 17karakter")
    public void verifikasi_data_No_Aplikasi_17karakter() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNoApp17Char();
    }

    @Then("verifikasi data no jumlah pengurus 2karakter numerik")
    public void verifikasi_data_no_jumlah_pengurus_2karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJmlPeng2Char();
    }

    @Then("verifikasi data sandi jabatan BI 1karakter numerik")
    public void verifikasi_data_sandi_jabatan_BI_1karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJbtnBI1Char();
    }

    @Then("verifikasi data pangsa kepemilikan 5karakter numerik")
    public void verifikasi_data_pangsa_kepemilikan_5karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyPangsa5Char();
    }

    @Then("verifikasi data bentuk pengurus 1karakter")
    public void verifikasi_data_bentuk_pengurus_1karakter() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyBentukPengurus1Char();
    }

    @Then("verifikasi data modal dasar 13karakter numerik")
    public void verifikasi_data_modal_dasar_13karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyModalDasar13Num();
    }

    @Then("verifikasi data modal disetor 13karakter numerik")
    public void verifikasi_data_modal_disetor_13karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyModalDisetor13Num();
    }

    @Then("verifikasi data modal ditempatkan 13karakter numerik")
    public void verifikasi_data_modal_ditempatkan_13karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyModalDitempatkan13Num();
    }

    @Then("verifikasi data NPWP pengurus 15karakter numerik")
    public void verifikasi_data_NPWP_pengurus_15karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNPWP15Char();
    }

    @Then("verifikasi data nama pengurus 60karakter varchar")
    public void verifikasi_data_nama_pengurus_60karakter_varchar() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifNamaPengurus60Char();
    }

    @Then("verifikasi data alamat pengurus 40karakter varchar")
    public void verifikasi_data_alamat_pengurus_40karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltPeng40Char();
    }

    @Then("verifikasi data alamat kelurahan 40karakter varchar")
    public void verifikasi_data_alamat_kelurahan_40karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltKelurahan40Char();
    }

    @Then("verifikasi data alamat kecamatan 40karakter varchar")
    public void verifikasi_data_alamat_kecamatan_40karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltKecamatan40Char();
    }

    @Then("verifikasi data alamat datiII 4karakter numerik")
    public void verifikasi_data_alamat_datiII_4karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltDatiII4Num();
    }

    @Then("verifikasi data no akte 30karakter varchar")
    public void verifikasi_data_no_akte_30karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNoAkte30Char();
    }

    @Then("verifikasi data tgl akte 8karakter varchar")
    public void verifikasi_data_tgl_akte_8karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyTglAkte8Num();
    }

    @Then("verifikasi jenis kelamin pengurusB bentuk pengurus1")
    public void verifikasi_jenis_kelamin_pengurusB_bentuk_pengurus1() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJnsKelPengB();
    }

    @Then("verifikasi input ktp 16karakter numerik")
    public void verifikasi_input_ktp_16karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNoKTP16Char();
    }

    @Then("verifikasi tgl lahir 8karakter numerik ddmmyyyy")
    public void verifikasi_tgl_lahir_8karakter_numerik_ddmmyyyy() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyTglLhr8Num();
    }

    @Then("verifikasi dati 11tempat lahir 4karakter numerik")
    public void verifikasi_dati_11tempat_lahir_4karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyDatiIITmptLahir4Char();
    }

    @Then("verifikasi data no urut pengurus 2karakter numerik")
    public void verifikasi_data_no_urut_pengurus_2karakter_numerik() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNoUrutPeng2Char();
    }

    @Then("verifikasi data sandi jabatan BI 2karakter numerik")
    public void verifikasi_data_sandi_jabatan_BI_2karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJbtnBI2Char();
    }

    @Then("verifikasi data modal dasar 12karakter numerik")
    public void verifikasi_data_modal_dasar_12karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyModalDasar12Num();
    }

    @Then("verifikasi data modal disetor 12karakter numerik")
    public void verifikasi_data_modal_disetor_12karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyModalDisetor12Num();
    }

    @Then("verifikasi data modal ditempatkan 12karakter numerik")
    public void verifikasi_data_modal_ditempatkan_12karakter_numerik() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyModalDitempatkan12Num();
    }

    @Then("verifikasi data nama pengurus 59karakter varchar")
    public void verifikasi_data_nama_pengurus_59karakter_varchar() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNamaPengurus59Char();
    }

    @Then("verifikasi data alamat pengurus 39karakter varchar")
    public void verifikasi_data_alamat_pengurus_39karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltPeng39Char();
    }

    @Then("verifikasi data alamat keluarahn 39karakter varchar")
    public void verifikasi_data_alamat_keluarahn_39karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltKelurahan39Char();
    }

    @Then("verifikasi data alamat kecamatan 39karakter varchar")
    public void verifikasi_data_alamat_kecamatan_39karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyAltKecamatan39();
    }

    @Then("verifikasi data no akte 29karakter varchar")
    public void verifikasi_data_no_akte_29karakter_varchar() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNoAkter29Char();
    }

    @Then("verifikasi jenis kelamin pengurusM bentuk pengurus1")
    public void verifikasi_jenis_kelamin_pengurusM_bentuk_pengurus1() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJnsKelPengM();
    }

    @Then("verifikasi no aplikasi 30karakter")
    public void verifikasi_no_aplikasi_30karakter() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyNoApp30Char();
    }

    @Then("verifikasi jenis kelamin pengurusL bentuk pengurus2")
    public void verifikasi_jenis_kelamin_pengurusL_bentuk_pengurus2() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJnsKelPengL();
    }

    @Then("verifikasi jenis kelamin pengurusP bentuk pengurus2")
    public void verifikasi_jenis_kelamin_pengurusP_bentuk_pengurus2() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyJnsKelPengP();
    }

    @Then("verifikasi pengurus>1 dalam 1file pengurus")
    public void verifikasi_pengurus_1_dalam_1file_pengurus() throws IOException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.verifyDataPengLebihDari1();
    }

    @Then("user logout from Web")
    public void user_logout_from_Web() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        pengurus.logout(driver);
    }

}
