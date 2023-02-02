package com.example.xcompanyassignment.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.xcompanyassignment.R

internal class RepoListAdapter :
    ListAdapter<RepoRowItem, RepoListAdapter.RepoViewHolder>(RepoListDiffUtil()) {

    var onItemClickListener: ((RepoRowItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RepoViewHolder(inflater.inflate(R.layout.repository_item, parent, false))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val item = currentList[position]
        holder.apply {
            name.text = item.name
            description.text = item.description
            itemView.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
            Glide.with(imageView)
                .load(item.imageUrl)
                .placeholder(R.color.purple_200)
                .into(imageView)
        }
    }

    inner class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.repository_name)
        val description: TextView = view.findViewById(R.id.repository_description)
        val imageView: ImageView = view.findViewById(R.id.image)
    }
}