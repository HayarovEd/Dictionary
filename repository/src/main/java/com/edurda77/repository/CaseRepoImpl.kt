package com.edurda77.repository

import com.edurda77.mylibrary.WordTranslate
import com.edurda77.repository.ApiService
import com.edurda77.repository.CaseRepo
import io.reactivex.rxjava3.core.Observable


class CaseRepoImpl (private val api: ApiService) : CaseRepo {
    override fun getData(searchWord: String): Observable<List<WordTranslate>> {
        return api.search(searchWord)
    }
}