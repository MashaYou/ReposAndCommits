package com.example.xcompanyassignment.ui.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class RepoDetailsArgs(
    val repoId: Long,
    val repoName: String,
    val description: String,
) : Parcelable {

    companion object {
        const val KEY = "args"
    }
}