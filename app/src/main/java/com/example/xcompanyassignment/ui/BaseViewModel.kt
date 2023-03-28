package com.example.xcompanyassignment.ui

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

internal abstract class BaseViewModel : ViewModel() {

    private val viewModelDisposable = CompositeDisposable()

    protected val _progress: MutableLiveData<Boolean> = MutableLiveData(false)
    protected val _error: MutableLiveData<String?> = MutableLiveData()
    val progress: LiveData<Boolean> = _progress
    val error: LiveData<String?> = _error

    fun onDialogClosed() {
        _error.value = null
    }

    @CallSuper
    override fun onCleared() {
        viewModelDisposable.clear()
    }

    protected fun Disposable.disposeOnCleared() = viewModelDisposable.add(this)
}