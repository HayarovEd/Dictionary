package com.edurda77.dictionary.viewmodel

import androidx.lifecycle.MutableLiveData
import com.edurda77.dictionary.model.data.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel(private val caseRepoImpl: CaseRepoImpl) :
    MainActivityViewModelContract.ViewModel() {

    override val liveData: MutableLiveData<List<WordTranslate>> =
        MutableLiveData<List<WordTranslate>>()

    override fun getData(searchWord: String) {
        val loadingData = caseRepoImpl.getData(searchWord)
        loadingData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())
    }

    private fun getObserver(): DisposableObserver<List<WordTranslate>> {
        return object : DisposableObserver<List<WordTranslate>>() {
            override fun onNext(wordTranslate: List<WordTranslate>) {
                liveData.postValue(wordTranslate)
            }

            override fun onError(error: Throwable) {
                error.message
            }

            override fun onComplete() {

            }

        }
    }
}