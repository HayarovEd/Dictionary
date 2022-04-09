package com.edurda77.mylibrary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = HISTORY_TABLE)
class HistoryEntity (
    @PrimaryKey
    @ColumnInfo(name = WORD)
    val word: String,
    @ColumnInfo(name = DESCRIPTION)
    val description: String
): Serializable