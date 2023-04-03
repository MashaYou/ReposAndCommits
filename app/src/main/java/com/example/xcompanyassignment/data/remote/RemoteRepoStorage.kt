package com.example.xcompanyassignment.data.remote

import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

internal class RemoteRepoStorage @Inject constructor(
    private val repositoriesApi: RepositoriesApi,
    private val scheduler: Scheduler,
) {
    fun getRepositoryList(): Single<List<RepositoryDto>> {
        return repositoriesApi.getRepositories()
            .subscribeOn(scheduler)
    }

    fun getCommits(repositoryName: String): Single<List<CommitDetailsDto>> {
        return repositoriesApi.getCommits(repositoryName)
            .subscribeOn(scheduler)
    }
}