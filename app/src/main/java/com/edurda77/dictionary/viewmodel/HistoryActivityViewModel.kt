package com.edurda77.dictionary.viewmodel

import androidx.lifecycle.MutableLiveData
import com.edurda77.dictionary.model.data.HistoryEntity
import com.edurda77.dictionary.model.db.HistoryDaoImpl

class HistoryActivityViewModel(
    private val historyDaoImpl: HistoryDaoImpl,
) :
    HistoryActivityViewModelContract.ViewModel() {
    override val liveData: MutableLiveData<List<HistoryEntity>> =
        MutableLiveData<List<HistoryEntity>>()

    override fun deleteAllData() {
        historyDaoImpl.clearNotes()
    }

    override fun getAllData() {
        Thread {
            liveData.postValue(historyDaoImpl.getAllRecords())
        }.start()
    }

}