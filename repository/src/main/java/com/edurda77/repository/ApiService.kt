package com.edurda77.repository

import com.edurda77.mylibrary.WordTranslate
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(WORD_SEARCH)
    fun search(@Query(SEARCH) wordToSearch: String): Observable<List<WordTranslate>>
}