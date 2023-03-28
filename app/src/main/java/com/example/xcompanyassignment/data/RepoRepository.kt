package com.example.xcompanyassignment.data

import com.example.xcompanyassignment.domain.CommitData
import com.example.xcompanyassignment.domain.RepoData
import io.reactivex.Observable
import io.reactivex.Single

internal interface RepoRepository {
    fun getRepositories(): Single<List<RepoData>>
    fun getRepositoryDetails(repositoryFullName: String, repoId: Long): Single<List<CommitData>>
}