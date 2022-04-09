package com.edurda77.dictionary.viewmodel

import androidx.lifecycle.MutableLiveData
import com.edurda77.mylibrary.HistoryEntity
import com.edurda77.repository.HistoryDaoImpl

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