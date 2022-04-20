package com.edurda77.repository

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        assertNotNull(CaseRepoImpl(provideUserApi(provideRetrofit())).getData("кот"))
    }
    @Test
    fun addition_isCorrect2() {

        assertNotNull(CaseRepoImpl(provideUserApi(provideRetrofit())).getData(" "))
    }


    private fun provideUserApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}