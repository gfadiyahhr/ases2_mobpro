package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Belanja(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val namaBarang: String,
    val jumlah: String,
    val keterangan: String,
    val tanggal: String,
    val isDeleted: Boolean = false
)
