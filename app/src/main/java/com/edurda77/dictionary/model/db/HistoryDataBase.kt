package com.edurda77.dictionary.model.db

import androidx.room.Database

@Database(
    entities = [HistoryEntity::class], version = 1, exportSchema =
    false
)
interface HistoryDataBase {
    abstract fun historyDao(): HistoryDao
}