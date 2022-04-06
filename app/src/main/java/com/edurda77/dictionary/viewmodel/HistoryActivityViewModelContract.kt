package com.edurda77.dictionary.viewmodel

import androidx.lifecycle.LiveData
import com.edurda77.dictionary.model.data.HistoryEntity
import com.edurda77.dictionary.model.data.WordTranslate

interface HistoryActivityViewModelContract {
    abstract class ViewModel :androidx.lifecycle.ViewModel(){
        abstract val liveData:LiveData<List<HistoryEntity>>
        abstract fun deleteAllData()
        abstract fun getAllData()
    }

}