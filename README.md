# Tabungan Harian (Micro-Saving App)

Aplikasi Android untuk membantu pengguna mengelola tabungan harian dengan mudah dan menyenangkan.

## 📱 Fitur Utama

### 6 Halaman Lengkap:

1. **Beranda** - Dashboard utama dengan ringkasan total tabungan dan tujuan teratas
2. **Daftar Tujuan** - Melihat semua tujuan tabungan yang aktif
3. **Detail Tujuan** - Melihat progress, riwayat setoran, dan menambah nominal tabungan
4. **Riwayat Tabungan** - Melihat semua transaksi setoran dari semua tujuan
5. **Manajemen Tujuan** - Menambah tujuan tabungan baru dengan target dan tenggat waktu
6. **Pengaturan** - Mengatur mode gelap dan reset data

### Fitur Tambahan:
- ✅ Menambah setoran/tabungan ke tujuan tertentu (dalam Rupiah)
- ✅ Mode Gelap (Dark Mode)
- ✅ Pelacakan progress tabungan dengan persentase
- ✅ Riwayat transaksi lengkap
- ✅ Reset data ke kondisi demo

## 🎨 Teknologi

- **Kotlin** - Bahasa pemrograman modern untuk Android
- **Jetpack Compose** - UI toolkit deklaratif
- **Material Design 3** - Design system terbaru dari Google
- **Navigation Compose** - Navigasi antar layar
- **ViewModel** - Pengelolaan state yang lifecycle-aware

## 📋 Persyaratan

- Android Studio Hedgehog (2023.1.1) atau lebih baru
- JDK 17 atau lebih baru
- Android SDK 34
- Gradle 8.0+
- Emulator atau perangkat Android dengan API 24+ (Android 7.0+)

## 🚀 Cara Menjalankan

### Opsi 1: Menggunakan Android Studio (Direkomendasikan)

1. **Clone repository:**
   ```bash
   git clone https://github.com/clavinorach/micro-saving-app.git
   ```

2. **Buka Android Studio** dan pilih `Open an existing project`

3. **Pilih folder** `micro-saving-app` yang sudah di-clone

4. **Tunggu Gradle sync** selesai (Android Studio akan mengunduh dependencies secara otomatis)

5. **Pilih device/emulator** dari dropdown di toolbar

6. **Klik tombol Run** (▶️) atau tekan `Shift + F10`

### Opsi 2: Menggunakan Command Line

1. **Clone repository:**
   ```bash
   git clone https://github.com/clavinorach/micro-saving-app.git
   cd micro-saving-app
   ```

2. **Build APK:**
   ```bash
   # Linux/macOS
   ./gradlew assembleDebug
   
   # Windows
   .\gradlew.bat assembleDebug
   ```

3. **Install ke emulator/device:**
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

4. **Jalankan aplikasi:**
   ```bash
   adb shell am start -n com.example.microsaving/.MainActivity
   ```

### Opsi 3: Menggunakan VS Code

1. Install extension **Android** dari marketplace
2. Buka folder proyek di VS Code
3. Jalankan build melalui terminal:
   ```powershell
   .\gradlew.bat assembleDebug
   ```
4. Install dan jalankan dengan ADB

## 📁 Struktur Proyek

```
micro-saving-app/
├── app/
│   ├── build.gradle                 # Konfigurasi build module app
│   ├── proguard-rules.pro           # Aturan ProGuard
│   └── src/main/
│       ├── AndroidManifest.xml      # Manifest aplikasi
│       ├── java/com/example/microsaving/
│       │   ├── MainActivity.kt      # Activity utama
│       │   ├── model/               # Data classes
│       │   │   ├── SavingGoal.kt
│       │   │   ├── SavingContribution.kt
│       │   │   └── DummyData.kt
│       │   ├── state/               # ViewModel
│       │   │   └── SavingViewModel.kt
│       │   └── ui/
│       │       ├── components/      # Komponen UI reusable
│       │       │   ├── GoalCard.kt
│       │       │   ├── ProgressHeader.kt
│       │       │   └── HistoryItem.kt
│       │       ├── navigation/      # Navigasi
│       │       │   ├── Destinations.kt
│       │       │   └── NavGraph.kt
│       │       ├── screens/         # Layar aplikasi
│       │       │   ├── BerandaScreen.kt
│       │       │   ├── DaftarTujuanScreen.kt
│       │       │   ├── DetailTujuanScreen.kt
│       │       │   ├── RiwayatTabunganScreen.kt
│       │       │   ├── ManajemenTujuanScreen.kt
│       │       │   └── PengaturanScreen.kt
│       │       └── theme/           # Tema aplikasi
│       │           ├── Color.kt
│       │           ├── Theme.kt
│       │           └── Type.kt
│       └── res/                     # Resources
│           ├── drawable/
│           ├── mipmap-*/
│           ├── values/
│           └── xml/
├── gradle/
│   └── wrapper/
├── build.gradle                     # Konfigurasi build root
├── settings.gradle                  # Pengaturan project
├── gradle.properties                # Properties Gradle
└── README.md
```

## 🔧 Konfigurasi

### Versi SDK
- `compileSdk`: 34
- `minSdk`: 24 (Android 7.0 Nougat)
- `targetSdk`: 34 (Android 14)

### Dependencies Utama
```groovy
// Compose BOM
implementation platform('androidx.compose:compose-bom:2023.10.00')

// Material 3
implementation 'androidx.compose.material3:material3'

// Navigation
implementation 'androidx.navigation:navigation-compose:2.7.5'

// ViewModel
implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2'

// Material Icons Extended
implementation 'androidx.compose.material:material-icons-extended'
```


## 💡 Catatan Pengembangan

- Aplikasi ini menggunakan data dummy untuk demo
- Data disimpan dalam ViewModel (hilang saat aplikasi ditutup)
- Mode gelap dapat diaktifkan di halaman Pengaturan
- Data dapat direset ke kondisi awal melalui Pengaturan

## 🐛 Troubleshooting

### Gradle Sync Failed
- Pastikan menggunakan JDK 17+
- Cek koneksi internet untuk mengunduh dependencies
- Invalidate caches: `File > Invalidate Caches / Restart`

### Emulator Tidak Terdeteksi
- Pastikan ADB berjalan: `adb devices`
- Restart ADB: `adb kill-server && adb start-server`

### Build Error
- Clean project: `./gradlew clean`
- Rebuild: `./gradlew assembleDebug`

## 📄 Lisensi

Proyek ini dibuat untuk tujuan pembelajaran dan demonstrasi.

---

Dibuat dengan ❤️ menggunakan Jetpack Compose
