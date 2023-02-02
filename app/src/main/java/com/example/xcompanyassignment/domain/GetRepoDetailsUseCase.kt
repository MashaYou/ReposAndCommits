package com.example.xcompanyassignment.domain

import io.reactivex.Single
import javax.inject.Inject

internal class GetRepoDetailsUseCase @Inject constructor(
    private val repository: RepoRepository,
) {
    fun getRepositoryDetails(repositoryFullName: String): Single<List<Commit>> {
        return repository.getRepositoryDetails(repositoryFullName)
    }
}