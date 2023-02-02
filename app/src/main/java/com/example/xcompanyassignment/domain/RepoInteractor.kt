package com.example.xcompanyassignment.domain

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class RepoInteractor @Inject constructor(
    private val repoListUseCase: GetRepoListUseCase,
    private val repoDetailsUseCase: GetRepoDetailsUseCase,
) {
    fun getRepositoryList(): Observable<List<RepoData>> {
        return repoListUseCase.getRepositories()
    }

    fun getRepositoryDetails(repositoryFullName: String): Single<List<Commit>> {
        return repoDetailsUseCase.getRepositoryDetails(repositoryFullName)
    }
}