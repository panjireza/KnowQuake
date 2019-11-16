package com.sample.knowquake.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.sample.knowquake.rx.AppSchedulerProvider
import com.sample.knowquake.rx.SchedulerProvider
import com.sample.knowquake.util.AppExecutors
import com.sample.knowquake.vo.Constants
import com.sample.knowquake.vo.DataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Singleton
    @Provides
    fun providePrefs(app: Application): SharedPreferences =
        app.applicationContext.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun providePrefsEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor =
        sharedPreferences.edit()

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Singleton
    @Provides
    fun provideDataStore(): DataStore = DataStore()

    @Provides
    fun provideAppExecutors(): AppExecutors = AppExecutors()

}