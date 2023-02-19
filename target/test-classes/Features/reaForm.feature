Feature: Realization Form

  @reaForm
  Scenario: ReaForm
    Given open browser and login with role ldap maker
    Then click icon notifikasi and verify notifikasi when realization consumed in LOS
#    And verify notifikasi after file consumed
    Then click menu realization Form
#    Then verify data form table realization and search application number order by status
    And verify data realization form with status waiting approval
    And verify data realization form with status pending
    And verify data realization form with status approval expired
    Then verify data form table realization form
    And verify data realization source
    And verify data realization application no
    And verify data realization debtor name
    And verify data realization partner
    And verify data realization date
    And verify data realization loan amount
    And verify data realization rate
    Then click debtor name realization
    And verify data detail realization partner
    And verify data detail realization debtor name
    And verify data detail realization status
    And verify data detail realization app no
    And verify data detail realization tanggal pengajuan
    And verify data detail realization jenis debitur
    And verify data detail realization plafon
    And verify data detail realization jangka waktu
    And verify data detail realization interest rate
    And verify data detail realization jenis kredit
    And verify data detail realization jenis penggunaan
    And verify data detail realization nomor PK
    And verify data detail realization tanggal akad
    And verify data detail realization tanggal angsuran I
    And verify data detail realization nomor NPWP
    And verify data detail realization no telp
    And verify data detail realization alamat
    And verify data detail realization alamat kelurahan
    And verify data detail realization alamat kecamatan
    And verify data detail realization alamat kode pos
    And verify data detail realization alamat kode DATI II
    And verify data detail realization biandg usaha
    And verify data detail realization bentuk badan usaha
    And verify data detail realization sektor ekonomi
    And verify data detail realization go public
    And verify data detail realization sandi golongan debitur
    And verify data detail realization penghasilan kotor per tahun
    And verify data detail realization omzet
    And verify data detail realization no akte
    And verify data detail realization no akte terakhir
    And verify data detail realization tanggal akte terakhir
    And verify data detail realization tanggal berdiri
    And verify data detail realization tempat berdiri badan usaha
    Then verify no akte and tangggal akte
    And verify tanggal akte terakhir sama with hari ini
    And verify tanggal akte terakhir sama with kemarin
    And verify tanggal berdiri and tanggal akte terakhir sama serta no akte and no akte terakhir sama
    And verify tanggal berdiri and tanggal akte terakhir berbeda serta no akte and no akte terakhir berbeda
    And verify tanggal berdiri and tanggal akte terakhir berbeda serta no akte and no akte terakhir sama
#    Then click debtor name reaform merubah status waiting approval
#    And click debtor name rea status waiting approval with klik approve
#    And click debtor name rea status waiting approval with klik approve lalu saat confirm box klik tidak
#    And click debtor name rea status waiting approval with klik approve lalu saat confirm box klik ya
#    And click debtor name rea status waiting approval with klik reject
#    And click debtor name rea status waiting approval with klik and pilih reject reason dokumen pendukung tidak sesuai and deskripsi 5000karakter lalu klik reject
#    And click debtor name rea status waiting approval with klik and pilih reject reason pengajuan ditolak and deskripsi 49999karakter lalu klik reject
#    And click debtor name rea status waiting approval with klik and pilih reject reason and deskripsi kosong lalu klik reject
#    Then click debtor name reaform untuk melihat status waiting approval & approved & rejected &  pending & expired
#    And click debtor name rea with status waiting approval
#    And click debtor name rea with status approved
#    And click debtor name rea with status rejected
#    And click debtor name rea with status pending
#    And click debtor name rea with status expired
#    Then reconsume data with merubah data alamat setiap status
#    And reconsume with no aplikasi status rejected
#    And reconsume with no aplikasi status approved
#    And reconsume with no aplikasi status waiting approval
#    And reconsume with no aplikasi status expired
#    And reconsume with no aplikasi status pending
    Then user ldap role logout