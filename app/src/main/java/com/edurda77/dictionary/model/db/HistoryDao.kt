package com.edurda77.dictionary.model.db

import androidx.room.*
import com.edurda77.dictionary.model.data.HISTORY_TABLE
import com.edurda77.dictionary.model.data.HistoryEntity
import com.edurda77.dictionary.model.data.WORD
@Dao
interface HistoryDao {
    @Query("SELECT * FROM $HISTORY_TABLE")
    fun getAllRecords(): List<HistoryEntity>

    @Query("SELECT * FROM $HISTORY_TABLE WHERE $WORD=:word")
    fun getDataByWord(word: String): HistoryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: HistoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<HistoryEntity>)

    @Update
    fun update(entity: HistoryEntity)

    @Delete
    fun delete(entity: HistoryEntity)

    @Query("DELETE FROM $HISTORY_TABLE")
    fun clearNotes()
}