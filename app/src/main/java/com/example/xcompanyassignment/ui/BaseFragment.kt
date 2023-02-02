package com.example.xcompanyassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.viewbinding.ViewBinding

internal typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

internal abstract class BaseFragment<VM : BaseViewModel, B : ViewBinding>(
    layout: Int,
    private val inflate: Inflate<B>,
) : Fragment(layout) {

    protected abstract val viewModel: VM
    protected var binding: B? = null
    var progress: ProgressBar? = null
    var emptyView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.progress.observe(viewLifecycleOwner, ::showProgress)
        viewModel.error.observe(viewLifecycleOwner, ::showError)
    }

    private fun showProgress(show: Boolean) {
        progress?.makeVisibleOrGone(show)
    }

    private fun showError(message: String?) {
        message?.let {
            val dialog = SimpleErrorDialog()
            dialog.message = message
            dialog.show(childFragmentManager, SimpleErrorDialog.TAG)
            dialog.setFragmentResultListener(SimpleErrorDialog.TAG) { _, _ ->
                viewModel.onDialogClosed()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}