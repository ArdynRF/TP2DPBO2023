# TP2DPBO2023

## Janji
Saya Ardyn Rezky Fahreza NIM 2103551 mengerjakan soal TP 2 dalam mata kuliah Desain Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Spesifikasi Soal
- Program bebas, kecuali program Mahasiswa dan Book Author
- Terdapat proses Create, Read, Update, dan Delete data
- Terdapat proses Autentikasi (Login, Register) *
- Menggunakan minimal 2 tabel pada database
- Harus terdapat minimal 1 properti gambar pada class yang dibuat (gambar akan ditampilkan pada UI)
- Terdapat pergantian screen pada UI
- Terdapat button navigasi untuk beralih screen
- List data ditampilkan menggunakan card (JPanel)

## Design Program
Program ini memiliki 3 `Java class`, yaitu:
- `Anime`       -> kelas ini merupakan kelas yang digunakan untuk menginisialisasi atribut-atribut dari kelas `Anime` ini masing masing atribut memiliki fungsi setter dan getter nya
- `Studio`      -> kelas ini merupakan kelas yang digunakan untuk menginisialisasi atribut-atribut dari kelas `Studio` ini masing masing atribut memiliki fungsi setter dan getter nya
- `dbConnection` -> kelas ini digunakan untk melakukan koneksi ke database. Kelas ini memiliki dua atibut ,yaitu:
    - stmt  -> tipe data Statement
    - conn  -> tipe data Connection

Method method yang ada pada kelas ini diperlukan untuk memudahkan proses query dari aplikasi ke database.

Lalu, Program ini juga meiliki 4 `Jframe Form`, yaitu:
- `Login`       -> Kelas login ini digunakan sebagai `Main` yang akan muncul dihalaman paling awal saat program dijalankan, kelas ini mengimplementasikan frame untuk login.
- `Display`     -> Kelas ini digunakan untuk menampilkan Jpanel dalam bentuk card yang berisi informasi-informasi calam bentuk GridLayout
- `StudioForm`  -> kelas ini mengimplementasikan frame untuk Form menambah dan mengedit data pada Card Studio. Frame ini memiliki button `Submit` yang akan berubah fungsi ketika button yang diklik edit atau add.
- `AnimeForm`   -> kelas ini mengimplementasikan frame untuk Form menambah dan mengedit data pada Card Anime. Frame ini memiliki button `Submit` yang akan berubah fungsi ketika button yang diklik edit atau add.

Lalu, Program ini juga memiliki 2 `Jpanel Form`, yaitu:
- `studioPanel` -> kelas ini digunakan sebagai card yang akan menampilkan informasi-informasi tentang anime, setelah itu card ini akan ditampilkan secara Gridlayout dihalaman Display.
- `animePanel`  -> kelas ini digunakan sebagai card yang akan menampilkan informasi-informasi tentang studio, setelah itu card ini akan ditampilkan secara Gridlayout dihalaman Display.

## Alur Program
1. Pertama user akan disuruh untuk login
    Username : admin
    pass : admin
2. Masuk ke menu utama Daftar Anime
3. Jika ingin menambah data anime, user hanya klik button `Add` lalu memasukkan data anime baru ke dalam form yang telah disediakan
4. Jika ingin mengedit data yang telah ada, user hanya perlu klik tombol `edit` yang ada pada card yang dipilih, lalu isi form yang telah disediakan
5. begitu pula dengan Delete
6. User bisa menekan button `Studio` untuk melihat data studio
7. Di halaman studio user dapat melakukan hal yang sama pada halaman daftar anime.

## Dokumentasi Program
* **Halaman Login**

![Screenshot - ](https://github.com/ArdynRF/TP2DPBO2023/blob/main/Dokumentasi/loginPage.png)

* **Halaman Daftar Anime**

![Screenshot - ](https://github.com/ArdynRF/TP2DPBO2023/blob/main/Dokumentasi/AnimePage.png)

* **Halaman Menambah Anime**

![Screenshot - ](https://github.com/ArdynRF/TP2DPBO2023/blob/main/Dokumentasi/AddAnime.png)

* **Halaman Setelah Delete**
 
![Screenshot - ](https://github.com/ArdynRF/TP2DPBO2023/blob/main/Dokumentasi/Deleted.png)

* **Halaman Edit Anime**

![Screenshot - ](https://github.com/ArdynRF/TP2DPBO2023/blob/main/Dokumentasi/EditAnime.png)

* **Halaman Daftar Studio**

![Screenshot - ](https://github.com/ArdynRF/TP2DPBO2023/blob/main/Dokumentasi/StudioPage.png)
