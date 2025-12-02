package com.example.microsaving.ui.navigation

sealed class Destinations(val route: String) {
    object Beranda : Destinations("beranda")
    object DaftarTujuan : Destinations("daftar_tujuan")
    object DetailTujuan : Destinations("detail_tujuan/{goalId}") {
        fun createRoute(goalId: String) = "detail_tujuan/$goalId"
    }
    object RiwayatTabungan : Destinations("riwayat_tabungan")
    object ManajemenTujuan : Destinations("manajemen_tujuan")
    object Pengaturan : Destinations("pengaturan")
}
