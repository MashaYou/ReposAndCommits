package com.example.xcompanyassignment.data

import com.example.xcompanyassignment.data.local.RepoEntity
import com.example.xcompanyassignment.data.remote.CommitDetailsDto
import com.example.xcompanyassignment.data.remote.RepositoryDto
import com.example.xcompanyassignment.domain.Commit
import com.example.xcompanyassignment.domain.RepoData
import okhttp3.internal.toLongOrDefault
import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal fun RepositoryDto.toData(): RepoData {
    return with(this) {
        RepoData(
            id = id,
            name = name,
            fullName = fullName,
            description = description,
            imageUrl = owner.imageUrl,
        )
    }
}

internal fun CommitDetailsDto.toData(): Commit {
    return with(this.commit) {
        Commit(
            message = message,
            name = author.name,
            email = author.email,
            date = LocalDate.parse(author.date, DateTimeFormatter.ISO_DATE_TIME),
        )
    }
}

internal fun RepoEntity.toData(): RepoData {
    return with(this) {
        RepoData(
            id = id.toString(),
            name = name,
            fullName = fullName,
            description = description,
            imageUrl = imageUrl,
        )
    }
}

internal fun RepoData.toEntity(): RepoEntity {
    return with(this) {
        RepoEntity(
            id = id.toLongOrDefault(0),
            name = name,
            fullName = fullName,
            description = description,
            imageUrl = imageUrl,
        )
    }
}
