package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.database.BelanjaDao
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.model.Belanja
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class MainViewModel(private val dao: BelanjaDao) : ViewModel() {
    val data = dao.getAllActive().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val deletedItems = dao.getDeleted().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun restoreItem(item: Belanja) {
        viewModelScope.launch {
            dao.update(item.copy(isDeleted = false))
        }
    }

    fun deletePermanent(item: Belanja) {
        viewModelScope.launch {
            dao.delete(item)
        }
    }

    suspend fun getBelanja(id: Long): Belanja? {
        return dao.getBelanjaById(id)
    }

    fun insert(namaBarang: String, jumlah: Int, keterangan: String) {
        val belanja = Belanja(
            namaBarang = namaBarang,
            jumlah = jumlah.toString(),
            keterangan = keterangan,
            tanggal = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())
        )
        viewModelScope.launch {
            dao.insert(belanja)
        }
    }

    fun update(id: Long, namaBarang: String, jumlah: Int, keterangan: String) {
        val belanja = Belanja(
            id = id,
            namaBarang = namaBarang,
            jumlah = jumlah.toString(),
            keterangan = keterangan,
            tanggal = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())
        )
        viewModelScope.launch {
            dao.update(belanja)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch {
            dao.deleteById(id)
        }
    }
}
