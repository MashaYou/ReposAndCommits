package com.example.xcompanyassignment.ui.details

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.xcompanyassignment.domain.CommitData
import com.example.xcompanyassignment.domain.RepoInteractor
import com.example.xcompanyassignment.ui.BaseViewModel
import com.example.xcompanyassignment.ui.getMonthName
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
internal class RepoDetailsViewModel @Inject constructor(
    private val repoInteractor: RepoInteractor,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {

    private val _monthStat: MutableLiveData<MonthStat> = MutableLiveData()
    val monthStat: LiveData<MonthStat> = _monthStat

    private val _repositoryName: MutableLiveData<String> = MutableLiveData()
    val repositoryName: LiveData<String> = _repositoryName

    private val _description: MutableLiveData<String> = MutableLiveData()
    val description: LiveData<String> = _description

    private val args: RepoDetailsArgs? = savedStateHandle[RepoDetailsArgs.KEY]

    init {
        _repositoryName.value = args?.repoName
        _description.value = args?.description
        loadItems()
    }

    private fun loadItems() {
        _progress.value = true
        args?.apply {
            repoInteractor.getRepositoryDetails(repoName, repoId)
                .flatMapObservable { commits ->
                    Observable.fromIterable(commits.toMonthStats())
                }
                .zipWith(
                    Observable.interval(
                        0,
                        1500,
                        TimeUnit.MILLISECONDS,
                    )
                ) { item, _ ->
                    item
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onSuccess, ::onError)
                .disposeOnCleared()
        }
    }

    private fun onSuccess(data: MonthStat) {
        _progress.value = false
        _monthStat.value = data
    }

    private fun onError(error: Throwable) {
        _progress.value = false
        _error.value = error.message
        error.printStackTrace()
    }
}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
internal fun List<CommitData>.toMonthStats(): List<MonthStat> {
    val map = this.sortedBy { it.date }
        .groupBy { it.date.getMonthName() }
        .mapValues { it.value.size }

    val maxCommitsInMonth = map.maxOf { (_, commitsNumber) ->
        commitsNumber
    }
    val result = map.map { (monthName, commitsNumber) ->
        MonthStat(
            commitsAmount = commitsNumber,
            proportion = commitsNumber.toFloat() / maxCommitsInMonth,
            monthName = monthName,
        )
    }
    return result
}