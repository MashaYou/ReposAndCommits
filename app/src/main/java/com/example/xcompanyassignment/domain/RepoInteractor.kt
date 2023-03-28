package com.example.xcompanyassignment.domain

import com.example.xcompanyassignment.data.RepoRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class RepoInteractor @Inject constructor(
    private val repository: RepoRepository,
) {
    fun getRepositoryList(): Single<List<RepoData>> {
        return repository.getRepositories()
    }

    fun getRepositoryDetails(
        repositoryFullName:
        String, repoId: Long
    ): Single<List<CommitData>> {
        return repository.getRepositoryDetails(repositoryFullName, repoId)
    }
}