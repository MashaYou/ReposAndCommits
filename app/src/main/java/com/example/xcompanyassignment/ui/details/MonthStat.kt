package com.example.xcompanyassignment.ui.details

/**
 * Data for [CommitView]
 *
 * @param commitsAmount amount of commits in given month
 * @param proportion proportion to the number of commits in the given month vs
 * the maximum commits in a month for that repository. Number in 0..1.
 * @param monthName given month name
 */
internal data class MonthStat(
    val commitsAmount: Int,
    val proportion: Float,
    val monthName: String,
)