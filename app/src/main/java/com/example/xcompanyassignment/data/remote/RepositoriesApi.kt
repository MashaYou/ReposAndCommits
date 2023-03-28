package com.example.xcompanyassignment.data.remote

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RepositoriesApi {

    @GET("users/mashayou/repos")
    fun getRepositories(): Single<List<RepositoryDto>>

    @GET("repos/mashayou/{repositoryName}/commits")
    fun getCommits(
        @Path("repositoryName") repositoryName: String
    ): Single<List<CommitDetailsDto>>
}