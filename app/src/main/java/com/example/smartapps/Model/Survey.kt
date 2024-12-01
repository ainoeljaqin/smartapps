package com.example.smartapps.Model

data class Survey(
    val user: String,
    val nama_lengkap: String,
    val pekerjaan: String,
    val pendapatan: Double,
    val makanan: Double,
    val pendidikan: Double,
    val kesehatan: Double,
    val pajak_transportasi: Double,
    val pajak_pbb: Double,
    val listrik_per_bulan: Double,
    val akses_layanan_kesehatan: Boolean,
    val akses_layanan_keuangan: Boolean,
    val akses_bantuan_pemerintah: Boolean
)
