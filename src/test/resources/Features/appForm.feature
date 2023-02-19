Feature: Scenario Approval Form

  @appForm
  Scenario: Verify data pada list approval form
    Given open browser and login with UAT user credential
    Then open menu approval form
#    And verify source
#    And verify application no
#    And verify debtor name
#    And verify partner
#    And verify date
#    And verify loan amount
#    And verify rate
##    And verify status
##    And verify reason
##    And verify hasil rekomendasi
#    Then click detail debtor name
#    And verify detail partner name
#    And verify detail debtor name
#    And verify detail status
#    And verify detail application no
#    And verify detail tanggal pengajuan
#    And verify detail jenis debitur
#    And verify detail plafon
#    And verify detail jangka waktu
#    And verify detail interest rate
#    And verify detail NIK
#    And verify detail NPWP
#    And verify detail Dokumen Pendukung(Tidak Upload Dokumen)
#    And verify detail Dokumen Pendukung(Upload Dokumen > 1file.zip)
#    And verify detail Dokumen Pendukung(Upload Dokumen 2kali isi file berbeda)
#    Then click debtor name untuk merubah status menjadi recommended or not recommended
#    And click debtor name berstatus waiting for review
#    And memilih option status recommended dan mengisi deskripsi dengan 5000char dan submit
#    And memilih option not recommended dan mengisi 4999char dan submit
#    Then  click debtor name untuk merubah status menjadi approved & rejected
#    And click debtor name berstatus waiting approval
#    And approve debtor name dan mengisi 5000char dan submit
#    And reject debtor name dan mengisi 4999char dan submit
#    Then click debtor name berstatus approved & rejected & approval expired
#    And click debtor name berstatus approved
#    And click debtor name berstatus rejected
    Then approved yang berstatus waiting approval untuk persiapan data realisasi
#    And click debtor name berstatus approval expired
    Then user logout