package com.example.xcompanyassignment.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.xcompanyassignment.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @ApplicationContext
    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext

    @IOScheduler
    @Provides
    @Singleton
    fun provideIOScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
    }
}