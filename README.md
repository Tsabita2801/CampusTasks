
# CampusTasks – Kotlin Domain Model

## 1. Deskripsi
CampusTasks merupakan implementasi domain model menggunakan Kotlin untuk mengelola data tugas mahasiswa. Sistem ini mendukung pembuatan tugas, validasi data, pengelompokan tugas, pencarian, dan pengurutan berdasarkan prioritas.

## 2. Struktur Domain Model

| File | Fungsi |
|---|---|
| Task.kt | Menyimpan data tugas menggunakan data class |
| Identifiable.kt | Interface untuk objek yang memiliki ID |
| TaskPriority.kt | Enum prioritas tugas |
| TaskStatus.kt | Enum status tugas |
| CreateTaskResult.kt | Sealed interface hasil pembuatan tugas |
| TaskValidator.kt | Memvalidasi data tugas |
| TaskFactory.kt | Membuat tugas dan melakukan normalisasi |
| TaskQueries.kt | Filter, pencarian, dan pengurutan tugas |
| TaskCollection.kt | Generic function untuk pencarian objek berdasarkan ID |

## 3. Aturan Domain

1. ID tugas tidak boleh kosong.
2. Judul tugas harus terdiri dari 3–80 karakter.
3. Estimasi pengerjaan harus berada antara 5–480 menit.
4. Tag tidak boleh kosong.
5. Judul tugas dihapus spasi berlebih di awal dan akhir.
6. Tag dinormalisasi menjadi huruf kecil.
7. Prioritas terdiri dari LOW, MEDIUM, dan HIGH.
8. Status terdiri dari TODO, IN_PROGRESS, dan DONE.

## 4. Pengujian

Pengujian dilakukan menggunakan JUnit 4 melalui perintah:

```bash
./gradlew testDebugUnitTest
```

Total terdapat 22 unit test yang mencakup:
- Validasi data.
- Pembuatan tugas.
- Normalisasi data.
- Pencarian dan pengurutan.
- Generic function.
- Kondisi berhasil, gagal, dan batas nilai.

## 5. Refleksi

Dalam pengerjaan tugas ini, saya mempelajari bagaimana menyusun domain model menggunakan bahasa pemrograman Kotlin. Saya memahami penggunaan data class untuk merepresentasikan data tugas, enum class untuk menentukan prioritas dan status, serta sealed interface untuk membedakan hasil proses pembuatan tugas.

Saya juga mempelajari pentingnya validasi sebelum data digunakan. Melalui TaskValidator dan TaskFactory, data yang dimasukkan dapat diperiksa dan dinormalisasi terlebih dahulu sehingga lebih konsisten. Selain itu, penggunaan interface Identifiable dan generic function membantu membuat kode lebih fleksibel dan dapat digunakan kembali.

Pada bagian pengujian, saya menerapkan pendekatan Test-Driven Development dengan membuat pengujian untuk berbagai kondisi, seperti data valid, data tidak valid, dan nilai batas. Proses ini membantu saya menemukan kesalahan lebih awal dan memastikan fungsi berjalan sesuai aturan yang telah ditentukan.

Secara keseluruhan, tugas ini memberikan pemahaman bahwa domain model bukan hanya tentang menyimpan data, tetapi juga mengatur aturan bisnis dan perilaku yang dimiliki oleh suatu objek.

## 6. Penggunaan AI

- **Tool:** ChatGPT.
- **Prompt:** Meminta bantuan untuk memahami implementasi Kotlin Domain Model, membuat validasi, factory, generic function, dan unit test.
- **Bagian yang dipengaruhi:** Struktur domain model, implementasi fungsi, dan rancangan pengujian.
- **Verifikasi:** Menjalankan unit test menggunakan Gradle.
- **Perubahan setelah verifikasi:** Memperbaiki penempatan file pengujian dan konfigurasi dependensi JUnit berdasarkan error yang ditemukan, kemudian menjalankan pengujian kembali.
