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
    fun getAllActive(): Flow<List<Belanja>>  // Observe active Belanja items

    @Query("SELECT * FROM Belanja WHERE isDeleted = 1 ORDER BY id DESC")
    fun getDeleted(): Flow<List<Belanja>>  // Observe deleted Belanja items

    @Query("SELECT * FROM Belanja WHERE id = :id LIMIT 1")
    suspend fun getBelanjaById(id: Long): Belanja?  // Get a specific Belanja item by ID

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(belanja: Belanja)  // Insert new or update an existing Belanja

    @Update
    suspend fun update(belanja: Belanja)  // Update an existing Belanja

    @Delete
    suspend fun delete(belanja: Belanja)  // Delete a Belanja item

    @Query("DELETE FROM Belanja WHERE id = :id")
    suspend fun deleteById(id: Long)  // Delete Belanja by ID
}
