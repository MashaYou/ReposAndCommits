package com.example.xcompanyassignment.data

import com.example.xcompanyassignment.data.local.LocalRepoStorage
import com.example.xcompanyassignment.data.remote.RemoteRepoStorage
import com.example.xcompanyassignment.domain.CommitData
import com.example.xcompanyassignment.domain.RepoData
import com.example.xcompanyassignment.mapList
import io.reactivex.Single

internal class RepositoriesRepositoryImpl(
    private val remoteStorage: RemoteRepoStorage,
    private val localStorage: LocalRepoStorage,
) : RepoRepository {

    override fun getRepositories(): Single<List<RepoData>> {
        return remoteStorage.getRepositoryList()
            .doOnSuccess { newRepos -> localStorage.replaceRepositories((newRepos)) }
            .mapList(::toData)
            .onErrorReturn { localStorage.getRepositoryList() }
    }

    override fun getRepositoryDetails(
        repositoryFullName: String,
        repoId: Long
    ): Single<List<CommitData>> {
        return remoteStorage.getCommits(repositoryFullName)
            .doOnSuccess { newCommits -> localStorage.replaceCommits(newCommits, repoId) }
            .map { list -> list.map { toData(it, repoId) } }
            .onErrorReturn { localStorage.getCommitsList(repoId)}
    }
}