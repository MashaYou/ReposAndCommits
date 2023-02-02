package com.example.xcompanyassignment.data.remote

import com.example.xcompanyassignment.data.toData
import com.example.xcompanyassignment.domain.Commit
import com.example.xcompanyassignment.domain.RepoData
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

internal class RemoteRepoStorage @Inject constructor(
    private val repositoriesApi: RepositoriesApi,
    private val scheduler: Scheduler,
) {

    fun getRepositoryList(): Single<List<RepoData>> {
        return repositoriesApi.getRepositories()
            .map { list -> list.map { it.toData() } }
            .subscribeOn(scheduler)
    }

    fun getRepositoryDetails(repositoryName: String): Single<List<Commit>> {
        return repositoriesApi.getRepositoryDetails(repositoryName)
            .map { list -> list.map { it.toData() } }
            .subscribeOn(scheduler)
    }
}