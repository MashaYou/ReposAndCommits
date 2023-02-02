package com.example.xcompanyassignment.ui.list

import androidx.recyclerview.widget.DiffUtil

internal class RepoListDiffUtil : DiffUtil.ItemCallback<RepoRowItem>() {

    override fun areItemsTheSame(oldItem: RepoRowItem, newItem: RepoRowItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RepoRowItem, newItem: RepoRowItem): Boolean {
        return oldItem == newItem
    }
}