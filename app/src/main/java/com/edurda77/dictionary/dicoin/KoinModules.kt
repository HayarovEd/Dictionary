package com.edurda77.dictionary.dicoin

import androidx.room.Room
import com.edurda77.dictionary.model.data.BASE_URL
import com.edurda77.dictionary.model.data.NAME_BD
import com.edurda77.repository.ApiService
import com.edurda77.repository.CaseRepoImpl
import com.edurda77.repository.HistoryDao
import com.edurda77.repository.HistoryDaoImpl
import com.edurda77.repository.HistoryDataBase
import com.edurda77.dictionary.viewmodel.HistoryActivityViewModel
import com.edurda77.dictionary.viewmodel.MainActivityViewModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val mainViewModelModule = module {
    viewModel { MainActivityViewModel(get(), get()) }
}
val historyViewModelModule = module {
    viewModel { HistoryActivityViewModel(get()) }
}
val apiModule = module {
    fun provideUserApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    single { provideUserApi(get()) }
}
val netModule = module {
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    single { provideRetrofit() }
    single {
        Room.databaseBuilder(
            get(), HistoryDataBase::class.java,
            NAME_BD
        ).build()
    }
    single { get<HistoryDataBase>().historyDao() }
}
val repositoryModule = module {
    fun provideUserRepository(api: ApiService): CaseRepoImpl {
        return CaseRepoImpl(api)
    }
    single { provideUserRepository(api=get()) }
}
val dbModule = module {
    single {
        Room.databaseBuilder(
            get(), HistoryDataBase::class.java,
            NAME_BD
        ).build()
    }
    single { get<HistoryDataBase>().historyDao() }
    fun provideUserRepositoryDb (historyDao: HistoryDao): HistoryDaoImpl {
        return HistoryDaoImpl(historyDao)
    }
    single { provideUserRepositoryDb(get()) }

}
