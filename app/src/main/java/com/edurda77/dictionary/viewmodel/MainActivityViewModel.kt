package com.edurda77.dictionary.viewmodel

import androidx.lifecycle.MutableLiveData
import com.edurda77.mylibrary.HistoryEntity
import com.edurda77.mylibrary.WordTranslate
import com.edurda77.repository.CaseRepoImpl
import com.edurda77.repository.HistoryDaoImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivityViewModel(
    private val caseRepoImpl: CaseRepoImpl,
    private val historyDaoImpl: HistoryDaoImpl
) :
    MainActivityViewModelContract.ViewModel() {

    override val liveData: MutableLiveData<List<WordTranslate>> =
        MutableLiveData<List<WordTranslate>>()

    override fun getData(searchWord: String) {
        val loadingData = caseRepoImpl.getData(searchWord)
        loadingData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver(searchWord))

    }

    private fun getObserver(searchWord: String): DisposableObserver<List<WordTranslate>> {
        return object : DisposableObserver<List<WordTranslate>>() {
            override fun onNext(wordTranslate: List<WordTranslate>) {
                liveData.postValue(wordTranslate)
                Thread {
                    val sb = StringBuilder()
                    wordTranslate.forEach {
                        sb.append(it.text + ", ")
                    }
                    historyDaoImpl.insert(HistoryEntity(searchWord, sb.toString()))
                }.start()
            }

            override fun onError(error: Throwable) {
                error.message
            }

            override fun onComplete() {

            }

        }
    }
}