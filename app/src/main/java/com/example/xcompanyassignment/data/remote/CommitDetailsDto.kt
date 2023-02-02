package com.example.xcompanyassignment.data.remote

import com.google.gson.annotations.SerializedName

internal class CommitDetailsDto(

    @SerializedName("commit")
    val commit: CommitDto,
)

internal class CommitDto(
    @SerializedName("author")
    val author: AuthorDto,

    @SerializedName("message")
    val message: String,
)

internal class AuthorDto(

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("date")
    val date: String,
)