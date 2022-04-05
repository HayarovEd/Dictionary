package com.edurda77.dictionary.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.edurda77.dictionary.model.data.DESCRTIPTION
import com.edurda77.dictionary.model.data.NOTE_DESCRTIPTION
import com.edurda77.dictionary.model.data.HISTORY_TABLE
import com.edurda77.dictionary.model.data.WORD
import java.io.Serializable

@Entity(tableName = HISTORY_TABLE)
class HistoryEntity (
    @PrimaryKey
    @ColumnInfo(name = WORD)
    val word: String,
    @ColumnInfo(name = DESCRTIPTION)
    val description: String
): Serializable