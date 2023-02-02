package com.example.xcompanyassignment.domain

import java.time.LocalDate

internal data class Commit(
    val name: String,
    val email: String,
    val date: LocalDate,
    val message: String,
)