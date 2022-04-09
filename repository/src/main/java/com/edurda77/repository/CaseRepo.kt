package com.edurda77.repository

import com.edurda77.mylibrary.WordTranslate
import io.reactivex.rxjava3.core.Observable


interface CaseRepo {
    fun getData (searchWord:String): Observable<List<WordTranslate>>

}