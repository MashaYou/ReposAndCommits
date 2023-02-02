package com.example.xcompanyassignment.domain

import io.reactivex.Observable
import javax.inject.Inject

internal class GetRepoListUseCase @Inject constructor(
    private val repository: RepoRepository,
) {
    fun getRepositories(): Observable<List<RepoData>> {
        return repository.getRepositories()
    }
}