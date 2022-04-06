package com.edurda77.dictionary.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = HISTORY_TABLE)
class HistoryEntity (
    @PrimaryKey
    @ColumnInfo(name = WORD)
    val word: String,
    @ColumnInfo(name = DESCRTIPTION)
    val description: String
): Serializable