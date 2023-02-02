package com.example.xcompanyassignment.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RepositoriesApi {

    @GET("users/mralexgray/repos")
    fun getRepositories(): Single<List<RepositoryDto>>

    @GET("repos/mralexgray/{repositoryName}/commits")
    fun getRepositoryDetails(
        @Path("repositoryName") repositoryName: String
    ): Single<List<CommitDetailsDto>>
}