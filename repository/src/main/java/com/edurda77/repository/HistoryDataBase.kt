package com.edurda77.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edurda77.mylibrary.HistoryEntity
import com.edurda77.repository.HistoryDao

@Database(
    entities = [HistoryEntity::class], version = 1, exportSchema =
    false
)
abstract class HistoryDataBase  : RoomDatabase(){
    abstract fun historyDao(): HistoryDao
}