package com.edurda77.dictionary.model.datasource

import com.edurda77.dictionary.model.data.WordTranslate
import io.reactivex.rxjava3.core.Observable


class CaseRepoImpl (private val api: ApiService) : CaseRepo {
    override fun getData(searchWord: String): Observable<List<WordTranslate>> {
        return api.search(searchWord)
    }
}