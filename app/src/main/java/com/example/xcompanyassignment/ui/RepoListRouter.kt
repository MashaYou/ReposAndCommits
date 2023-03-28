package com.example.xcompanyassignment.ui

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.xcompanyassignment.ui.details.RepoDetailsArgs
import com.example.xcompanyassignment.ui.list.RepoListFragmentDirections
import com.example.xcompanyassignment.ui.list.RepoRowItem

internal class RepoListRouter(
    private val fragment: Fragment?,
) {

    fun navToDetails(item: RepoRowItem) {
        fragment?.findNavController()?.navigate(
            RepoListFragmentDirections.actionRepoListFragmentToRepoDetailsFragment(
                RepoDetailsArgs(
                    item.id,
                    item.name,
                    item.description,
                )
            )
        )
    }
}