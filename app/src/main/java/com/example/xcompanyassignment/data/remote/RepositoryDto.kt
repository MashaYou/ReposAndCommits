package com.example.xcompanyassignment.data.remote

import com.google.gson.annotations.SerializedName

internal class RepositoryDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("owner")
    val owner: OwnerDto,
)

internal class OwnerDto(
    @SerializedName("avatar_url")
    val imageUrl: String?,
)