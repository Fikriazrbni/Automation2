Feature: Validate Pengurus BU

  @pengurusBU
  Scenario: Validate Pengurus BU
  Given open browser and login as a role LDAP maker
    Then open menu realization
#    Open detail appNo 1
    And search appNo and open detail debitur name
    And verifikasi data No Aplikasi 17karakter
    And verifikasi data no urut pengurus 2karakter numerik
    And verifikasi data no jumlah pengurus 2karakter numerik
    And verifikasi data sandi jabatan BI 2karakter numerik
    And verifikasi data pangsa kepemilikan 5karakter numerik
    And verifikasi data bentuk pengurus 1karakter
    And verifikasi data modal dasar 12karakter numerik
    And verifikasi data modal disetor 12karakter numerik
    And verifikasi data modal ditempatkan 12karakter numerik
    And verifikasi data NPWP pengurus 15karakter numerik
    And verifikasi data nama pengurus 59karakter varchar
    And verifikasi data alamat pengurus 39karakter varchar
    And verifikasi data alamat keluarahn 39karakter varchar
    And verifikasi data alamat kecamatan 39karakter varchar
    And verifikasi data alamat datiII 4karakter numerik
    And verifikasi data no akte 29karakter varchar
    And verifikasi data tgl akte 8karakter varchar
    And verifikasi jenis kelamin pengurusB bentuk pengurus1
    And verifikasi input ktp 16karakter numerik
    And verifikasi tgl lahir 8karakter numerik ddmmyyyy
    And verifikasi dati 11tempat lahir 4karakter numerik

#    Open and Verify Pengurus 2
    And verifikasi data sandi jabatan BI 1karakter numerik
    And verifikasi data modal dasar 13karakter numerik
    And verifikasi data modal disetor 13karakter numerik
    And verifikasi data modal ditempatkan 13karakter numerik
    And verifikasi data nama pengurus 60karakter varchar
    And verifikasi data alamat pengurus 40karakter varchar
    And verifikasi data alamat kelurahan 40karakter varchar
    And verifikasi data alamat kecamatan 40karakter varchar
    And verifikasi data no akte 30karakter varchar
    And verifikasi jenis kelamin pengurusM bentuk pengurus1
#
    And verifikasi pengurus>1 dalam 1file pengurus
#   Open and Verify Pengurus 3
    And verifikasi jenis kelamin pengurusL bentuk pengurus2
#   Open and Verify Pengurus 4
    And verifikasi jenis kelamin pengurusP bentuk pengurus2
#   Open appNo2 with 30 char
    And verifikasi no aplikasi 30karakter


    Then user logout from Web