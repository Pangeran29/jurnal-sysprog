package org.d3if3030.mobpro1_compose.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3030.mobpro1_compose.database.CatatanDao
import org.d3if3030.model.Catatan

class DetailViewModel(private val dao: CatatanDao) : ViewModel() {
    fun insert(topic: String, journal: String, book: String, understand: String) {
        val data = Catatan(
            topic = topic,
            journal = journal,
            book = book,
            understand = understand
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(data)
        }
    }
    suspend fun getById(id: Long): Catatan? {
        return dao.getById(id)
    }

    fun update(id: Long, topic: String, journal: String, book: String, understand: String) {
        val data = Catatan (
            id = id,
            topic = topic,
            journal = journal,
            book = book,
            understand = understand
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(data)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}