package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.model.Belanja

@Database(entities = [Belanja::class], version = 1, exportSchema = false)
abstract class BelanjaDb : RoomDatabase() {

    abstract val dao: BelanjaDao

    companion object {
        @Volatile
        private var INSTANCE: BelanjaDb? = null

        // Singleton pattern for obtaining the database instance
        fun getInstance(context: Context): BelanjaDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BelanjaDb::class.java,
                    "belanja.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
