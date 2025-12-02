# Tabungan Harian (Micro-Saving App)

Aplikasi Android untuk membantu pengguna mengelola tabungan harian dengan mudah dan menyenangkan.

## 📱 Fitur Utama

### 6 Halaman Lengkap:

1. **Beranda** - Dashboard utama dengan ringkasan total tabungan dan tujuan teratas
2. **Daftar Tujuan** - Melihat semua tujuan tabungan yang aktif
3. **Detail Tujuan** - Melihat progress dan riwayat setoran untuk tujuan tertentu
4. **Riwayat Tabungan** - Melihat semua transaksi setoran dari semua tujuan
5. **Manajemen Tujuan** - Menambah tujuan tabungan baru
6. **Pengaturan** - Mengatur mode gelap dan reset data

## 🎨 Teknologi

- **Kotlin** - Bahasa pemrograman modern untuk Android
- **Jetpack Compose** - UI toolkit deklaratif
- **Material Design 3** - Design system terbaru dari Google
- **Navigation Compose** - Navigasi antar layar
- **ViewModel** - Pengelolaan state yang lifecycle-aware

## 🚀 Cara Menjalankan

1. Buka terminal di folder proyek
2. Jalankan perintah:
   ```
   ./gradlew assembleDebug
   ```
3. Install ke emulator:
   ```
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## 📁 Struktur Proyek

```
app/src/main/java/com/example/microsaving/
├── model/
│   ├── SavingGoal.kt
│   ├── SavingContribution.kt
│   └── DummyData.kt
├── state/
│   └── SavingViewModel.kt
├── ui/
│   ├── components/
│   │   ├── GoalCard.kt
│   │   ├── ProgressHeader.kt
│   │   └── HistoryItem.kt
│   ├── navigation/
│   │   ├── Destinations.kt
│   │   └── NavGraph.kt
│   ├── screens/
│   │   ├── BerandaScreen.kt
│   │   ├── DaftarTujuanScreen.kt
│   │   ├── DetailTujuanScreen.kt
│   │   ├── RiwayatTabunganScreen.kt
│   │   ├── ManajemenTujuanScreen.kt
│   │   └── PengaturanScreen.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
└── MainActivity.kt
```

## 💡 Catatan

- Aplikasi ini menggunakan data dummy untuk demo
- Mode gelap dapat diaktifkan di halaman Pengaturan
- Data dapat direset ke kondisi awal melalui Pengaturan

---

Dibuat dengan ❤️ menggunakan Jetpack Compose
