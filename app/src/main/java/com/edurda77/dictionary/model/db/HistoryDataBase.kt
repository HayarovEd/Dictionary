package com.edurda77.dictionary.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edurda77.dictionary.model.data.HistoryEntity

@Database(
    entities = [HistoryEntity::class], version = 1, exportSchema =
    false
)
abstract class HistoryDataBase  : RoomDatabase(){
    abstract fun historyDao(): HistoryDao
}