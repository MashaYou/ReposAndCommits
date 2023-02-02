package com.example.xcompanyassignment.ui

import android.content.Context
import android.util.TypedValue
import android.view.View
import java.time.LocalDate

internal fun View.makeVisibleOrGone(visibility: Boolean) {
    this.visibility = if (visibility) View.VISIBLE else View.GONE
}

internal fun LocalDate.getMonthName(): String {
    return month.name.lowercase().replaceFirstChar { it.uppercaseChar() }
}

internal fun Context.getColorFromTheme(colorAttr: Int) =
    TypedValue().also {
        theme.resolveAttribute(colorAttr, it, true)
    }.data