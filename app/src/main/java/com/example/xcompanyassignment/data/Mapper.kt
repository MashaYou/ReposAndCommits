package com.example.xcompanyassignment.data

import com.example.xcompanyassignment.data.local.CommitEntity
import com.example.xcompanyassignment.data.local.RepoEntity
import com.example.xcompanyassignment.data.remote.CommitDetailsDto
import com.example.xcompanyassignment.data.remote.RepositoryDto
import com.example.xcompanyassignment.domain.CommitData
import com.example.xcompanyassignment.domain.RepoData
import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal fun toEntity(dto: RepositoryDto) = with(dto) {
    RepoEntity(
        id = 0, // SQLite generates identifier automatically if ID = 0
        name = name,
        fullName = fullName,
        description = description,
        imageUrl = owner.imageUrl,
    )
}

internal fun CommitDetailsDto.toEntity(repoId: Long) = with(this.commit) {
    CommitEntity(
        id = 0, // SQLite generates identifier automatically if ID = 0
        sha = sha,
        repoId = repoId,
        message = message,
        name = author.name,
        email = author.email,
        date = author.date,
    )
}

internal fun toData(entity: RepoEntity) = with(entity) {
    RepoData(
        id = id,
        name = name,
        fullName = fullName,
        description = description,
        imageUrl = imageUrl,
    )
}
internal fun toData(entity: CommitEntity) = with(entity) {
    CommitData(
        id = id,
        sha = sha,
        repoId = repoId,
        message = message,
        name = name,
        email = email,
        date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME),
    )
}

internal fun toData(dto: RepositoryDto) = with(dto) {
    RepoData(
        id = id.toLong(),
        name = name,
        fullName = fullName,
        description = description,
        imageUrl = owner.imageUrl,
    )
}
internal fun toData(dto: CommitDetailsDto, repoId: Long) = with(dto) {
    CommitData(
        id = 0, // SQLite generates identifier automatically if ID = 0
        sha = sha,
        repoId = repoId,
        message = commit.message,
        name = commit.author.name,
        email = commit.author.email,
        date = LocalDate.parse(commit.author.date, DateTimeFormatter.ISO_DATE_TIME),
    )
}