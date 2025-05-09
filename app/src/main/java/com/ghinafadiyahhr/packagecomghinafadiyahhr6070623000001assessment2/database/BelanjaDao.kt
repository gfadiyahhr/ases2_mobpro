package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.model.Belanja
import kotlinx.coroutines.flow.Flow

@Dao
interface BelanjaDao {

    @Query("SELECT * FROM Belanja WHERE isDeleted = 0 ORDER BY id DESC")
    fun getAllActive(): Flow<List<Belanja>>

    @Query("SELECT * FROM Belanja WHERE isDeleted = 1 ORDER BY id DESC")
    fun getDeleted(): Flow<List<Belanja>>

    @Query("SELECT * FROM Belanja WHERE id = :id LIMIT 1")
    suspend fun getBelanjaById(id: Long): Belanja?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(belanja: Belanja)

    @Update
    suspend fun update(belanja: Belanja)
    @Delete
    suspend fun delete(belanja: Belanja)

    @Query("DELETE FROM Belanja WHERE id = :id")
    suspend fun deleteById(id: Long)
}
