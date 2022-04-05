package com.edurda77.dictionary.model.db

import androidx.room.*
import com.edurda77.dictionary.model.data.NOTE_TABLE
import com.edurda77.dictionary.model.data.NOTE_WORD

interface HistoryDao {
    @Query("SELECT * FROM $NOTE_TABLE")
    fun getAllRecords(): List<HistoryEntity>

    @Query("SELECT * FROM $NOTE_TABLE WHERE $NOTE_WORD=:word")
    fun getDataByWord(word: String): HistoryEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: HistoryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(entities: List<HistoryEntity>)

    @Update
    fun update(entity: HistoryEntity)

    @Delete
    fun delete(entity: HistoryEntity)

    @Query("DELETE FROM $NOTE_TABLE")
    fun clearNotes()
}