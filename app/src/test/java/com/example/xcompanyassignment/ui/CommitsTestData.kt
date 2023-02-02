package com.example.xcompanyassignment.ui

import com.example.xcompanyassignment.domain.Commit
import com.example.xcompanyassignment.ui.details.MonthStat
import org.junit.jupiter.params.provider.Arguments
import java.time.LocalDate

internal object CommitsTestData {
    private val defaultCommit = Commit(
        name = "",
        email = "",
        date = LocalDate.now(),
        message = "",
    )
    private val defaultMonthly = MonthStat(
        commitsAmount = 1,
        proportion = 1f,
        monthName = ""
    )

    @JvmStatic
    fun parameters() = listOf(
        Arguments.of(
            listOf(
                defaultCommit.copy(date = LocalDate.parse("2022-01-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-02-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-03-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-04-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-05-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-06-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-07-01")),
            ),
            listOf(
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "January"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "February"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "March"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "April"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "May"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "June"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "July"),
            )
        ),
        Arguments.of(
            listOf(
                defaultCommit.copy(date = LocalDate.parse("2022-01-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-03-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-04-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-05-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-06-01")),
                defaultCommit.copy(date = LocalDate.parse("2022-07-01")),
            ),
            listOf(
                defaultMonthly.copy(commitsAmount = 2, proportion = 1f, monthName = "January"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 0.5f, monthName = "March"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 0.5f, monthName = "April"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 0.5f, monthName = "May"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 0.5f, monthName = "June"),
                defaultMonthly.copy(commitsAmount = 1, proportion = 0.5f, monthName = "July"),
            )
        ),
        Arguments.of(
            listOf(
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
                defaultCommit.copy(date = LocalDate.parse("2022-01-31")),
            ),
            listOf(
                defaultMonthly.copy(commitsAmount = 7, proportion = 1f, monthName = "January"),
            )
        ),
        Arguments.of(
            listOf(
                defaultCommit.copy(date = LocalDate.parse("2022-01-01")),
            ),
            listOf(
                defaultMonthly.copy(commitsAmount = 1, proportion = 1f, monthName = "January"),
            )
        ),
    )
}