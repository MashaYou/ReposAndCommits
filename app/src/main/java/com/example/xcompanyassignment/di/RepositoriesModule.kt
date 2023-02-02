package com.example.xcompanyassignment.di

import com.example.xcompanyassignment.data.local.AppDatabase
import com.example.xcompanyassignment.data.local.LocalRepoStorage
import com.example.xcompanyassignment.data.remote.RemoteRepoStorage
import com.example.xcompanyassignment.data.remote.RepositoriesApi
import com.example.xcompanyassignment.domain.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class RepositoriesModule {
    @Provides
    @Singleton
    fun provideRepositoriesRepository(
        remoteStorage: RemoteRepoStorage,
        localStorage: LocalRepoStorage,
    ): RepoRepository {
        return RepositoriesRepositoryImpl(remoteStorage, localStorage)
    }

    @Provides
    @Singleton
    fun provideRemoteStorage(
        api: RepositoriesApi,
        @IOScheduler scheduler: Scheduler,
    ): RemoteRepoStorage {
        return RemoteRepoStorage(api, scheduler)
    }

    @Provides
    @Singleton
    fun provideLocalStorage(
        db: AppDatabase,
        @IOScheduler scheduler: Scheduler,
    ): LocalRepoStorage {
        return LocalRepoStorage(db, scheduler)
    }
}