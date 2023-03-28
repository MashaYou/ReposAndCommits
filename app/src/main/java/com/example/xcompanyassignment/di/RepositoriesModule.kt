package com.example.xcompanyassignment.di

import com.example.xcompanyassignment.data.RepoRepository
import com.example.xcompanyassignment.data.RepositoriesRepositoryImpl
import com.example.xcompanyassignment.data.local.AppDatabase
import com.example.xcompanyassignment.data.local.LocalRepoStorage
import com.example.xcompanyassignment.data.remote.RemoteRepoStorage
import com.example.xcompanyassignment.data.remote.RepositoriesApi
import com.example.xcompanyassignment.domain.*
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
internal class RepositoriesModule {
    @Provides
    @Reusable
    fun provideRepositoriesRepository(
        remoteStorage: RemoteRepoStorage,
        localStorage: LocalRepoStorage,
    ): RepoRepository {
        return RepositoriesRepositoryImpl(remoteStorage, localStorage)
    }

    @Provides
    @Reusable
    fun provideRemoteStorage(
        api: RepositoriesApi,
        @IOScheduler scheduler: Scheduler,
    ): RemoteRepoStorage {
        return RemoteRepoStorage(api, scheduler)
    }

    @Provides
    @Reusable
    fun provideLocalStorage(
        db: AppDatabase,
        @IOScheduler scheduler: Scheduler,
    ): LocalRepoStorage {
        return LocalRepoStorage(db, scheduler)
    }
}