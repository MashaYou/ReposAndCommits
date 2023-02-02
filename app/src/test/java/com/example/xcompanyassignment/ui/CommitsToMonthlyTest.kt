package com.example.xcompanyassignment.ui

import com.example.xcompanyassignment.domain.Commit
import com.example.xcompanyassignment.ui.details.MonthStat
import com.example.xcompanyassignment.ui.details.toMonthStats
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class CommitsToMonthlyTest {

    @ParameterizedTest
    @MethodSource("com.example.xcompanyassignment.ui.CommitsTestData#parameters")
    fun `commits to monthly equals test`(list: List<Commit>, expected: List<MonthStat>) {
        assertIterableEquals(expected, list.toMonthStats())
    }
}