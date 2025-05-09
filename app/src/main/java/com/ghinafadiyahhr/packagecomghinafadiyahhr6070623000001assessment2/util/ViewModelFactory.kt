package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.database.BelanjaDao
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.DetailViewModel
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.MainViewModel

class ViewModelFactory (
    private val dao : BelanjaDao
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T: ViewModel>create(modelClass: Class<T>):T{
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(dao) as T
        }else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}