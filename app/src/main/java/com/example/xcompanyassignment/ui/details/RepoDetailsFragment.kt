package com.example.xcompanyassignment.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.xcompanyassignment.R
import com.example.xcompanyassignment.databinding.FragmentRepoDetailsBinding
import com.example.xcompanyassignment.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class RepoDetailsFragment : BaseFragment<RepoDetailsViewModel, FragmentRepoDetailsBinding>(
    layout = R.layout.fragment_repo_details,
    inflate = FragmentRepoDetailsBinding::inflate,
) {

    override val viewModel: RepoDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        progress = binding?.progress
        viewModel.monthStat.observe(viewLifecycleOwner, ::setData)
        viewModel.repositoryName.observe(viewLifecycleOwner, ::setRepoName)
        viewModel.description.observe(viewLifecycleOwner, ::setDescription)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setData(info: MonthStat) {
        binding?.commitsView?.setData(
            commitsAmount = info.commitsAmount,
            proportion = info.proportion,
            month = info.monthName,
        )
    }

    private fun setRepoName(name: String) {
        binding?.apply {
            toolbar.title = name
        }
    }

    private fun setDescription(desc: String) {
        binding?.apply {
            description.text = desc
        }
    }
}