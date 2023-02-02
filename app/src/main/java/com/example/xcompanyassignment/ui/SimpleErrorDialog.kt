package com.example.xcompanyassignment.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.xcompanyassignment.R

internal class SimpleErrorDialog : DialogFragment() {

    companion object {
        const val TAG = "SimpleErrorDialog"
        private const val ERROR_TITLE = "Error"
        private const val EXCEPTION_MESSAGE = "Activity cannot be null"
    }

    var message: String? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(ERROR_TITLE)
            builder.setMessage(message ?: resources.getString(R.string.default_error_text))
                .setNegativeButton(R.string.common_error_btn) { _, _ ->
                    setFragmentResult(TAG, Bundle.EMPTY)
                }
            builder.create()
        } ?: throw IllegalStateException(EXCEPTION_MESSAGE)
    }
}