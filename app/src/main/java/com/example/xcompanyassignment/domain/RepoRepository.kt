package com.example.xcompanyassignment.domain

import io.reactivex.Observable
import io.reactivex.Single

internal interface RepoRepository {
    fun getRepositories(): Observable<List<RepoData>>
    fun getRepositoryDetails(repositoryFullName: String): Single<List<Commit>>
}