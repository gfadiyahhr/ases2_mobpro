package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.database.BelanjaDao
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.model.Belanja
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class DetailViewModel(private val dao: BelanjaDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    // Fungsi untuk menyisipkan Belanja baru
    fun insert(namaBarang: String, keterangan: String, jumlah: String) {
        val belanja = Belanja(
            tanggal = formatter.format(Date()),
            namaBarang = namaBarang,
            keterangan = keterangan,
            jumlah = jumlah,
            isDeleted = false // Menandakan bahwa data tidak dihapus
        )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.insert(belanja)
            } catch (e: Exception) {
                Log.e("DetailViewModel", "Error inserting note: ${e.message}")
            }
        }
    }

    // Fungsi untuk mendapatkan Belanja berdasarkan ID
    fun getBelanja(id: Long, onResult: (Belanja?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val belanja = dao.getBelanjaById(id)
                onResult(belanja)
            } catch (e: Exception) {
                Log.e("DetailViewModel", "Error fetching note: ${e.message}")
                onResult(null)
            }
        }
    }

    // Fungsi untuk memperbarui Belanja berdasarkan ID
    fun update(id: Long, namaBarang: String, keterangan: String, jumlah: String) {
        val belanja = Belanja(
            id = id,
            tanggal = formatter.format(Date()),
            namaBarang = namaBarang,
            keterangan = keterangan,
            jumlah = jumlah,
            isDeleted = false // Menjaga isDeleted tetap false saat update
        )

        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.update(belanja)
            } catch (e: Exception) {
                Log.e("DetailViewModel", "Error updating note: ${e.message}")
            }
        }
    }

    // Fungsi untuk menghapus Belanja berdasarkan ID
    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                dao.deleteById(id)
            } catch (e: Exception) {
                Log.e("DetailViewModel", "Error deleting note: ${e.message}")
            }
        }
    }
}
