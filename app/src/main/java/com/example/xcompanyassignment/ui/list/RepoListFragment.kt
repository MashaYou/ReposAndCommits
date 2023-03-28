package com.example.xcompanyassignment.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcompanyassignment.R
import com.example.xcompanyassignment.databinding.FragmentRepoListBinding
import com.example.xcompanyassignment.ui.BaseFragment
import com.example.xcompanyassignment.ui.RepoListRouter
import com.example.xcompanyassignment.ui.details.RepoDetailsArgs
import com.example.xcompanyassignment.ui.makeVisibleOrGone
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class RepoListFragment : BaseFragment<RepoListViewModel, FragmentRepoListBinding>(
    layout = R.layout.fragment_repo_list,
    inflate = FragmentRepoListBinding::inflate,
) {

    override val viewModel: RepoListViewModel by viewModels()
    private val adapter = RepoListAdapter()
    private val router = RepoListRouter(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentRepoListBinding.bind(view)
        binding?.apply {
            swipeContainer.setOnRefreshListener { viewModel.onSwipe() }
            list.adapter = adapter
            list.layoutManager = LinearLayoutManager(context)
            toolbar.title = resources.getString(R.string.repos_list_title)
            this@RepoListFragment.progress = progress
            this@RepoListFragment.emptyView = emptyText
        }

        adapter.onItemClickListener = { rowItem ->
            binding?.swipeContainer?.isRefreshing = false
            router.navToDetails(
                item = rowItem,
            )
        }
        viewModel.itemsLiveData.observe(viewLifecycleOwner, ::setItems)
        viewModel.loadItems()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setItems(list: List<RepoRowItem>?) {
        progress?.makeVisibleOrGone(false)
        binding?.swipeContainer?.isRefreshing = false
        list?.let {
            adapter.submitList(it)
            val empty = list.isEmpty()
            emptyView?.makeVisibleOrGone(empty)
            binding?.list?.makeVisibleOrGone(!empty)
        }
    }
}