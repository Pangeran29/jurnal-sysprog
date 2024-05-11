package org.d3if3030.mobpro1_compose.util

import MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3030.mobpro1_compose.database.CatatanDao
import org.d3if3030.mobpro1_compose.ui.screen.DetailViewModel

class ViewModelFactory(
    private val dao: CatatanDao,
    private val title :String = ""
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao, title) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}