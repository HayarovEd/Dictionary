package com.edurda77.repository

import com.edurda77.mylibrary.HistoryEntity
import com.edurda77.repository.HistoryDao

class HistoryDaoImpl(private val historyDao: HistoryDao) : HistoryDao {
    override fun getAllRecords() =
        historyDao.getAllRecords()


    override fun getDataByWord(word: String) =
        historyDao.getDataByWord(word)


    override fun insert(entity: HistoryEntity) {
        historyDao.insert(entity)
    }

    override fun insertAll(entities: List<HistoryEntity>) {
        historyDao.insertAll(entities)
    }

    override fun update(entity: HistoryEntity) {
        historyDao.update(entity)
    }

    override fun delete(entity: HistoryEntity) {
        historyDao.delete(entity)
    }

    override fun clearNotes() {
        historyDao.clearNotes()
    }
}