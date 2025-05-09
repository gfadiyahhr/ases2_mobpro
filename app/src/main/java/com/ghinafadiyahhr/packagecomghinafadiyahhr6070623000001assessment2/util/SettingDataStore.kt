package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.util

import android.content.Context
import androidx.datastore.core.DataStore

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "settings_preferences"
)

class SettingsDataStore(private val context: Context) {
    companion object {
        private val IS_LIST = booleanPreferencesKey("is_list")
    }

    // Flow yang akan memberikan data berupa Boolean (default true)
    val layoutFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_LIST] ?: true // Default value true
    }

    // Fungsi untuk menyimpan data layout (list atau grid)
    suspend fun saveLayout(isList: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LIST] = isList
        }
    }
}
