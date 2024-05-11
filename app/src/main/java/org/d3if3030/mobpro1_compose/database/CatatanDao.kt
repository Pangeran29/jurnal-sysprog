package org.d3if3030.mobpro1_compose.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3030.model.Catatan

@Dao
interface CatatanDao {
    @Insert
    suspend fun insert(catatan: Catatan)

    @Update
    suspend fun update(catatan: Catatan)

    @Query("select * from catatan")
    fun get(): Flow<List<Catatan>>

    @Query("SELECT * FROM catatan WHERE book = :book order by topic")
     fun getByBook(book: String): Flow<List<Catatan>>

    @Query("select * from catatan where id = :id")
    fun getById(id: Long): Catatan?

    @Query("delete from catatan where id = :id")
    fun deleteById(id: Long)
}