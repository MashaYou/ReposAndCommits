package com.example.xcompanyassignment.domain

import java.time.LocalDate

internal data class CommitData(
    val id: Long,
    val sha: String,
    val repoId: Long,
    val name: String,
    val email: String,
    val date: LocalDate,
    val message: String,
)