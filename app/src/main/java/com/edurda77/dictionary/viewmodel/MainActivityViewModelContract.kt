package com.edurda77.dictionary.viewmodel

import androidx.lifecycle.LiveData
import com.edurda77.mylibrary.WordTranslate

interface MainActivityViewModelContract {
    abstract class ViewModel :androidx.lifecycle.ViewModel(){
        abstract val liveData:LiveData<List<WordTranslate>>
        abstract fun getData(searchWord: String)
    }

}