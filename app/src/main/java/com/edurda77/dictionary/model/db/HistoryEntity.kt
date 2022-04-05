package com.edurda77.dictionary.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.edurda77.dictionary.model.data.NOTE_DESCRTIPTION
import com.edurda77.dictionary.model.data.NOTE_TABLE
import com.edurda77.dictionary.model.data.NOTE_WORD

@Entity(tableName = NOTE_TABLE)
class HistoryEntity (
    @PrimaryKey
    @ColumnInfo(name = NOTE_WORD)
    val word: String,
    @ColumnInfo(name = NOTE_DESCRTIPTION)
    val description: String
)