package com.example.xcompanyassignment.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.xcompanyassignment.domain.RepoData
import com.example.xcompanyassignment.domain.RepoInteractor
import com.example.xcompanyassignment.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
internal class RepoListViewModel @Inject constructor(
    private val repoInteractor: RepoInteractor,
) : BaseViewModel() {

    private val _itemsLiveData: MutableLiveData<List<RepoRowItem>?> = MutableLiveData()
    val itemsLiveData: LiveData<List<RepoRowItem>?> = _itemsLiveData

    init {
        loadItems()
    }

    fun onSwipe() {
        loadItems()
    }

    private fun loadItems() {
        _progress.value = true
        repoInteractor.getRepositoryList()
            .map { list ->
                list.map { it.toRow() }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate { _progress.value = false }
            .subscribe(::onSuccess, ::onError)
            .disposeOnCleared()
    }

    private fun onSuccess(list: List<RepoRowItem>) {
        _itemsLiveData.value = list
    }

    private fun onError(error: Throwable) {
        _error.value = error.message
        error.printStackTrace()
    }
}

private fun RepoData.toRow(): RepoRowItem {
    return with(this) {
        RepoRowItem(
            id = id,
            name = name,
            fullName = fullName,
            description = description.orEmpty(),
            imageUrl = imageUrl,
        )
    }
}