# CampusTasks

## Deskripsi
CampusTasks merupakan project Kotlin untuk memodelkan pengelolaan tugas mahasiswa menggunakan konsep domain model.

## Aturan Domain

1. Setiap tugas memiliki ID sebagai identitas.
2. Judul tugas wajib diisi dengan panjang 3–80 karakter.
3. Deskripsi tugas bersifat opsional.
4. Estimasi pengerjaan harus berada pada rentang 5–480 menit.
5. Prioritas terdiri dari LOW, MEDIUM, dan HIGH.
6. Status terdiri dari TODO, IN_PROGRESS, dan DONE.
7. Tag menggunakan Set agar tidak terdapat duplikasi.
8. Tag kosong atau hanya whitespace akan dibersihkan.
9. Hasil pembuatan tugas terdiri dari Success dan Invalid.
10. Perubahan status tugas menghasilkan objek baru.

## Menjalankan Unit Test

Melalui Android Studio, jalankan seluruh test pada folder app/src/test.

Melalui terminal Windows:

```bash
gradlew.bat testDebugUnitTest
```

## Refleksi

Akan dilengkapi setelah implementasi dan pengujian selesai.

## Penggunaan AI

- Tool: ChatGPT.
- Prompt: Membantu memahami konsep Kotlin Domain Model, validasi, collection, dan unit testing.
- Bagian yang dipengaruhi: Penyusunan model domain, validasi, factory, query, dan unit test.
- Verifikasi: Memeriksa kesesuaian implementasi dengan instruksi tugas dan menjalankan seluruh unit test.
- Perubahan setelah verifikasi: Akan dilengkapi berdasarkan perubahan yang benar-benar dilakukan.